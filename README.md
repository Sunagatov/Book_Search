# Book Search

A server-rendered Java book catalogue with author profiles, book management and user registration.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>

## Explore the application

- Browse the book and author lists and open individual profiles.
- Create, update and delete books and authors through dedicated forms.
- Work with domain models for genres, countries, users and reviews.

## Stack

Java 8 · Spring MVC 5 · Hibernate 5 · FreeMarker · HSQLDB · Maven · Jetty

## Run locally

With JDK 8 and Maven installed, run from the repository root:

```bash
mvn package
mvn jetty:run
```

Open `http://localhost:8081/`. Jetty's port is configured in
[pom.xml](pom.xml), and its context is `/`.

| Page | Path |
| --- | --- |
| Home | `/` or `/home` |
| Books | `/books` |
| Book profile | `/book/{id}` |
| Authors | `/authors` |
| Author profile | `/author/{id}` |

## Code map

- [Controllers](src/main/java/com/zufar/controller): page routes and form submissions.
- [Services](src/main/java/com/zufar/service) and [repositories](src/main/java/com/zufar/repository): business and persistence layers.
- [Domain](src/main/java/com/zufar/domain): catalogue and user entities.
- [FreeMarker pages](src/main/webapp/WEB-INF/pages): server-rendered views.

## Local database

[applicationContext.xml](src/main/webapp/WEB-INF/applicationContext.xml) uses
`jdbc:hsqldb:file:db` and Hibernate `hbm2ddl.auto=create`. Starting the application
recreates the mapped schema, so use a disposable development database.

## ☕ Support the project

If this project helps you learn or build, you can support its development.

<p>
  <a href="https://buymeacoffee.com/lucky_1uck">
    <img src="https://img.shields.io/badge/Support_the_project-FFDD00?style=for-the-badge&amp;logo=buymeacoffee&amp;logoColor=black" alt="Support the project" width="260" height="40">
  </a>
</p>
