# Air companies Management System

### The application startup guide

1. ####  Required to install

    - Java 11

    - Docker [Installation guide](https://docs.docker.com/engine/install/ubuntu/)

    - Docker Compose [Installation guide](https://docs.docker.com/compose/install/)



2. #### How to run

    1. ##### Use Docker:

        - build the Docker Compose
        - run the Docker Compose



2. ##### Run on your PC

    - Open application-properties file and change

      ```properties
      #from
      spring.profiles.active=prod
      
      #to
      spring.profiles.active=test
      ```

    - Then you should create environmental variables that are defined in the `application-test.properties`

      All these variables you can set in Intellij Idea. For instance:

      ```properties
      spring.datasource.url=${DATABASE_TEST_URL}
      spring.datasource.username=${DATABASE_TEST_USER}
      spring.datasource.password=${DATABASE_TEST_PASSWORD}
      ```

    - And just run the application

3. #### How to test

    - You can rut the `insertData.sql` script with test data. It located in the `data` folder
    - You can use the Postman collection for request testing. It located at `data/postman_collection` folder

