package br.unisul.collegemanagement.enrollment;

import br.unisul.collegemanagement.student.StudentService;
import br.unisul.collegemanagement.subject.SubjectService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enrollments")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EnrollmentController {

    private final SubjectService subjectService;
    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postEnrollment(@RequestBody EnrollmentPKey enrollmentPKey) {
        enrollmentService.create(new Enrollment(
                subjectService.retrieveById(enrollmentPKey.getSubjectId()),
                studentService.retrieveById(enrollmentPKey.getStudentId())));
        return ResponseEntity.noContent().build();
    }

}
