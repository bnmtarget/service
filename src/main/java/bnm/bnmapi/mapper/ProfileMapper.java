package bnm.bnmapi.mapper;

import bnm.bnmapi.UserProfile;
import bnm.bnmapi.Userdetails;
import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;

public class ProfileMapper {

    public static UserProfileDAO convertToProfileEntity(UserProfile userProfile) {
        UserProfileDAO profileDAO = new UserProfileDAO();
        profileDAO.setUserId(userProfile.getUserId());
        profileDAO.setAddress(userProfile.getAddress());
        profileDAO.setGender(userProfile.getGender());
        profileDAO.setName(userProfile.getName());
        profileDAO.setMobile_no(userProfile.getMobile_no());
        profileDAO.setPreffereddays(userProfile.getPreffereddays());
        profileDAO.setEmail(userProfile.getEmail());
        profileDAO.setPrefferedlocations(userProfile.getPrefferedlocations());
        profileDAO.setPrefferedstores(userProfile.getPrefferedstores());
        profileDAO.setPrefferedtimings(userProfile.getPrefferedtimings());
        return profileDAO;
    }
}
