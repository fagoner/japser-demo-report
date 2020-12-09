### Jasper report + Jdk1.8 + SpringBoot

Simple example using jasperReport and filled with MysqlData

### Requirements
- [x] Java JDK 1.8
- [x] Mysql 8.0


### Installation


##### Database
You need to create the database(back) and the tables(category), you can follow the sql instruction on `db/sql/V1_0__init.sql`

Try to run the statements on Mysql8.x
```
    USE back;
    CREATE TABLE IF NOT EXISTS `back`.`category`(
        id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
        name       VARCHAR(100) NOT NULL,
        created_at DATETIME NOT NULL,
        active     BOOLEAN NOT NULL,
        PRIMARY KEY(id)
    );
    INSERT INTO back.category(name, created_at, active)
    VALUES ("Demo Category", NOW(), 1);
```

Or you can use [flyway](https://flywaydb.org/) to run migrations
 
```flyway -configFiles=db/flyway.conf migrate```

##### Database with Docker 

To execute the database with docker go to `backing-services/docker-compose.yml`
and execute: 
 
```
docker-compose up -d
```

The database will be executed on port `3306`, a simple client on port `8080`

#### Database access from the application
The access to the database are in the file: `src/main/java/resources/application.properties`

```
#database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/back
spring.datasource.url=jdbc:mysql://localhost:3306/back
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.initialize=true

#server
server.port = 8099
```
Be sure to use the following username and password to access to the database




#### Testing
- With your browser set the url: `http://localhost:8099/categories`
    ```
        [
          {
            "id": 1,
            "name": "Demo Category",
            "createdAt": "2020-12-08T16:18:47",
            "active": true
          }
        ]

    ```
 
- With your browser set the url: `http://localhost:8099/reports`
The browser will download the file `categoryReport.pdf`, it will be similar to `report.pdf`





#### Roadmap

- [ ] Eliminate smell code