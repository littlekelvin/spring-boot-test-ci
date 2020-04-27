package com.spring.test.ci.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.test.ci.audit.Auditable;
import lombok.*;

import javax.persistence.*;

/**
 * @author Kelvin Mai
 * @date 12/24/2019
 */

@Entity
@Table(name = "M_POST")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = "author")
public class Post extends Auditable<String> {

    public Post(String title, String body, Author author) {
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "body")
    private String body;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID")
    @JsonBackReference("author")
    private Author author;
}
