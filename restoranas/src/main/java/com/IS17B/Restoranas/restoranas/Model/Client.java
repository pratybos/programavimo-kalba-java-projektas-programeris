package com.IS17B.Restoranas.restoranas.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;

    public Client(String s, int i){}

    public Client(String fname, String lname, String email, Long pnum){
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.phoneNumber =pnum;
    }
}
