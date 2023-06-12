# 🔎 Spring Boot Vue 3 Solr Web Application Example
[![versionjava](https://img.shields.io/badge/JDK-8,_11,_17-brightgreen.svg?logo=java)](https://github.com/spring-projects/spring-boot)
![stability-WIP](https://img.shields.io/badge/Stability-WIP-lightgrey.svg)

> **🚧 Work in Progress 🚧**<br/><br/>
> This repository is currently under development and is not ready for production use. 🛠️ It's a work in progress, and I'm actively working on enhancing its functionality and features.

This application was created as a pet project to improve Java, Spring, and Apache Solr development skills, as well as to
learn Vue. It showcases the functionality of a search system based on Apache Solr, with the backend implemented in Java
and Spring Boot, and the frontend using Vue.

Based on [**@jonashackt/spring-boot-vuejs**](https://github.com/jonashackt/spring-boot-vuejs). Go give him a star ⭐

## 🚀 Running

### Manual way
1. Initialize database with a [**script**](backend/src/main/resources/init-script.sql);
2. Create a new user in your database for the newly created schema;
3. Set up a connection in [`application.properties`](backend/src/main/resources/init-script.sql):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/search_app_example?useSSL=false
spring.datasource.username=searchapp
spring.datasource.password=searchapp
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```
4. Install artifacts
```bash
mvn run clean
```
5. Run Solr server:
```bash
solr start -p 8983
```
6. Run application
```bash
mvn --projects backend spring-boot:run
```

## 🤝 Contribution
I'd love to accept your contributions to this project. I use GitHub pull requests for this purpose. Consult [GitHub Help](https://docs.github.com/en/github/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/about-pull-requests) for more information on using pull requests.

## 🧡 Find this repository useful?
Like the website or got inspired by it? Please support it by joining __[stargazers](https://github.com/xtenzQ/xtenzQ.github.io/stargazers)__ for this repository. :star:

## License
```
MIT License

Copyright (c) 2023 Nikita Rusetskii

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
