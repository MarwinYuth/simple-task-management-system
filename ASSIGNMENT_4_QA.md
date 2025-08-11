# Assignment 4: Short Questions & Answers

1. **Difference between @Component, @Service, @Repository**

   - @Component: Generic Spring annotation for any bean. Marks a class as a Spring-managed component, used for utility or miscellaneous classes, with no specific layer or extra behavior.
   - @Service: Specialized @Component for the service layer. Indicates a class handles business logic, providing semantic clarity and potentially supporting transaction management.
   - @Repository: Specialized @Component for the data access layer. Marks a class for database operations, with added behavior like automatic exception translation for persistence-related errors.

2. **Explain Spring Boot auto-configuration**

   Spring Boot auto-configuration is a core feature that aims to simplify Spring application development by automatically configuring the application based on the dependencies present in its classpath. This significantly reduces the need for manual configuration and boilerplate code.

3. **What is MyBatis and how does it differ from Hibernate?**

- MyBatis: SQL-mapper framework; requires writing SQL manually, gives full control over queries.
- Hibernate: ORM framework; maps objects to tables automatically, generates SQL behind the scenes.

4. **How does Spring Boot handle dependency injection?**

   Spring Boot uses the Spring IoC container to automatically create and inject beans marked with annotations like @Component or @Service. It wires dependencies mainly via constructor injection, simplifying setup through auto-configuration and component scanning.

5. **What is CORS and how do you enable it in Spring Boot?**

   CORS (Cross-Origin Resource Sharing) is a mechanism that allows web browsers to make requests to a different domain than the one serving the web page. Without CORS, browsers block such requests for security reasons.

   -To Enable `@CrossOrigin`

   Enable via @CrossOrigin annotation or WebMvcConfigurer bean.

6. **How would you secure a REST API?**

- Use HTTPS to encrypt communication.
- Require authentication (JWT, OAuth2, Basic Auth)
- Limit permissions by roles
- Validate and sanitize input
- Hide sensitive error details in responses.
