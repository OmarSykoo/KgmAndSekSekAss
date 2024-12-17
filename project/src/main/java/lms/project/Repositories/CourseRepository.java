package lms.project.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lms.project.Models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByName(String name);
}
