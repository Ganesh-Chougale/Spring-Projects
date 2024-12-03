## UserRepository  
```java
package com.Verligence.GSRPM.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Verligence.GSRPM.Entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}
```  