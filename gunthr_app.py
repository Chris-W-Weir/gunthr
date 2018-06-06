from flask import Flask, request, Response
from http import HTTPStatus
import subprocess
import json

app = Flask(__name__)

@app.route("/link", methods=["POST"])
def open_link():
    content = request.json
    print(content)
    subprocess.run(["chrome", content["url"]])
    return Response(json.dumps({"status":"success"}), status=HTTPStatus.OK, mimetype="application/json")

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=5000)