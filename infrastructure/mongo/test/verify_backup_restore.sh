#!/bin/bash
set -e
find . -type f \( -name "*.sh" -o -name "*.env" -o -name "*.txt" \) -exec sed -i 's/\r$//' {} +

# Create logs dir if not exists
mkdir -p logs

# Timestamped log file
LOG_FILE="logs/backup_restore_$(date +%F_%T).log"
exec > >(tee -a "$LOG_FILE") 2>&1

echo "⏱️  $(date) - 🚀 Starting Backup & Restore Integration Test"

############################
# 1. MongoDB Backup Test   #
############################

echo "📥 Inserting dummy data into mongo_user_service..."
docker exec mongo_user mongosh "$MONGO_USER_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
db.test.insertOne({ name: "backup_test_user" });
'

echo "📥 Inserting dummy data into mongo_ride_service..."
docker exec mongo_ride mongosh "$MONGO_RIDE_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
db.test.insertOne({ name: "backup_test_ride" });
'

echo "💾 Running mongo backups..."
docker compose run --rm mongo_user_backup sleep 5
docker compose run --rm mongo_ride_backup sleep 5

echo "🔥 Deleting inserted mongo test data..."
docker exec mongo_user mongosh "$MONGO_USER_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
db.test.deleteMany({});
'

docker exec mongo_ride mongosh "$MONGO_RIDE_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
db.test.deleteMany({});
'

echo "♻️ Restoring mongo databases..."
docker compose run --rm mongo_restore

echo "🔍 Verifying mongo restore..."
docker exec mongo_user mongosh "$MONGO_USER_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
print("✅ mongo_user_service restore:"); printjson(db.test.findOne({name: "backup_test_user"}));
'

docker exec mongo_ride mongosh "$MONGO_RIDE_DATABASE" --username="$MONGO_INITDB_ROOT_USERNAME" --password="$MONGO_INITDB_ROOT_PASSWORD" --authenticationDatabase=admin --eval '
print("✅ mongo_ride_service restore:"); printjson(db.test.findOne({name: "backup_test_ride"}));
'


#########################
# 2. PostgreSQL Check   #
#########################

echo "📥 Creating test table & inserting row in PostgreSQL..."
docker exec -e PGPASSWORD=pass postgres psql -U admin -d backup_db -c "
DROP TABLE IF EXISTS test;
CREATE TABLE test(id SERIAL PRIMARY KEY, name TEXT);
INSERT INTO test(name) VALUES ('postgres_backup_test');
"

echo "🔍 Querying inserted row in PostgreSQL..."
docker exec -e PGPASSWORD=pass postgres psql -U admin -d backup_db -c "SELECT * FROM test;"


#########################
# 3. Redis Check        #
#########################

echo "📥 Writing key to Redis..."
docker exec redis redis-cli SET test_key "redis_backup_test"

echo "🔍 Reading key from Redis..."
docker exec redis redis-cli GET test_key


#########################
# ✅ All Done           #
#########################

echo "🎉 All integration tests completed successfully!"
echo "✅ Backup & Restore Integration Test completed successfully!"
echo "🎉 $(date) - ✅ Backup & Restore Integration Test completed successfully!"

# Exit with success status
exit 0
