package com.github.curriculeon.models.eap;

import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class SignUpForm implements EntityInterface<Long> {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String state;
    private String zipcode;
    private boolean emailUpdate;
    private LocalDateTime signedUpDate;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isEmailUpdate() {
        return emailUpdate;
    }

    public void setEmailUpdate(boolean emailUpdate) {
        this.emailUpdate = emailUpdate;
    }

    public LocalDateTime getSignedUpDate() {
        return signedUpDate;
    }

    public void setSignedUpDate(LocalDateTime signedUpDate) {
        this.signedUpDate = signedUpDate;
    }
}
