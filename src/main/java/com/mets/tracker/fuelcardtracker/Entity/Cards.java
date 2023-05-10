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



}
