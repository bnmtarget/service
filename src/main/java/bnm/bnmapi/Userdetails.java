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
    private Integer id;
    private String emailId;
    private String name;
    private String mobile_no;
    private String password;

    public Userdetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Userdetails(String emailId, String name, String mobile_no, String password) {
        this.emailId = emailId;
        this.name = name;
        this.mobile_no = mobile_no;
        this.password = password;
    }

    @Override
    public String toString() {
        return "entity{" +
                "email='" + emailId + '\'' +
                ", name='" + name + '\'' +
                ", mobile_no=" + mobile_no +
                ", password='" + password + '\'' +
                '}';
    }
}