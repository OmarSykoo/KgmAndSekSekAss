package lms.project.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UserID", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "RoleID", referencedColumnName = "id")
    private Role role;
}