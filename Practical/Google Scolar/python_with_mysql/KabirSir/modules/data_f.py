import json, os , json
from modules.connection import connn
import requests

def get_auther_data(author_id, key):
    try:
        url = "https://serpapi.com/search.json?engine=google_scholar_author&author_id="+author_id+"&api_key=" + key +"&num=1000"
        payload = {}
        headers = {}
        response = requests.request("GET", url, headers=headers, data=payload)
        json_obj = (response.json())
        conn=connn
        cursor = connn.cursor()
        for item in json_obj['articles']:
            try:
                title = item.get('title', "")
                link = item.get('link', "")
                citation_id = item.get('citation_id', "")
                authors = item.get('authors', "")
                publication = item.get('publication', "")
            except Exception as e:
                print("Error in 2:", e)

            try:
                cited_link = item.get('cited_by', {}).get('link', "")
                cited_value = item.get('cited_by', {}).get('value', "")
                p_year = item.get('year', "")
            except Exception as e:
                print("Error in 3:", e)

            try:
                cursor.execute('INSERT INTO gs_data([title],[link],[citation_id],[authors],[publication],[cited_link],[cited_value],[p_year],[author_id]) VALUES (?,?,?,?,?,?,?,?,?)',(title,link,citation_id,authors,publication,cited_link,cited_value,p_year,author_id))
                conn.commit()
            except Exception as e:
                print("Error in insertion : ",e)
                pass
        return {"Message":"Data Inserted"}
    except Exception as e:
        print(e)
        return {"Message":"Data Not Inserted"}

# print(get_auther_data("Pc7Or4oAAAAJ"))
def get_all_data():
    try:
        # Use the existing connection
        conn = connn
        cursor = conn.cursor()
        
        # Example of retrieving author data
        query = "SELECT * FROM gs_data"
        cursor.execute(query)
        
        # Fetch all records
        records = cursor.fetchall()

        # Get column names for mapping
        column_names = [desc[0] for desc in cursor.description]

        # Convert records to a list of dictionaries
        records_list = [dict(zip(column_names, record)) for record in records]

        conn.commit()
        return {"Message": "Data Retrieved", "Records": records_list}

    except Exception as e:
        print("Error:", e)
        return {"Message": "Data Not Retrieved", "Error": str(e)}

# print(get_auther_data("Pc7Or4oAAAAJ"))