package co.pragra.learning.librarymgmt.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private UserType userType;
    private Date createDate;
    private Date updateDate;
}
/*
    CREATE TABLE USER(ID INT, FIRST_NAME VARCHAR(255)...)
 */
