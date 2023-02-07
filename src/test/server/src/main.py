import random

from flask import Flask

app = Flask(__name__)


@app.route("/sensors")
def getSensorsData():
    temperature = random.randint(10, 30)
    light = random.randint(50, 60000)
    moisture = random.randint(0, 1000)
    return {
        "temperature": temperature,
        "light": light,
        "moisture": moisture,
    }
