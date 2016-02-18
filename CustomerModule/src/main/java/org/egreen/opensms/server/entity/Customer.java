package org.egreen.opensms.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Pramoda Fernando on 3/18/2015.
 */
@Entity
@Table(name = "customer")
@JsonIgnoreProperties
public class Customer implements EntityInterface <Long> {
    private long custId;

    private String name;
    private String email;
    private String password;
    private String addressline1;
    private String addressline2;
    private String city;
    private String mobilenumber;
    private String postalcode;
    private String zipcode;
    private String state;
    private boolean status;


    @Id
    @Column(name = "cust_id")
    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "addressline1")
    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    @Basic
    @Column(name = "addressline2")
    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "mobilenumber")
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Basic
    @Column(name = "postalcode")
    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "status")
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (custId != customer.custId) return false;
        if (status != customer.status) return false;
        if (addressline1 != null ? !addressline1.equals(customer.addressline1) : customer.addressline1 != null)
            return false;
        if (addressline2 != null ? !addressline2.equals(customer.addressline2) : customer.addressline2 != null)
            return false;
        if (city != null ? !city.equals(customer.city) : customer.city != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (mobilenumber != null ? !mobilenumber.equals(customer.mobilenumber) : customer.mobilenumber != null)
            return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (password != null ? !password.equals(customer.password) : customer.password != null) return false;
        if (postalcode != null ? !postalcode.equals(customer.postalcode) : customer.postalcode != null) return false;
        if (state != null ? !state.equals(customer.state) : customer.state != null) return false;
        if (zipcode != null ? !zipcode.equals(customer.zipcode) : customer.zipcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (custId ^ (custId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (addressline1 != null ? addressline1.hashCode() : 0);
        result = 31 * result + (addressline2 != null ? addressline2.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (mobilenumber != null ? mobilenumber.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + (zipcode != null ? zipcode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }

    @Override
    @Transient
    public Long getId() {
        return getCustId();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressline1='" + addressline1 + '\'' +
                ", addressline2='" + addressline2 + '\'' +
                ", city='" + city + '\'' +
                ", mobilenumber='" + mobilenumber + '\'' +
                ", postalcode='" + postalcode + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", state='" + state + '\'' +
                ", status=" + status +
                '}';
    }
}
