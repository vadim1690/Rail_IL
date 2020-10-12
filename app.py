import subprocess

from flask import Flask, request

app = Flask("my_app1")

@app.route("/rail")
def rail_schedule():
    if 'destination' in request.args:
        destination = request.args.get('destination')
    else:
        destination = "null"

    if 'departure' in request.args:
        departure = request.args.get('departure')
    else:
        departure = "null"

    if 'departureTime' in request.args:
        departureTime = request.args.get('departureTime')
    else:
        departureTime = "null"


    return subprocess.check_output(["java", "-classpath", "/home/rivka/Rail_IL/bin", "rail_browser/Main_browser",
                                   departure, destination, departureTime])