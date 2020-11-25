### Jasper report + Jdk1.8 + SpringBoot

Simple example using jasperReport and filled with MysqlData

#### Requirements
- [x] Java JDK 1.8
- [x] Mysql 8.0

#### Install and Run
```
mvn clean package
java -jar target/report-0.0.1-SNAPSHOT.jar
```

#### Testing
- With your browser set the url: `http://localhost:8099/reports`
- The browser will download the file `categoryReport.pdf`


#### Roadmap

- [ ] Upgrade documentation
- [ ] Export to XLS / CSV
- [ ] Eliminate code smell