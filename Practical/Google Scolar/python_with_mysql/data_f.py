import json, os , json
from connection import connn
import requests

def get_auther_data(author_id):
    try:
        url = "https://serpapi.com/search.json?engine=google_scholar_author&author_id="+author_id+"&api_key=41835acee14fec19f8813340382d6af658ccd4edb56f35b1b43b4fc841e007c2&num=1000"
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
                cursor.execute('INSERT INTO dbo.gs_data([title],[link],[citation_id],[authors],[publication],[cited_link],[cited_value],[p_year],[author_id]) VALUES (?,?,?,?,?,?,?,?,?)',(title,link,citation_id,authors,publication,cited_link,cited_value,p_year,author_id))
                conn.commit()
            except Exception as e:
                pass
        return {"Message":"Data Inserted"}
    except Exception as e:
        print(e)
        return {"Message":"Data Not Inserted"}

# print(get_auther_data("Pc7Or4oAAAAJ"))