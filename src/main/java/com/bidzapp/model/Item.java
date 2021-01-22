package com.bidzapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    String ownerId;

    @Column
    String bidderId;

    @Column(nullable = false)
    String photo;

    @Column(nullable = false)
    Date bidStartDateTime;

    @Column(nullable = false)
    Date bidEndDateTime;

    @Column(columnDefinition = "0.01", nullable = false)
    Double bidMinimumAmount;

    @Column(nullable = false)
    Double bidIncrement;

    @Column
    Double bidAmount;

}
