#!/bin/bash
# Backup both MongoDB instances to BSON files with timestamp

TIMESTAMP=$(date +%F-%H%M)
BACKUP_DIR=/backup/mongo/$TIMESTAMP
mkdir -p "$BACKUP_DIR"

# Service A DB
mongodump --host=mongo1 --port=27017 \
  --username=admin --password=pass \
  --authenticationDatabase=admin \
  --db=service_a_db \
  --out="$BACKUP_DIR/service_a"

# Service B DB
mongodump --host=mongo2 --port=27017 \
  --username=admin --password=pass \
  --authenticationDatabase=admin \
  --db=service_b_db \
  --out="$BACKUP_DIR/service_b"

echo "Backup completed at $BACKUP_DIR"