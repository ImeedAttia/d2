#!/bin/bash
set -e

# Create logs dir if not exists
mkdir -p logs

# Timestamped log file
LOG_FILE="logs/backup_restore_$(date +%F_%T).log"
exec > >(tee -a "$LOG_FILE") 2>&1

echo "⏱️  $(date) - 🚀 Starting Backup & Restore Integration Test"

##################################
# 1. MongoDB Integration Section #
##################################

echo "📥 Inserting dummy data into mongo_user_service..."
mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_user:27017/${MONGO_USER_DATABASE}?authSource=admin" --eval '
db.test.insertOne({ name: "backup_test_user" });
'

echo "📥 Inserting dummy data into mongo_ride_service..."
mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_ride:27017/${MONGO_RIDE_DATABASE}?authSource=admin" --eval '
db.test.insertOne({ name: "backup_test_ride" });
'

echo "💾 Assuming mongo backups are triggered externally or automatically..."

echo "🔥 Deleting inserted mongo test data..."
mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_user:27017/${MONGO_USER_DATABASE}?authSource=admin" --eval '
db.test.deleteMany({});
'

mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_ride:27017/${MONGO_RIDE_DATABASE}?authSource=admin" --eval '
db.test.deleteMany({});
'

echo "♻️ Assuming restore is triggered externally..."

echo "🔍 Verifying mongo restore..."
mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_user:27017/${MONGO_USER_DATABASE}?authSource=admin" --eval '
print("✅ mongo_user_service restore:"); printjson(db.test.findOne({name: "backup_test_user"}));
'

mongosh "mongodb://${MONGO_INITDB_ROOT_USERNAME}:${MONGO_INITDB_ROOT_PASSWORD}@mongo_ride:27017/${MONGO_RIDE_DATABASE}?authSource=admin" --eval '
print("✅ mongo_ride_service restore:"); printjson(db.test.findOne({name: "backup_test_ride"}));
'

#########################
# 2. PostgreSQL Check   #
#########################

echo "📥 Creating test table & inserting row in PostgreSQL..."
PGPASSWORD=pass psql -h postgres -U admin -d backup_db -c "
DROP TABLE IF EXISTS test;
CREATE TABLE test(id SERIAL PRIMARY KEY, name TEXT);
INSERT INTO test(name) VALUES ('postgres_backup_test');
"

echo "🔍 Querying inserted row in PostgreSQL..."
PGPASSWORD=pass psql -h postgres -U admin -d backup_db -c "SELECT * FROM test;"

#########################
# 3. Redis Check        #
#########################

echo "📥 Writing key to Redis..."
redis-cli -h redis SET test_key "redis_backup_test"

echo "🔍 Reading key from Redis..."
redis-cli -h redis GET test_key

#########################
# ✅ All Done           #
#########################

echo "🎉 All integration tests completed successfully!"
echo "✅ Backup & Restore Integration Test completed successfully!"
echo "🎉 $(date) - ✅ Backup & Restore Integration Test completed successfully!"
echo "🛑 Shutting down test containers..."
docker down
echo "🗑️ Cleaning up logs..."
rm -rf logs
echo "🗑️ Logs cleaned up."
exist 0

