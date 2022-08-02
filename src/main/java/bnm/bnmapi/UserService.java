package bnm.bnmapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepos;



    //getAllGroups
    public List<Userdetails> getAll(){
        return userrepos.findAll();
    }
    public Userdetails createUser(Userdetails userdetails) {
        return userrepos.save(userdetails);
    }



    public Optional<Userdetails> getUserByEmailId(String emailId) throws UserNotFoundException {
        Optional<Userdetails> user= userrepos.findByEmailId(emailId);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }


    }