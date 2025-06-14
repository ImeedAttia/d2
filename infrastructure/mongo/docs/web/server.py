from flask import Flask, send_from_directory, jsonify, Response
import subprocess
import os

app = Flask(__name__, static_folder='.', static_url_path='')

@app.route("/stream-make/<target>")
def stream_make(target):
    def generate():
        process = subprocess.Popen(
            ["make", target],
            stdout=subprocess.PIPE,
            stderr=subprocess.STDOUT,
            text=True,
            bufsize=1
        )
        for line in process.stdout:
            yield f"data: {line.rstrip()}\n\n"
        yield "event: end\ndata: done\n\n"

    return Response(generate(), mimetype='text/event-stream')


@app.route("/run-make/pgadmin-backup")
def backup_pgadmin():
    os.system("docker run --rm -v pgadmin_data:/data alpine tar -czf - -C /data . > pgadmin_backup.tar.gz")
    return "pgAdmin backup completed"

@app.route("/run-make/pgadmin-restore")
def restore_pgadmin():
    os.system("cat pgadmin_backup.tar.gz | docker run --rm -i -v pgadmin_data:/data alpine tar -xzf - -C /data")
    return "pgAdmin restore completed"

@app.route("/")
def index():
    return send_from_directory('.', 'index.html')

if __name__ == "__main__":
    os.chdir(os.path.dirname(__file__))  # Ensure cwd is web dir
    app.run(host="0.0.0.0", port=4100, threaded=True)
