.PHONY: test-backup

# Makefile for MongoDB backup and restore operations
test-backup:
	@echo "🧪 Running Backup & Restore Integration Test..."
	@bash -c 'set -a && source .env && set +a && bash ./test/verify_backup_restore.sh'

# Run both backups
backup: backup_mongo_user backup_mongo_ride
	@echo "✅ All backups completed."

# Backup mongo_user
backup_mongo_user:
	@echo "🔁 Backing up mongo_user..."
	docker-compose run mongo_user_backup

# Backup mongo_ride
backup_mongo_ride:
	@echo "🔁 Backing up mongo_ride..."
	docker compose run mongo_ride_backup

# Restore from backup
restore:
	@echo "♻️  Restoring MongoDB from /backup..."
	docker compose run mongo_restore