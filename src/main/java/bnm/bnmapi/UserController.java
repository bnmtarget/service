package bnm.bnmapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
 public UserController(UserService userService)
 {
     this.userService=userService;
 }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world";
    }



    @GetMapping("/user")
    public List<Userdetails> getAll() {
        return userService.getAll();
    }




    @GetMapping("/user/{emailId}")
    public Optional<Userdetails> getUserByEmailId(@PathVariable("emailId") String emailId) {

        try {
            return userService.getUserByEmailId(emailId);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
//    @PostMapping("/user")
//    public Userdetails createUser(@RequestBody Userdetails userdetails) {
//        userdetails.setId(98);
//        return userService.createUser(userdetails);
//
//    }
}