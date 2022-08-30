package bnm.bnmapi.db;


import bnm.bnmapi.UserProfile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userprofile")
public class UserProfileDAO {
    @Id
    private Integer userId;
    private String name;
    private String email;
    private String prefferedlocations;
    private String prefferedtimings;
    private String preffereddays;
    private String prefferedstores;
    private String address;
    private String gender;
    private String mobile_no;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrefferedlocations() {
        return prefferedlocations;
    }

    public void setPrefferedlocations(String prefferedlocations) {
        this.prefferedlocations = prefferedlocations;
    }

    public String getPrefferedtimings() {
        return prefferedtimings;
    }

    public void setPrefferedtimings(String prefferedtimings) {
        this.prefferedtimings = prefferedtimings;
    }

    public String getPreffereddays() {
        return preffereddays;
    }

    public void setPreffereddays(String preffereddays) {
        this.preffereddays = preffereddays;
    }



    public String getAddress() {
        return address;
    }

    public String getPrefferedstores() {
        return prefferedstores;
    }

    public void setPrefferedstores(String prefferedstores) {
        this.prefferedstores = prefferedstores;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }


}
