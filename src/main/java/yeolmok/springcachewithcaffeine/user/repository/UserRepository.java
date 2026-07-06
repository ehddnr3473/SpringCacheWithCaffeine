package yeolmok.springcachewithcaffeine.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yeolmok.springcachewithcaffeine.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
