# Login-REST-API-Example

This repository contains an example source, how to use Jersey as one of serveral implementations of the 
JAX-RS (Java API for RESTful Webservices) to develop a simple login application. When a client 
(e.g., Postman or cURL) sends an HTTP POST with crendentials consisting of the username und password,
the application validates these credentials against a H2 database. If the user is found based on the
provided username and password, a response with HTTP status code of 200 OK, along with the user details,
is sent back to the user. If the user is not found, a response with HTTP status code of 401 Unauthorized
and a message stating "User not found" is returned.



## Pre requisites
 * Maven
 * JDK8+
 
## Build the example
 1. Clone this repository and build the examples using:
     `mvn package`

 2. Deploy the application on an Apache Tomcat server. The version used for testing is
    Apache Tomcat 8.5.99.

 3. Run the following command in the terminal to authenticate:

    ```bash
    curl -X POST localhost:8080/login-rest-api/rest/authentication/login \
         -H 'Content-Type: application/json' \
         -d '{"username": "jane-smith", "password": "12345"}'
    ```

