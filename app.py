
import subprocess

from flask import Flask, request

app = Flask("my_app1")

@app.route("/rail")
def rail_schedule():
    if 'destination' in request.args:
        destination = request.args.get('destination')
    else:
        destination = "beer_sheva"

    if 'departure' in request.args:
        departure = request.args.get('departure')
    else:
        departure = "tel_aviv"

    if 'departureTime' in request.args:
        departureTime = request.args.get('departureTime')
    else:
        departureTime = "12:00"

    if 'textFormat' in request.args:
        textFormat = request.args.get('textFormat')
    else:
        textFormat = "HTML"

    return subprocess.check_output(["java", "-classpath", "/home/vadim/Rail_IL/bin", "rail/Main",
                                   departure, destination, departureTime,textFormat])