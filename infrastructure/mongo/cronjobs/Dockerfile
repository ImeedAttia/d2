FROM alpine:latest

# Install required packages
RUN apk add --no-cache bash make busybox-suid curl git

WORKDIR /app

# Copy test script, Makefile, and cron schedule
COPY ./test /app/test
COPY ./cronjobs/crontab.txt /etc/crontabs/root
COPY ../../Makefile /app/Makefile
COPY ../../.env /app/.env

CMD /bin/sh -c "make test-backup && crond -f -L /dev/stdout"
