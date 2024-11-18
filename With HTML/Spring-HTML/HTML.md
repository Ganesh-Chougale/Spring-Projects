```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>HTML with spring</h1>

    <form action="register" method="post">
        <label for="fName">Fistname</label>
        <br/>
        <input type="text" id="fName" name="fName">
        <br/>
        
        <label for="lName">Lastname</label>
        <br/>
        <input type="text" id="lName" name="lName">
        <br/>

        <label for="email">Email</label>
        <br/>
        <input type="email" id="email" name="email">
        <br/>
        
        <label for="dob">Birth Date</label>
        <br/>
        <input type="date" id="dob" name="dob">
        <br/>
        
        <label for="password">Password</label>
        <br/>
        <input type="password" id="password" name="password">
        <br/>

        <label for="gender">Gender</label>
        <select name="gender" id="gender">
            <option value=""></option>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select> 
        <br/>

        <button type="submit">Submit</button>
    </form>
</body>
</html>
```