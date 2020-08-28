package com.example.instagramclonefull;

public class RegistrationDetails {

    RegistrationDetails(){};

    String Name, Email,Password,Phone;

    RegistrationDetails(String Name,String Email, String Password,String Phone)
    {
        this.Name=Name;
        this.Email=Email;
        this.Phone=Phone;
        this.Password=Password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
