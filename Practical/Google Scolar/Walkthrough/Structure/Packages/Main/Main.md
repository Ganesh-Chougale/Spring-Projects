path : src/main/java/com/verligence/GSRPM  
## DatabaseHealthCheck.java :  
```java
package com.Verligence.GSRPM;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseHealthCheck implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) {
        try {
            // Test the database connection
            jdbcTemplate.execute("SELECT 1");
            System.out.println("✅ Successfully connected to the database!");
        } catch (Exception e) {
            System.err.println("❌ Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```  
## GsrpmApplication.java :  
```java
package com.Verligence.GSRPM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GsrpmApplication {

	public static void main(String[] args) {
		System.out.println("Main File Check ✅");
		SpringApplication.run(GsrpmApplication.class, args);
	}

}
```  
