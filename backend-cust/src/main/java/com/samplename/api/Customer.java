package com.samplename.api;

public class Customer {
    long id;
    String name;
    String password;
    String email;

    public Customer(long id, String name, String password, String email){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

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
