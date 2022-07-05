package com.labour.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "LABOUR")
public class Labour {
    @Id
    @GeneratedValue(generator ="system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String aadharCardNo;
    private String name;
    @Column(unique = true)
    private String mobileNo;
    private String address;
    private String work;
//    private String image;
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

//    @Override
//    public String toString() {
//        return "Labour{" +
//                "aadharCardNo='" + aadharCardNo + '\'' +
//                ", name='" + name + '\'' +
//                ", mobileNo='" + mobileNo + '\'' +
//                ", address='" + address + '\'' +
//                ", work='" + work + '\'' +
//                ", Experience=" + Experience +
//                ", user=" + user +
//                '}';
//    }
}
