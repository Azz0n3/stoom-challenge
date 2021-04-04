FORMAT: 1A
# Stoom BackEnd Challenge

* [Stoom Developer Test](https://gist.github.com/pedroits/9a42411f44ba9d75a70bfb7122c6f642)

## Stacks used

- Java 11
- Spring Boot
- JUnit 5
- PostgreSQl
- Docker

## Executing Project


1 - clone the project in: ```git clone https://github.com/Azz0n3/stoom-challenge.git```

2 - Go to the root folder: ```cd ./stoom-challenge``` 

3 - A) Java Execution: 
  - ```mvn clean install```
  - ```java -jar target/*.jar```

4 - A) Docker Execution
  - ```mvn clean install```
  - ```mvn docker:build```
  - ```docker run -it -p 8080:8080 stoomchallenge```

## Documentation

### POST /user
Create an USER entity, that is assigned with a __Plan__, __Token__ and __Logs__, this creates a different environment for each individual, allowing the return of specific statistics for that user's requests.

+ Request (application/json)

    + Body

            {
	            "username": "TestUser",
	            "password": "testpsw",
	            "confirmPassword": "testpsw",
	            "email": "test@test.com"
            }

    + Schema

            {
                "type": "object",
                "properties": {
                    "username": {
                        "type": "string"
                    },
                    "password": {
                        "type": "string"
                    },
                    "confirmPassword": {
                        "type": "string"
                    },
                    "email": {
                        "type": "string"
                    },                   
                },
                "additionalProperties": false
            }

+ Response 200 (application/json)

    + Body

            {
                "id": 1,
            }

    + Schema

            {
                "type": "object",
                "properties": {
                    "id": {
                        "type": "integer"
                    }
                }
            }
