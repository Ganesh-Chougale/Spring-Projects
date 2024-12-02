from flask import Flask, request, jsonify
import pyodbc

app = Flask(__name__)

# Database connection function
def get_db_connection():
    conn = pyodbc.connect(Driver="SQL Server",
                          host="DESKTOP-5A3KQEJ",
                          Database="master",
                          Trusted_Connection="yes")
    return conn

# Create a new record (POST)
@app.route('/records', methods=['POST'])
def create_record():
    data = request.json
    conn = get_db_connection()
    cursor = conn.cursor()
    
    # Assuming 'table_name' is the table where you want to insert the record
    cursor.execute("INSERT INTO table_name (column1, column2) VALUES (?, ?)",
                   data['column1'], data['column2'])
    conn.commit()
    cursor.close()
    conn.close()
    return jsonify({"message": "Record created successfully"}), 201

# Read all records (GET)
@app.route('/records', methods=['GET'])
def get_records():
    conn = get_db_connection()
    cursor = conn.cursor()
    cursor.execute("SELECT * FROM table_name")
    rows = cursor.fetchall()
    cursor.close()
    conn.close()

    # Convert to a list of dictionaries
    records = []
    for row in rows:
        records.append({"column1": row[0], "column2": row[1]})

    return jsonify(records), 200

# Update a record (PUT)
@app.route('/records/<int:id>', methods=['PUT'])
def update_record(id):
    data = request.json
    conn = get_db_connection()
    cursor = conn.cursor()
    
    cursor.execute("UPDATE table_name SET column1 = ?, column2 = ? WHERE id = ?",
                   data['column1'], data['column2'], id)
    conn.commit()
    cursor.close()
    conn.close()
    
    return jsonify({"message": "Record updated successfully"}), 200

# Delete a record (DELETE)
@app.route('/records/<int:id>', methods=['DELETE'])
def delete_record(id):
    conn = get_db_connection()
    cursor = conn.cursor()
    
    cursor.execute("DELETE FROM table_name WHERE id = ?", id)
    conn.commit()
    cursor.close()
    conn.close()
    
    return jsonify({"message": "Record deleted successfully"}), 200

if __name__ == '__main__':
    app.run(debug=True)
