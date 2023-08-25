package com.org.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User_table")
public class User {

    @Id
    private String id;

    @Column(name = "f_name")
    private String fname;
    @Column(name = "l_name")
    private String lname;
    private String email;
    private String password;
}
