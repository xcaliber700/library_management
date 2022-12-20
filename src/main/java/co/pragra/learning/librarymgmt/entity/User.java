package co.pragra.learning.librarymgmt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TABLE_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String login;
    private String password;
    private UserType userType;
    private Date createDate;
    private Date updateDate;
}
/*
    CREATE TABLE USER(ID INT, FIRST_NAME VARCHAR(255)...)
 */
