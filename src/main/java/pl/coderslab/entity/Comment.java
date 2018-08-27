package pl.coderslab.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String text;
    private LocalDateTime created;
    @ManyToOne()
    private Tweet tweet;
    @ManyToOne
    private User user;
}
