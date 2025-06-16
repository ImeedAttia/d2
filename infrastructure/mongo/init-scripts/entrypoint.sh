#!/bin/bash
set -e

# Configuration
BACKUP_DIR="/backup/data"
DATA_DIR="/var/lib/postgresql/data"
PGDATA="$DATA_DIR/pgdata"

# Ensure directories exist
mkdir -p "$BACKUP_DIR"
mkdir -p "$PGDATA"
chown -R postgres:postgres "$DATA_DIR"
chmod 700 "$DATA_DIR"

# Function to handle graceful shutdown
graceful_shutdown() {
    echo "Received shutdown signal, running pre-stop script..."
    /scripts/pre-stop.sh
    echo "Pre-stop completed, stopping PostgreSQL..."
    exit 0
}

# Trap SIGTERM and SIGINT
trap 'graceful_shutdown' SIGTERM SIGINT

# Start PostgreSQL in background
echo "Starting PostgreSQL..."
exec /usr/local/bin/docker-entrypoint.sh postgres &

# Wait for PostgreSQL to be ready
wait_for_postgres() {
    until pg_isready -U admin -d keycloak; do
        echo "Waiting for PostgreSQL to become available..."
        sleep 2
    done
}

wait_for_postgres

# Main process - wait and handle signals
echo "PostgreSQL is ready for connections"
wait