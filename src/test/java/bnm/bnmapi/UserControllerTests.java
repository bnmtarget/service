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
