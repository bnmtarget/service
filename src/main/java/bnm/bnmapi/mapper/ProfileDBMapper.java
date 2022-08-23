package bnm.bnmapi.mapper;

import bnm.bnmapi.Userdetails;
import bnm.bnmapi.db.UserDetailsDAO;

public class ProfileDBMapper {

    public static UserDetailsDAO convertToProfileEntity(Userdetails userdetails) {
        UserDetailsDAO userDao = new UserDetailsDAO();
        userDao.setUser_Id(userdetails.getUserId());
        userDao.setName(userdetails.getName());
        userDao.setPassword(userdetails.getPassword());
        userDao.setEmail(userdetails.getEmail());
        userDao.setGender(userdetails.getGender());
        userDao.setMobile_no(userdetails.getMobile_no());
        return userDao;

    }
}
