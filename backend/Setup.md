# Setup instructions for backend

### Product Service
* setup the db locally or the cloud one, make sure it is running.
* export the following:
     * DB_URL : database url without the username and password
     * DB_USER: db username. Need to set this only if the username is not the usual "username".
     * DB_PWD : the database password Need to set this only if the password is not the usual "password".
     * WALMART_API_KEY: api key for walmart
     
* run the code. Make sure the code runs in the same shell as where the environment variables are exported. 

the service will run the port mentioned in its applications.properties file

### User Service
* setup the db locally or the cloud one, make sure it is running.
* export the following:
     * DB_URL : database url without the username and password
     * DB_USER: db username. Need to set this only if the username is not the usual "username".
     * DB_PWD : the database password Need to set this only if the password is not the usual "password".
     
* run the code. Make sure the code runs in the same shell as where the environment variables are exported. 

the service will run the port mentioned in its applications.properties file

### Exporting environment variables
* If using the bash shell to run the application
```
export NAME=value
```
where NAME is the name of the environment variable and value is its value.
* If using an IDE, please set the environment variables in the IDE configuration