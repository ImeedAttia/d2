#!/bin/bash

while true; do
  sleep 3600
  TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)
  echo "⏳ Dumping mongo_user_service at $TIMESTAMP"
  mongodump --host=mongo_user \
            --username="$MONGO_INITDB_ROOT_USERNAME" \
            --password="$MONGO_INITDB_ROOT_PASSWORD" \
            --authenticationDatabase=admin \
            --db="$MONGO_USER_DATABASE" \
            --out=/backup/$TIMESTAMP
done
