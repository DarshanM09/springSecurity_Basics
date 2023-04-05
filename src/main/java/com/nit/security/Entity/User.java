package com.nit.security.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @SequenceGenerator(name = "Seq_User_gen",sequenceName = "Seq_User_gen",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Seq_User_gen")
    private int uid;
    private String username;
    private String password;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Security_Role",
            joinColumns = @JoinColumn(name = "uid",referencedColumnName = "uid"))
    @Column(name = "role")
    private Set<String> role;



}
