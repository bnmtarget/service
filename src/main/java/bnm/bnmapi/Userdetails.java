//package bnm.bnmapi;
//
//import com.fasterxml.jackson.databind.PropertyNamingStrategy;
//import com.fasterxml.jackson.databind.annotation.JsonNaming;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//import javax.persistence.Column;
//import java.util.UUID;
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table("bnmuser")
//
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//public class Userdetails {
//
//    @PrimaryKey
//    @Column(name="emailId",length=30,nullable=false)
//    @NonNull
//    private String emailId;
//
//    @Column(name="user_id",nullable=false,unique=true)
//    private String userId= UUID.randomUUID().toString();;
//
//    @Column(name="first_name",length=50)
//    private String firstName;
//
//    @Column(name="last_name",length=50)
//    private String lastName;
//
//    @Column(name="mobile",length=10)
//    private String mobile;
//
//    @Column(name="password",length=30)
//    private String password;
//
//
//}
package bnm.bnmapi;
import javax.persistence.*;


@Entity
@Table(name = "profile")
public class Userdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String emailId;
    private String name;
    private String mobile_no;
    private String password;
    private String confirmpassword;
    private String gender;
    public Userdetails() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public Userdetails(Integer userId, String name, String emailId,String gender, String mobile_no, String password,String confirmpassword) {
        this.userId=userId;
        this.name = name;
        this.emailId = emailId;
        this.gender=gender;
        this.mobile_no = mobile_no;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    @Override
    public String toString() {
        return "entity{" +
                "id='" + userId + '\'' +
                ",email='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", mobile_no=" + mobile_no +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", confirmpassword='" + confirmpassword + '\'' +
                '}';
    }
}