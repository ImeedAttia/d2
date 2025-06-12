#!/bin/bash

while true; do
  sleep 3600
  TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)
  echo "⏳ Dumping at $TIMESTAMP"
  mongodump --host=mongo_user \
            --username="$MONGO_INITDB_ROOT_USERNAME" \
            --password="$MONGO_INITDB_ROOT_PASSWORD" \
            --authenticationDatabase=admin \
            --db=service_a_db \
            --out=/backup/$TIMESTAMP
done
