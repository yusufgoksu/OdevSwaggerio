# Petstore API Test Automation

## Overview
This project automates the testing of the **Swagger Petstore API**. The goal is to test the **GET**, **POST**, **PUT**, and **DELETE** endpoints for various pet operations. It uses **Java** with the **Rest Assured** framework for API testing and **Allure** for generating detailed test reports. 

Additionally, a **Postman** collection is provided for manual testing of the same API.

## Tools & Technologies
- **Java** (11 or higher)
- **Maven** (for dependency management)
- **Rest Assured** (for API testing)
- **Allure** (for generating detailed reports)
- **Postman** (for manual testing)

## Prerequisites
1. **Java 11** or higher installed on your machine.
2. **Maven** installed. You can install it by following [Maven Installation Guide](https://maven.apache.org/install.html).
3. **Allure Commandline** installed. You can follow the instructions from [Allure Installation Guide](https://allure.qatools.ru/docs/).
4. **Postman** (optional) to run the Postman collection.

## Installation and Setup

Follow these steps to get the project up and running:  

1. **Clone the Repository:**  
   Clone this repository to your local machine:  
   ```bash
   git clone https://github.com/yusufgoksu/OdevSwaggerio.git
   cd OdevSwaggerio

2. **Build the Project:**  
   Navigate to the project directory and run the following command to install necessary dependencies:
   ```bash
   mvn  install

3. **Running Tests:**  
   Run the following command to start the Spring Boot application:
   ```bash
   mvn test

4. **Generating Allure Report:**  
   After running the tests, generate the Allure report by using the following command:
   ```bash
   allure serve target/allure-results

Postman Collection
In addition to automated tests, a Postman collection is included for manual testing of the Petstore API endpoints. You can import the file PetstoreAPI.postman_Yusuf.json into Postman and run the requests manually if needed. This is helpful for validating the API behavior outside of the automated tests.

API Test Cases
GET Requests
GET /pet/{petId}: Retrieve details of a pet by its ID.
POST Requests
POST /pet: Add a new pet to the store. The request body should contain pet details (name, status, etc.).
PUT Requests
PUT /pet: Update an existing pet's information. Provide the pet's ID and updated details in the request body.
DELETE Requests
DELETE /pet/{petId}: Delete a pet by its ID.
Each API operation is tested in the Test classes with specific test scenarios for valid and invalid cases.

Reporting
The Allure report is generated after running the tests. The results are stored in the target/allure-results folder.
To view the Allure report, run the following command:.
