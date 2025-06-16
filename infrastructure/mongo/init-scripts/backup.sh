#!/bin/bash
set -e

BACKUP_DIR="/backup/data"  # Note changed path
DATA_DIR="/var/lib/postgresql/data/pgdata"
TIMESTAMP=$(date +"%Y%m%d%H%M%S")

mkdir -p "$BACKUP_DIR"
echo "Creating PostgreSQL backup..."
tar -czf "$BACKUP_DIR/postgres_$TIMESTAMP.tar.gz" -C "$DATA_DIR" .
echo "Backup created: postgres_$TIMESTAMP.tar.gz"

# Optional: Keep only last 5 backups
ls -t "$BACKUP_DIR"/postgres_*.tar.gz | tail -n +6 | xargs rm -f --