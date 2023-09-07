# agebloomers-backend

## 🙇🏻 개발
>### Develop Environment
- Language  : JAVA
- Framework : Spring Boot
- DBMS      : MySQL (AWS RDS)
- TestTool  : Swagger
- Build Version : Java 17
- Devleop Tool : Intelli J
- JDK : open-jdk:17
  
>### Dependencies
```java
// Spring Boot Data JPA and Web
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.springframework.boot:spring-boot-starter-web'

// Lombok for code simplification
compileOnly 'org.projectlombok:lombok'
annotationProcessor 'org.projectlombok:lombok'

// Spring Boot Test Starter
testImplementation 'org.springframework.boot:spring-boot-starter-test'

// Thymeleaf for HTML templating
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
developmentOnly 'org.springframework.boot:spring-boot-devtools'

// MySQL Connector
implementation 'mysql:mysql-connector-java:8.0.33'

// QueryDSL for JPA
implementation "com.querydsl:querydsl-jpa:${queryDslVersion}"
implementation "com.querydsl:querydsl-apt:${queryDslVersion}"

// Jasypt for encryption and decryption
implementation 'com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.4'

// Swagger for API documentation
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2'

// Jsoup for HTML parsing
implementation 'org.jsoup:jsoup:1.15.3'
```

## 📍API List
<img width=500px src="https://github.com/AgeBloomers/agebloomers-backend/assets/65272297/4588b94a-ddc6-4c49-a791-263cfdf51a30"></img>
<img width=500px src="https://github.com/AgeBloomers/agebloomers-backend/assets/65272297/ad71fe16-dc54-440e-ad24-254dc06b6d6a"></img>
