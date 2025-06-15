#!/bin/bash

while true; do
  sleep 10800
  TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)
  echo "⏳ Dumping mongo_ride_service at $TIMESTAMP"
  mongodump --host=mongo_ride \
            --username="$MONGO_INITDB_ROOT_USERNAME" \
            --password="$MONGO_INITDB_ROOT_PASSWORD" \
            --authenticationDatabase=admin \
            --db="$MONGO_RIDE_DATABASE" \
            --out="/backup/mongo_ride/$TIMESTAMP"
done

# Update the 'latest' symlink or folder so restore.sh can work
rm -rf /backup/latest/mongo_user
mkdir -p /backup/latest
cp -r "/backup/mongo_rid/$TIMESTAMP/$MONGO_USER_DATABASE" /backup/latest/mongo_user

echo "✅ Backup complete and latest snapshot updated"