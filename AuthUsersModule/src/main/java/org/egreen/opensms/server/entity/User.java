package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Pramoda Fernando on 1/13/2015.
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties
public class User implements EntityInterface <Long>{

    private Long user_id;
    @JsonIgnoreProperties
    private String firstname;

    private String lastname;

    private String email;

    private String contactnum;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private String password;

    private Integer account_status;

    private String permissionlevel;

    private String remark;



    @Id
    @Column(name = "user_id")
    public Long getUser_id() {
        return user_id;
    }


    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactnum() {
        return contactnum;
    }

    public void setContactnum(String contactnum) {
        this.contactnum = contactnum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccount_status() {
        return account_status;
    }

    public void setAccount_status(Integer account_status) {
        this.account_status = account_status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPermissionlevel() {
        return permissionlevel;
    }

    public void setPermissionlevel(String permissionlevel) {
        this.permissionlevel = permissionlevel;
    }

    @Override
    @Transient
    public Long getId() {
        return getUser_id();
    }


    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", contactnum='" + contactnum + '\'' +
                ", password='" + password + '\'' +
                ", account_status=" + account_status +
                ", permissionlevel='" + permissionlevel + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
