from flask import Flask, request, jsonify
from modules.data_f import get_auther_data, get_all_data
import json
app = Flask(__name__)


# Create a new record (POST)
@app.route('/records', methods=['POST'])
def create_record():
    try:
        data = request.json
        print(data)
        author_id = data.get("author_id")
        key = data.get("key")
        print(author_id)
        response = get_auther_data(author_id,key)
        return jsonify(response)
    except Exception as e:
        return jsonify({"Error":str(e)})



@app.route('/get_records', methods=['GET'])
def get_record():
    try:
        response = get_all_data()
        return jsonify(response)
    except Exception as e:
        return jsonify({"Error":str(e)})


if __name__ == '__main__':
    app.run(debug=True)
