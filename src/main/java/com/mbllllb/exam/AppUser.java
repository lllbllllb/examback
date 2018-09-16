package com.mbllllb.exam;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "apikey")
    private String apikey;

    @Column(name = "alias")
    private String alias;

    @Column(name = "movies")
//    @Type(type = "com.mbllllb.exam.util.GenericArrayUserType")
    private String movies;

}
