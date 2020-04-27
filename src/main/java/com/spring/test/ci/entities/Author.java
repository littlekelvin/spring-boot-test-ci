package com.spring.test.ci.entities;

import com.spring.test.ci.audit.Auditable;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kelvin Mai
 * @date 12/24/2019
 */
@Entity
@Table(name="M_AUTHOR")
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
@AllArgsConstructor
public class Author extends Auditable<String> {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "NAME", nullable = false, length = 32)
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    private String gender;
}
