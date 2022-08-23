package bnm.bnmapi;

import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.mapper.ProfileDBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import bnm.bnmapi.UserRepository;
import bnm.bnmapi.Userdetails;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepos;

    @Autowired
   private ProfileRepo profileRepo;


    //getAllGroups
    public List<UserDetailsDAO> getAll(){
        return userrepos.findAll();
    }
    public List<UserProfile> getProfile(){
        return  profileRepo.findAll();
    }
    public  String createUser(Userdetails userdetails) throws SQLIntegrityConstraintViolationException {
       try {
           UserDetailsDAO dao = ProfileDBMapper.convertToProfileEntity(userdetails);
           userrepos.save(dao);
            return "User created successfully";
       }
       catch(Exception e)
       { System.out.println("duplicate key found");
           return "Found duplicate entry";
       }

    }



    public Optional<UserDetailsDAO> getUserByEmail(String email) throws UserNotFoundException {
        Optional<UserDetailsDAO> user= userrepos.findByEmail(email);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }
    public Optional<UserProfile> getProfileByEmailId(String emailId) throws UserNotFoundException {
        Optional<UserProfile> profile= profileRepo.findByEmailId(emailId);

        if(!profile.isPresent())
            throw new UserNotFoundException("user not found");
        return profile;
    }
//    public Optional<Userdetails> getUserByUserId(Integer userId) throws UserNotFoundException {
//        Optional<Userdetails> user= null;//userrepos.findByUserId(userId);
//
//        if(!user.isPresent())
//            throw new UserNotFoundException("user not found");
//        return user;
//    }
//    public Optional<Userdetails> getUserByEmailIdAndPassword(String emailId, String password)throws UserNotFoundException {
//        Optional<Userdetails> user= null;//userrepos.findByEmailIdAndPassword(emailId,password);
//        if(!user.isPresent())
//            throw new UserNotFoundException("user not found");
//        return user;
//    }

//    public Userdetails updateUserByEmailId(String emailId, Userdetails userdetails) throws UserNotFoundException {
//
//        Optional<Userdetails> userData = null;//userrepos.findByEmailId(emailId);
//
//      //  if(userrepos.findByEmailId(emailId).isPresent()) {
//            Userdetails prev = userData.get();
//            prev.setName(userdetails.getName());
//
//            prev.setMobile_no(userdetails.getMobile_no());
////            prev.setPassword(profile.getPassword());
//            return null;//userrepos.save(prev);
//   //     }
//      //  throw new UserNotFoundException("User not found");
//    }
    //public UserdetailsDAO updatePasswordByEmailId(String emailId, String password) throws UserNotFoundException {
       // Optional<Userdetails> userData = userrepos.findByEmailId(emailId);

       // if(userrepos.findByEmailId(emailId).isPresent()) {
       //     Userdetails prev = userData.get();
      //      prev.setPassword(password);
            //return null;//userrepos.save(prev);
     //   }
    //    throw new UserNotFoundException("User not found");
    //}


}