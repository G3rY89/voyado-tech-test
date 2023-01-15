# Voyado Tech Test Application

## Before running the application follow these steps:
1. Clone the repository and place the files inside a directory
2. Install Java SDK 19 on your computer
3. Install Maven on your computer

### In order to run this application from command line follow these steps:
1. Resolve dependencies using 'mvn install' from a command line inside the project directory
2. Execute 'mvn spring-boot:run' inside the project directory

### In order to run this application from IntelliJ IDEA follow these steps:
1. Open the project directory 
2. In Run/Debug configurations set it as a Maven project and running command as 'spring-boot:run'.
 
The application will start on http://localhost:8080 by default.

For the developer documentation see http://localhost:8080/swagger-ui/#/

## Users manual
Type the requested search query in the only input field on the main site of the application.
Under the search field you can select which search engine do you want to use. You have to tick at least one. 
Then if you click on search you will get the search counts by word per each search engine and the 
summary of the search hits.