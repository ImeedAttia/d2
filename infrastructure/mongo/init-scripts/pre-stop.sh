#!/bin/bash
echo "Running pre-stop script..."

# Wait for PostgreSQL to be ready
until pg_isready -U admin -d keycloak; do
    echo "Waiting for PostgreSQL to be available for backup..."
    sleep 2
done

# Perform backup
/scripts/backup.sh

echo "Backup completed, shutting down..."