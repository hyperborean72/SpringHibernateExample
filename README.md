# SpringHibernateExample
Probation project for InfoBip. Hierarchy of Documents and DocumentItems related with "one-to-many" relationship is manipulated via Spring MVC 4 based UI

The app is configured with annotations completely.

Validation is added for user operations "create-update"
Validation messages are read from resources/messages.properties

Database configuration is administered via application.properties:
- update jdbc.driverClassName, jdbc.url, jdbc.username, jdbc.password etc with parameters for your DB

SQL files for table creation are located in resources/sql

Interface to DocumentItems is available on successful Document create/Document update operations

Document delete operation deletes the related DocumentItems as well.

The app has hardly the most spectacular user interface but it demonstrates functionality well.

Application was tested on Tomcat 7.0.59 & MySQL Server 5.1
