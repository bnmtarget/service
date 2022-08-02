//package bnm.bnmapi;
//
//
//import org.springframework.stereotype.Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import bnm.bnmapi.UserRepo;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import bnm.bnmapi.UserNotFoundException;
//@Service
//public class UserServiceImp implements UserService {
//
//    @Autowired
//    UserRepo userrepo;
//    private ResponseEntity<User> user;
//
//    public UserServiceImp(UserRepo userrepo){
//        super();
//        this.userrepo = userrepo;
//    }
//
//
//    @Override
//    public List<User> findAll() {
//        return userrepo.findAll();
//    }
//
//    @Override
//    public ResponseEntity<User> findByEmailId(@PathVariable(value = "emailId") String emailId)
//            throws UserNotFoundException {
//        User user = userrepo.findByEmailId(emailId)
//                .orElseThrow(() -> new UserNotFoundException("User not found for this ID :: " + emailId));
//
//        return ResponseEntity.ok().body(user);
//    }
//
//
//
//
//
//
//
//
//}
