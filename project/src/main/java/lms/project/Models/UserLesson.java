package lms.project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserLesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LessonId", referencedColumnName = "id")
    private Lesson lesson;
}