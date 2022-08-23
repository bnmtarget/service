package bnm.bnmapi;

import bnm.bnmapi.db.UserDetailsDAO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableAutoConfiguration
@Repository
public interface UserRepository extends JpaRepository<UserDetailsDAO,String> {
   Optional<UserDetailsDAO> findByEmail(String email);

  //  Optional<Userdetails> findByEmailIdAndPassword(String emailId,String password);


   // Optional<Userdetails> findByUserId(Integer userId);
}