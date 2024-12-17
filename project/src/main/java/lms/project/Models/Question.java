package lms.project.Models;

import jakarta.persistence.*;
import lms.project.Enums.QuestionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CourseID", referencedColumnName = "id")
    private Course course;

    private String question;

    @Enumerated(EnumType.STRING)
    private QuestionEnum type;

    private String answer;
}