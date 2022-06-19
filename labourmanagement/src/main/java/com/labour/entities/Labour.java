package com.labour.entities;

import javax.persistence.*;

@Entity
@Table(name = "LABOUR")
public class Labour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String aadharCardNo;
    private String name;
    @Column(unique = true)
    private String mobileNo;
    private String address;
    private String work;
    private int Experience ;
    @ManyToOne
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharCardNo() {
        return aadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        this.aadharCardNo = aadharCardNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public int getExperience() {
        return Experience;
    }

    public void setExperience(int experience) {
        Experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
