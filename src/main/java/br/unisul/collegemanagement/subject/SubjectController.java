package br.unisul.collegemanagement.subject;

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
@RequestMapping("/subjects")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SubjectController {

    private final SubjectService subjectService;
    private final EnrollmentService enrollmentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postSubject(@Validated @RequestBody Subject subject) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(subjectService.create(subject).getId())
                        .toUri()
        ).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Subject> getSubject(@PathVariable Integer id) {
        return ResponseEntity.ok(subjectService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjects() {
        return ResponseEntity.ok(subjectService.retrieveAll());
    }

    @RequestMapping(value = "/{id}/enrollments", method = RequestMethod.GET)
    public ResponseEntity<List<Enrollment>> getEnrollments(@PathVariable Integer id) {
        return ResponseEntity.ok(enrollmentService.findAllBySubjectId(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> putSubject(@Validated @RequestBody Subject subject,
                                          @PathVariable Integer id) {
        subjectService.updateById(subject, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubject(@PathVariable Integer id) {
        subjectService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{subjectId}/{studentId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Integer subjectId,
                                                 @PathVariable Long studentId) {
        enrollmentService.deleteById(subjectId, studentId);
        return ResponseEntity.noContent().build();
    }

}
