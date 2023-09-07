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

## 프로젝트 설치 및 실행
1. IDE 준비 (Intellij 설치)
> 해당 [링크](https://www.jetbrains.com/ko-kr/idea/download/)로 들어가서 다운로드 하세요.

2. Repository 복제
- 소스 파일 설치
```shell
$ git clone https://github.com/AgeBloomers/agebloomers-backend.git
```
 
3. Docker 설치 및 실행
- Docker 설치
> [Dokcer Desktop - mac](https://docs.docker.com/desktop/install/mac-install/) <br>
> [Docker Desktop - windows](https://docs.docker.com/desktop/install/windows-install/)
- Docker를 설치한 후 Docker Desktop을 실행하세요.

<!--- Docker 실행
$ sudo docker run -p 8080:8080 soojung01/age-bloomers-->

- Docker-compose 설치

```shell
$ sudo curl -L "https://github.com/docker/compose/releases/download/1.27.4/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
$ sudo chmod +x /usr/local/bin/docker-compose
$ sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
```

- Docker-compose 버전 확인
```shell
$ docker-compose -v
```

4. MySQL 설치
> 해당 [링크](https://dev.mysql.com/downloads/installer/)로 들어가서 다운로드 하세요.

5. 빌드 (Gradle 설치 필요)
```shell
- 프로젝트 빌드
$ ./gradlew build
```

6. 서버 구동
- 프로젝트를 IntelliJ IDEA에서 열고 구동하세요.
