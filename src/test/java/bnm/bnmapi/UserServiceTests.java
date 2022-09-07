//package bnm.bnmapi;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.junit.runner.RunWith;
//import java.util.Optional;
//import static org.mockito.BDDMockito.given;
//import bnm.bnmapi.Userdetails;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import bnm.bnmapi.UserController;
//@RunWith(SpringJUnit4ClassRunner.class)
//public class UserControllerTests {
//    @Autowired
//    MockMvc mockMvc;
//    @Mock
//    private UserController userController ;
//    public UserControllerTests( ){
//    }
//
//    public void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//    @Test
//    public void createUser() throws Exception {
//        Userdetails userdetails = new Userdetails();
//        userdetails.setEmailId("testcase@gmail.com");
//        userdetails.setId(98);
//        userdetails.setName("test");
//
//        userdetails.setMobile_no("907565430");
//        userdetails.setPassword("password");
//
//        String message=new String();
//        given(userController.createUser(userdetails)).willReturn(userdetails);
//        mockMvc.perform(post("/api/user")
//                        .content(asJsonString(message))
//                        .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//    public static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void getUserByEmailId() throws Exception {
//        Userdetails userdetails = new Userdetails();
//        userdetails.setEmailId("abc12@gmail.com");
//        userdetails.setId(1);
//        userdetails.setName("abc");
//        userdetails.setMobile_no("908078891");
//
//        userdetails.setPassword("12345");
//
//        given(userController.getUserByEmailId(userdetails.getEmailId())).willReturn(Optional.of(userdetails));
//        mockMvc.perform(get("/api/user/abc12@gmail.com")
//                        .contentType(APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//
//
//}


package bnm.bnmapi;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import bnm.bnmapi.db.UserDetailsDAO;
import bnm.bnmapi.db.UserProfileDAO;
import bnm.bnmapi.mapper.ProfileMapper;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {
    @org.junit.Test
    public void testForGetUserByEmail() throws UserNotFoundException {
        UserRepository ur = Mockito.mock(UserRepository.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserDetailsDAO usd = new UserDetailsDAO();
        usd.setEmail("abc@gmail.com");
        usd.setGender("male");
        usd.setUser_Id(1);
        usd.setMobile_no("234653221");
        usd.setName("abc");
        usd.setPassword("abc123");
        Optional<UserDetailsDAO> userd1 = Optional.of(usd);
        when(ur.findByEmail(any())).thenReturn(userd1);
        Optional<UserDetailsDAO> userd = Optional.of(usd);
        assertEquals(userd.get(), us.getUserByEmail("abc@gmail.com").get());
    }
    @org.junit.Test
    public void testForGetProfileByEmail() throws UserNotFoundException {
        ProfileRepo ur = Mockito.mock(ProfileRepo.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserProfileDAO usd = new UserProfileDAO();
        usd.setGender("male");
        usd.setMobile_no("234653221");
        usd.setName("abc");
        usd.setEmail("abc@gmail.com");
        usd.setAddress("hyderabad");
        usd.setPreffereddays("sunday");
        usd.setUserId(1);
        usd.setPrefferedlocations("hyderabad");
        usd.setPrefferedstores("lifestyle");
        usd.setPrefferedtimings("10pm");
        Optional<UserProfileDAO> userd1 = Optional.of(usd);
        when(ur.findByEmail(any())).thenReturn(userd1);
        Optional<UserProfileDAO> userd = Optional.of(usd);
        assertEquals(userd.get(), us.getProfileByEmail("abc@gmail.com").get());
    }

    //duplicate key problem!!!!!!!!!
    @org.junit.Test
    public void testForCreateProfile() throws SQLIntegrityConstraintViolationException {
        ProfileRepo ur = Mockito.mock(ProfileRepo.class);//repo class called to define the service function
        UserService us = new UserService(ur);//to call the function of the service layer
        UserProfile usd = new UserProfile();
        UserProfileDAO dao = ProfileMapper.convertToProfileEntity(usd);
        usd.setGender("male");
        usd.setMobile_no("234653221");
        usd.setName("Vishwa");
        usd.setEmail("vishwa12@gmail.com");
        usd.setAddress("hyderabad");
        usd.setPreffereddays("sunday");
        usd.setUserId(199876);
        usd.setPrefferedlocations("hyderabad");
        usd.setPrefferedstores("lifestyle");
        usd.setPrefferedtimings("10pm");

        when(ur.save(any())).thenReturn(any());

        assertEquals("Profile created successfully", us.createProfile(usd));
    }
}
