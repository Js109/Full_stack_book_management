# Full Stack Book Management System with Angular and Spring Boot
This repository features a full-stack book management implementation using Angular and Spring Boot.

## Setup instructions
This repository contains two main components of a full-stack application.  
1. a WebFrontend, the GUI which is built with Angular.
2. a Backend, which implements various API endpoints and the logic. Spring Boot was used as the framework for this.

### Startup the WebFrontend
As a prerequisite Node.js and npm has to be installed. Additionally, we need the Angular CLI.
Navigate to the book_management_frontend folder and type in ```npm install``` and followed by ```ng serve --open```. It will start the frontend running on http://localhost:4200/ 

### Startup the Backend
As a prerequisite, Java version 21 and Apache Maven 3.8.5 must be installed. However, the build may also work with older Java versions.
It can be built with ```mvn clean install``` on the main folder.

Navigate to the book_management_backend if you want to start it within Intellij or go to the target folder if you run it natively.
Execute ```java -jar 0.0.1-SNAPSHOT.jar``` and the application will start up at port 8081 -> http://localhost:8081/

## Functionality
The book management system offers classic CRUD operations:
1. Show Books
2. Add Book
3. Delete Book
4. Update Book

Some impressions:
<kbd>![image info](Book_Management_Overview.png "Book Management Overview")</kbd>

The values of the dialogues are pre-filled or are taken from the selected book (transfer of the values to the corresponding component).
<kbd>![image info](Add_Dialog.png "Add Book")</kbd>

<kbd>![image info](Update_Dialog.png "Update Book")</kbd>