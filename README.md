# BOOTME-PING

The project is an example of a Spring Boot web service. The intent is to use 
with the companion web service to demonstrate communication between them with
a profile. 


## Usage example

http://localhost:8080/api/

## Resources
1. GET /api/ping returns the ping date
2. POST /api/authenticate returns a JWT for the request body {"username":"a_user_name", "secret":"a_secret"}
3. POST /api/verifyToken returns a true or false for the request body {"token":"a_token_string"} is valid and hasn't expired



## Development setup

1. Clone the repo
2. Use your favorite Java IDE to import the Maven project



## Contributing

1. Fork it (<https://github.com/mcfarlander/bootme-ping/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request
