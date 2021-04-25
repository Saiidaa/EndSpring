package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;



public interface UserRepository extends JpaRepository<User, Long> {
       entity.User findByUsername(String username);

}
