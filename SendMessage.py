from time import time
import requests
from faker import Faker
import json, time

faker = Faker()

def get_register():
    return {
        'roomId': 0,
        'sender': faker.name(),
        'content' : faker.text()
    }

def json_serializer(data):
    return json.dumps(data).encode('utf-8')

url = "http://localhost:8088/api/v1/producer/send"
while True:
    message = get_register()
    print('message; ', message)
    r = requests.post(url, json=message)
    print('status code: ',  r.status_code)
    time.sleep(3)
