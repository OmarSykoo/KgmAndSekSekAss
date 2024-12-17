package lms.project.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import lms.project.Repositories.QuestionRepository;
import lms.project.Enums.QuestionEnum;
import lms.project.Exceptions.InstructorNotFoundException;
import lms.project.Models.Course;
import lms.project.Models.Question;
import lms.project.Repositories.CourseRepository;



@Service
@RequestScope
public class QuestionService {

    private final CourseRepository courseRepository;
    private final QuestionRepository questionRepository;

    public QuestionService(CourseRepository courseRepository_, QuestionRepository questionRepo) {
        this.courseRepository = courseRepository_;
        this.questionRepository = questionRepo;
    }

    public Question addQuestion(Long crsId, String question, QuestionEnum type, String answer) {
        Question q = new Question();
        q.setQuestion(question);
        q.setAnswer(answer);
        q.setType(type);
        Course courseID = courseRepository.findById(crsId).orElseThrow(() -> new InstructorNotFoundException("Course Not Found"));
        q.setId(crsId);
        q.setCourse(courseID);

        return questionRepository.save(q);
    }


}
