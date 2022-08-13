package bnm.bnmapi;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableAutoConfiguration
@Repository
public interface ProfileRepo extends JpaRepository<UserProfile,String> {
}
