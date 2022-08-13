package bnm.bnmapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import bnm.bnmapi.UserRepository;
import bnm.bnmapi.Userdetails;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepos;

    @Autowired
   private ProfileRepo profileRepo;


    //getAllGroups
    public List<Userdetails> getAll(){
        return userrepos.findAll();
    }
    public List<UserProfile> getProfile(){
        return  profileRepo.findAll();
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
    public Optional<Userdetails> getUserByUserId(Integer userId) throws UserNotFoundException {
        Optional<Userdetails> user= userrepos.findByUserId(userId);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }
    public Optional<Userdetails> getUserByEmailIdAndPassword(String emailId, String password)throws UserNotFoundException {
        Optional<Userdetails> user= userrepos.findByEmailIdAndPassword(emailId,password);
        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }

    public Userdetails updateUserByEmailId(String emailId, Userdetails userdetails) throws UserNotFoundException {

        Optional<Userdetails> userData = userrepos.findByEmailId(emailId);

        if(userrepos.findByEmailId(emailId).isPresent()) {
            Userdetails prev = userData.get();
            prev.setName(userdetails.getName());

            prev.setMobile_no(userdetails.getMobile_no());
//            prev.setPassword(profile.getPassword());
            return userrepos.save(prev);
        }
        throw new UserNotFoundException("User not found");
    }
    public Userdetails updatePasswordByEmailId(String emailId, String password) throws UserNotFoundException {
        Optional<Userdetails> userData = userrepos.findByEmailId(emailId);

        if(userrepos.findByEmailId(emailId).isPresent()) {
            Userdetails prev = userData.get();
            prev.setPassword(password);
            return userrepos.save(prev);
        }
        throw new UserNotFoundException("User not found");
    }


    }