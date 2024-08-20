package com.samplename.objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @Column(name="CUSTOMER_NAME")
    String name;
    String password;
    String email;

    public String toString(){
        return "{\n\tid: " + id + ",\n\tname: " + name + ",\n\tpassword: " + password + ",\n\temail: " + email + "\n}";
    }

    public long getId(){
        return id;
    }

    public void setId(long newId){
        id = newId;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String newPassword){
        password = newPassword;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }
}
