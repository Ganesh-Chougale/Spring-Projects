import pyodbc

connn=pyodbc.connect(Driver="SQL Server",
                    host="DESKTOP-5A3KQEJ",
                    Database = "master",
                    Trusted_Connection="yes")
# Server=localhost;Database=master;Trusted_Connection=True;