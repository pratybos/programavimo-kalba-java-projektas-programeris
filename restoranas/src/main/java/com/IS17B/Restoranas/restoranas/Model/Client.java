package com.IS17B.Restoranas.restoranas.Model;


public class Client {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phoneNumber;

    public Client(){

    }

    public Client(Integer id, String firstName, String lastName, String email, Integer phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return id+firstName+lastName+email+phoneNumber;
    }
}
