# Post Methods  
## Bulk Injection   
url: `http://localhost:8080/api/categories/bulk`
```json
[
    { "categoryName": "ELECTRICAL EQUIPMENT" },
    { "categoryName": "MAGNETIC EQUIPMENT" },
    { "categoryName": "OPTICAL EQUIPMENT" },
    { "categoryName": "GRAVITY RELATED EQUIPMENT" },
    { "categoryName": "WAVES AND SOUND RELATED EQUIPMENT" },
    { "categoryName": "KINEMATICS RELATED EQUIPMENT" },
    { "categoryName": "MEASURING EQUIPMENT" }
]
```  

## Solo Injuction  
path: `http://localhost:8080/api/categories/bulk`
```json
{
  "categoryName": "ELECTRICAL EQUIPMENT"
}
```  
```json
{
  "categoryName": "MAGNETIC EQUIPMENT"
}
```  
```json
{
  "categoryName": "OPTICAL EQUIPMENT"
}
```  
```json
{
  "categoryName": "GRAVITY RELATED EQUIPMENT"
}
```  

# Get Methods  
## get method (all categories)
Url: `http://localhost:8080/api/categories`  
  
## get method (single category)
Url: `http://localhost:8080/api/categories/{id}`  


# Put Methods  
Url : `http://localhost:8080/api/categories/{id}`
```json
{
  "categoryName": "Updated Equipment Name"
}
```  

# Delete Methods  
Url : `http://localhost:8080/api/categories/{id}`

