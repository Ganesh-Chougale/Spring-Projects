import pyodbc

connn = pyodbc.connect(
    Driver="{SQL Server}",  # Make sure to include the curly braces around SQL Server
    Server="103.21.58.192",  # Use 'Server' instead of 'host'
    Database="demo16",
    UID="eleuser",  # Use 'UID' for the username
    PWD="Rwc9~d74"  # Use 'PWD' for the password
)

# Now you can use connn to create a cursor and execute queries
