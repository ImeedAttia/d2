#!/bin/bash
echo "♻️  Restoring MongoDB from /backup..."

mongorestore --host=mongo_user \
  --username="$MONGO_INITDB_ROOT_USERNAME" \
  --password="$MONGO_INITDB_ROOT_PASSWORD" \
  --authenticationDatabase=admin \
  --db="$MONGO_USER_DATABASE" \
  --drop /restore/latest/mongo_user

mongorestore --host=mongo_ride \
  --username="$MONGO_INITDB_ROOT_USERNAME" \
  --password="$MONGO_INITDB_ROOT_PASSWORD" \
  --authenticationDatabase=admin \
  --db="$MONGO_RIDE_DATABASE" \
  --drop /restore/latest/mongo_ride

echo "✅ Restore completed."
