package com.mets.tracker.fuelcardtracker.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="Cards_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Cards {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long CardID;
    @Column(name = "Card_Number")
    private Long CardNo;
    @Column(name = "PIN")
    private int PIN;
    @Column(name = "Card_Type")
    private String type;


    public Long getCardID() {
        return CardID;
    }

    public void setCardID(Long cardID) {
        CardID = cardID;
    }

    public Long getCardNo() {
        return CardNo;
    }

    public void setCardNo(Long cardNo) {
        CardNo = cardNo;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
