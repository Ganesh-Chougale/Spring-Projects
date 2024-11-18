# Post Methods  
url: `http://localhost:8080/api/items`  
```json
{
  "itemName": "Microscope",
  "quantity": "5",
  "status": 1,
  "category": {
    "categoryId": 1
  }
}
```  


# Get Methods  
## get method (all items)
Url: `http://localhost:8080/api/items`  
## get method (single item)
Url: `http://localhost:8080/api/items/{id}`  


# Put Methods  
Url : `http://localhost:8080/api/items/{id}`  
```json
{
  "itemName": "Updated Microscope",
  "quantity": "15",
  "status": true,
  "category": {
    "categoryId": 2
  }
}
```  

# Delete Methods  
Url: `http://localhost:8080/api/items/{id}`
