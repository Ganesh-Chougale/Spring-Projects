
# import resource
import pyodbc
def selected_rec(data):
    columns = data
    conn=pyodbc.connect(Driver="SQL Server",
                        host="DESKTOP-5A3KQEJ",
                        Database = "master",
                        Trusted_Connection="yes")

    cursor = conn.cursor()
    # query = f'SELECT {", ".join(columns)} FROM gs_data;'
    query = f'SELECT * FROM gs_data;'
    try:
        result = cursor.execute(query)
        print(list(result))
        # count=0
        # for row in result:
        #     for j in row:
        #         resource[data[count] : j]
    except Exception as e:
        print(e)  
    conn.close()
    return result

selected_rec(['authors'])