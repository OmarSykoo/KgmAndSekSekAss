package lms.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
