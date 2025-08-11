# Assignment 4: Short Questions & Answers

1. **Difference between @Component, @Service, @Repository**

   - `@Component` – Generic Spring-managed bean.
   - `@Service` – Specialization of `@Component` for business logic layer.
   - `@Repository` – Specialization of `@Component` for data access layer; adds exception translation.

2. **Explain Spring Boot auto-configuration**

   Spring Boot auto-configuration is a core feature that aims to simplify Spring application development by automatically configuring the application based on the dependencies present in its classpath. This significantly reduces the need for manual configuration and boilerplate code.

3. **What is MyBatis and how does it differ from Hibernate?**

- MyBatis: SQL-mapper framework; requires writing SQL manually, gives full control over queries.
- Hibernate: ORM framework; maps objects to tables automatically, generates SQL behind the scenes.

4. **How does Spring Boot handle dependency injection?**

- Uses Inversion of Control (IoC) via the Spring container.
- Beans are injected using `@Autowired`, constructor injection, or setter injection.

5. **What is CORS and how do you enable it in Spring Boot?**

   CORS (Cross-Origin Resource Sharing) is a mechanism that allows web browsers to make requests to a different domain than the one serving the web page. Without CORS, browsers block such requests for security reasons.

   -To Enable `@CrossOrigin`

   Method 1 - Global Configuration:

   @Configuration
   public class WebConfig implements WebMvcConfigurer {
   @Override
   public void addCorsMappings(CorsRegistry registry) {
   registry.addMapping('/\*_')
   .allowedOrigins('_')
   .allowedMethods("GET", "POST", "PUT", "DELETE");
   }
   }

   Method 2 - Per Controller
   @CrossOrigin(origins = "\*")
   @RestController
   public class MyController { }

6. **How would you secure a REST API?**

- Use HTTPS to encrypt communication.
- Require authentication (JWT, OAuth2, Basic Auth)
- Limit permissions by roles
- Validate and sanitize input
- Hide sensitive error details in responses.
