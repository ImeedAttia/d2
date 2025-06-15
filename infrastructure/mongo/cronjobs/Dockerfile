FROM debian:bullseye-slim

# Install required dependencies
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        bash \
        curl \
        git \
        make \
        ca-certificates \
        postgresql-client \
        redis-tools \
        cron && \
    rm -rf /var/lib/apt/lists/*

# Install mongosh
RUN curl -L https://downloads.mongodb.com/compass/mongosh-2.0.2-linux-x64.tgz -o /tmp/mongosh.tgz && \
    tar -xzf /tmp/mongosh.tgz -C /tmp && \
    mv /tmp/mongosh-2.0.2-linux-x64/bin/mongosh /usr/local/bin/mongosh && \
    chmod +x /usr/local/bin/mongosh && \
    rm -rf /tmp/mongosh*

# Setup working directory
WORKDIR /app

COPY ./test /app/test
COPY ./cronjobs/crontab.txt /etc/crontabs/root
COPY ../../Makefile /app/Makefile
COPY ../../.env /app/.env

CMD /bin/bash -c "make test-backup && cron -f"
