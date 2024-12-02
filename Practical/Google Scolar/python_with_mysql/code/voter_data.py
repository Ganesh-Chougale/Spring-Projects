import pyodbc
conn=pyodbc.connect(Driver="SQL Server",
                        host="DESKTOP-DFF341V\SQLEXPRESS",
                        Database = "master",
                        Trusted_Connection="yes")
cursor = conn.cursor()
query = f'SELECT * FROM voter_data;'
try:
    result = dict(cursor.execute(query))
    print(list(result))
        # count=0
        # for row in result:
        #     for j in row:
        #         resource[data[count] : j]
except Exception as e:
    print(e)  
conn.close()