package com.mets.tracker.fuelcardtracker.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_db")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userID;
    @Column(name = "first_name")
    private String fName;
    @Column(name = "last_name")
    private String lName;
    @Column(name = "Username", unique = true)
    private String userName;
    @Column(name = "Email", unique = true, length = 45)
    private String email;
    @Column(name = "Password")
    private String password;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "card_id")
//    private Cards cards;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
