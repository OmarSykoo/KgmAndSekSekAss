package lms.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.Course;

@Repository
public class QuestionRepository extends JpaRepository<Course, Long> {

}
