package com.spring.test.ci.entities;

import com.spring.test.ci.audit.Auditable;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 12/30/2019
 */
@Entity
@Table(name = "M_USER")
@Data
@ToString(callSuper = true)
public class User extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private Integer role;
    @Column(name = "birth_day", columnDefinition = "DATETIME(3)")
    private Date birthDay;
}
