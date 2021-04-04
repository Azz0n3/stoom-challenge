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

### POST /address
Create an Address

+ Request (application/json)

    + Body

            {
	            "streetName":"Rua Mário De Andradade",
		    "number": "1293",
		    "Complement": "Chácara",
		    "neighbourhood": "Beirro Champirra",
		    "city": "Jundiaí",
		    "state": "São Paulo",
		    "country": "Brasil",
		    "latitude": -23.54,
		    "longitude": 23.56,
            }

    + Schema

            {
                "type": "object",
                "properties": {
                    "streetName": {
                        "type": "string"
                    },
                    "number": {
                        "type": "string"
                    },
                    "Complement": {
                        "type": "string"
                    },
                    "neighbourhood": {
                        "type": "string"
                    }, 
                    "city": {
                        "type": "string"
                    }, 
                    "state": {
                        "type": "string"
                    }, 
                    "country": {
                        "type": "string"
                    },
                    "latitude": {
                        "type": "double"
                    },
                    "longitude": {
                        "type": "double"
                    },		    
                },
                "additionalProperties": false
            }

+ Response 200 (application/json)

    + Body

            {
	            "id": 1,
	            "streetName":"Rua Mário De Andradade",
		    "number": "1293",
		    "Complement": "Chácara",
		    "neighbourhood": "Beirro Champirra",
		    "city": "Jundiaí",
		    "state": "São Paulo",
		    "country": "Brasil",
		    "latitude": -23.54,
		    "longitude": 23.56,
            }

    + Schema

            {
                "type": "object",
                "properties": {
                    "id": {
                        "type": "long"
                    },
                    "streetName": {
                        "type": "string"
                    },
                    "number": {
                        "type": "string"
                    },
                    "Complement": {
                        "type": "string"
                    },
                    "neighbourhood": {
                        "type": "string"
                    }, 
                    "city": {
                        "type": "string"
                    }, 
                    "state": {
                        "type": "string"
                    }, 
                    "country": {
                        "type": "string"
                    },
                    "latitude": {
                        "type": "double"
                    },
                    "longitude": {
                        "type": "double"
                    },		    
                },
                "additionalProperties": false
            }
