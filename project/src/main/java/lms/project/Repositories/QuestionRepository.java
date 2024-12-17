package lms.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.Course;
import lms.project.Models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
