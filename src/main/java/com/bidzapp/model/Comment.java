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
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long parent_id;

    @Column(nullable = false)
    String description;

    @Column(length = 32, columnDefinition = "varchar(32) default 'anonymous'")
    String name;

    @Column(nullable = false)
    String comment;

    @Column(nullable = false)
    Date date;

}