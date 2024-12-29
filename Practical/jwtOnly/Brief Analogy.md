to implement JWT,
1. Depenencay: api, impl, Jackson.
2. A Dedicated repository & class file that generates JWT token

Mandatory inputs to generate JWTtoken
1. Secret key
2. Claims (Optional but industry stanards)
	- payload info about user or any other data we want to encode
A. usually sub: <user/main enity>, role : <role>, iat: <issued at time>, exp: "expiring time".
B. Custome Claims : role, email, user_id, etc
3. Signing ALgorithm
	- HS256: HMAC with SHA-256
	- RS256: RSA with SHA-256
	- ES256: ECDSA with SHA-256	
