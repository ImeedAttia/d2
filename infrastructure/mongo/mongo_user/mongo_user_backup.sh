#!/bin/bash

TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)

echo "⏳ Dumping $MONGO_USER_DATABASE at $TIMESTAMP"

# Dump the database to a timestamped directory
mongodump --host=mongo_user \
          --username="$MONGO_INITDB_ROOT_USERNAME" \
          --password="$MONGO_INITDB_ROOT_PASSWORD" \
          --authenticationDatabase=admin \
          --db="$MONGO_USER_DATABASE" \
          --out="/backup/mongo_user/$TIMESTAMP"

# Update the 'latest' symlink or folder so restore.sh can work
rm -rf /backup/latest/mongo_user
mkdir -p /backup/latest
cp -r "/backup/mongo_user/$TIMESTAMP/$MONGO_USER_DATABASE" /backup/latest/mongo_user

echo "✅ Backup complete and latest snapshot updated"