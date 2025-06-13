.PHONY: test-backup

test-backup:
	@echo "🧪 Running Backup & Restore Integration Test..."
	@sed -i 's/\r$$//' .env
	@bash -c 'set -a && source .env && set +a && bash ./test/verify_backup_restore.sh'