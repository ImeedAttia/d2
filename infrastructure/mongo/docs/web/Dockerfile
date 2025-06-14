FROM python:3.11-slim

WORKDIR /app

# Install all needed tools (bash, make, Docker CLI, PostgreSQL client, redis-tools, cron)
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        make \
        bash \
        curl \
        git \
        docker.io \
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

COPY . .

RUN pip install flask

EXPOSE 4100

CMD ["python", "server.py"]
