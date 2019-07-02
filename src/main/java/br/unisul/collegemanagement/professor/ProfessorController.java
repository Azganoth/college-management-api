package br.unisul.collegemanagement.professor;

import br.unisul.collegemanagement.subject.Subject;
import br.unisul.collegemanagement.subject.SubjectService;
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
@RequestMapping("/professors")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfessorController {

    private final ProfessorService professorService;
    private final SubjectService subjectService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postInstructor(@Validated @RequestBody Professor professor) {
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(professorService.create(professor).getId())
                        .toUri()
        ).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> getInstructor(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.retrieveById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Professor>> getInstructors() {
        return ResponseEntity.ok(professorService.retrieveAll());
    }

    @RequestMapping(value = "/{id}/subjects", method = RequestMethod.GET)
    public ResponseEntity<List<Subject>> getSubjects(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.retrieveAllByProfessorId(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> putInstructor(@Validated @RequestBody Professor professor,
                                          @PathVariable Long id) {
        professorService.updateById(professor, id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
