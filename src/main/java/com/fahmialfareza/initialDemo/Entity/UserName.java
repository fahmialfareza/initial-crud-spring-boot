package com.fahmialfareza.initialDemo.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserName {

    @Size(min = 3, max = 50, message = "name between 3-50 characters")
    private String Name;
    private String Address;
    @Email(message = "invalid email")
    private String Email;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
