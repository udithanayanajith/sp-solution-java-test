# Uditha nayanajith - SP Solution Java Interview
Here I have added my Answers for problem one to four inside  **ProblemTasks** folder.
For each problem I have created separate classes with main class.


#

## This is a springboot web service for News website

### Backend 
I have created a java springboot 
web service with get/post/put like APIs for the manage news and news categories.
I have used jakarta validations and swagger doc for the API documentation and database is mysql.
Inorder to run the web server using intelijIdea create a database inside the name match with **application.yml**
url: jdbc:mysql://localhost:3306/newsdb?useSSL=true&requireSSL=false&createDatabaseIfNotExist=true

#
Main REST APIs are below.

#### Category Controller
GET
/v1/api/cat
View all categories

POST
/v1/api/cat
Save a category

GET
/v1/api/cat/{id}
View a category by id

PUT
/v1/api/cat/{id}
Update category description

#### News Controller

GET
/v1/api/news

POST
/v1/api/news
Save a news

GET
/v1/api/news/{id}

GET
/v1/api/news/allNewsByCatId/{id}

and for the frontend part I have created a small UI using HTML,CSS and java script
1st run the webserver and go to **frontEnd** folder and double click in index.html