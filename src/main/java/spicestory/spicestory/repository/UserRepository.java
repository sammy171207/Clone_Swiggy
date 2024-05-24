package spicestory.spicestory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spicestory.spicestory.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
     public User findByEmail(String username);

}
