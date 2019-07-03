package br.unisul.collegemanagement.student;

import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.enrollment.EnrollmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentController {

    private final StudentService studentService;
    private final EnrollmentService enrollmentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postStudent(@Validated @RequestBody Student student) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(studentService.create(student).getId())
                        .toUri()
        ).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.retrieveAll());
    }

    @RequestMapping(value = "/{id}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> getEnrollments(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.findAllByStudentId(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> putStudent(@Validated @RequestBody Student student,
                                           @PathVariable Long id) {
        studentService.updateById(student, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
