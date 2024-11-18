```bash
sudo lsof -i :8080
```   
#### Output:  
```vbnet
COMMAND  PID  USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
java    1234  root   123u IPv6  12345      0t0  TCP *:http-alt (LISTEN)
```  
```bash
sudo kill 1234
```  
```bash
# forcefully kill the port
sudo kill -9 1234
```  