package com.github.curriculeon.models.eap;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class SignUpForm {

    private String name;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String state;
    private String zipcode;
    private boolean emailUpdate;
    private LocalDateTime signedUpDate;

}
