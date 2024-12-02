from flask import Flask, request, jsonify
from data_f import get_auther_data
import json
app = Flask(__name__)


# Create a new record (POST)
@app.route('/records', methods=['POST'])
def create_record():
    try:
        data = request.json
        author_id = data.get("author_id")
        print(author_id)
        response = get_auther_data(author_id)
        return jsonify(response)
    except Exception as e:
        return jsonify({"Error":str(e)})

if __name__ == '__main__':
    app.run(debug=True)
