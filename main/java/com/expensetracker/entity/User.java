package com.expensetracker.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "expensetracker.user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private String address;
    private String mobno;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String password;

    public User() {
    }

    public User(String fName, String lName, String address, String mobno, Date dob, String password) {
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.mobno = mobno;
        this.dob = dob;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
