package lms.project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "AssignmentId", referencedColumnName = "id")
    private Assignment assignment;

    private String submission;

    private String grade;
}