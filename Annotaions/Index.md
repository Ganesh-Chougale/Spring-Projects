Annotations in java is a label of a class, method, field that tells the metadata(information) to the compiler, runtime enivornment or frameworkds.  
### 1. `@Entity`  
marks the class as JPA Entity = `Database table`.  
### 2. `@Override`  
to tell the enviroment that we are intentionally overriding a method which is derived from superclass. (if we do mistake between name, parameters, return type, by help of this annotation we get compiletime error).  
### 3. `@Component`  
tell that class is Spring-managed bean.  
**When to Use?** : Use `@Component` when your class doesn’t fit into a specific role like service, repository, or controller but still needs to be managed by Spring.  
### 4. `@Bean`  
unlike @Component (which is manged by spring), `@Bean` is managed by developer to write custom logic under `@Configuration` class. this gives you more control over bean creation.  
  
