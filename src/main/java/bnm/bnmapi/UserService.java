package bnm.bnmapi;

import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;
import bnm.bnmapi.mapper.ProfileDBMapper;
import bnm.bnmapi.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserProfileDAO> getProfile(){
        return  profileRepo.findAll();
    }
    public  String createUser(Userdetails userdetails) throws Exception {
        UserDetailsDAO dao = ProfileDBMapper.convertToProfileEntity(userdetails);
        userrepos.save(dao);
        return "User created successfully";
     //  try {
//           UserDetailsDAO dao = ProfileDBMapper.convertToProfileEntity(userdetails);
//           userrepos.save(dao);
//            return "User created successfully";
//       }
//       catch(Exception e)
//       { System.out.println("duplicate key found");
//           return "Found duplicate entry";
//       }

 }

    public  String createProfile(UserProfile userProfile) throws SQLIntegrityConstraintViolationException {
        try {
            UserProfileDAO dao = ProfileMapper.convertToProfileEntity(userProfile);
            profileRepo.save(dao);
            return "Profile created successfully";
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
    public Optional<UserProfileDAO> getProfileByEmail(String email) throws UserNotFoundException {
        Optional<UserProfileDAO> profile= profileRepo.findByEmail(email);

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

    public String updateProfileByEmail(String email, UserProfile userProfile) throws UserNotFoundException {

        //Optional<UserProfile> profileData = Optional.ofNullable(userProfile);//userrepos.findByEmailId(emailId);
      UserProfileDAO pdao= ProfileMapper.convertToProfileEntity(userProfile);
 Optional<UserProfileDAO> prev=profileRepo.findByEmail(email);
       if(profileRepo.findByEmail(email).isPresent()) {
           UserProfileDAO profile = prev.get();
            //prev.setName(userProfile.getName());

           // prev.setMobile_no(userProfile.getMobile_no());
          //  prev.setPassword(profile.getPassword());
           //profile.setMobile_no(userProfile.getMobile_no());
           profile.setPrefferedtimings(userProfile.getPrefferedtimings());
           profile.setPrefferedstores(userProfile.getPrefferedstores());
           profile.setPreffereddays(userProfile.getPreffereddays());
           profile.setPrefferedlocations(userProfile.getPrefferedlocations());
           profileRepo.save(profile);
            return " profile updated";//userrepos.save(prev);
        }
       throw new UserNotFoundException("User not found");
    }
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