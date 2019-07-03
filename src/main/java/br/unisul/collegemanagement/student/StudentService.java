package br.unisul.collegemanagement.student;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentService {

    private final StudentRepository studentRepository;

    public Student create(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }

    public Student retrieveById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> retrieveAll() {
        return studentRepository.findAll();
    }

    public Student updateById(Student student, Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException(
                    String.format("There's not a single fuckin one student with the id: %d.", id));
        }

        student.setId(id);
        student.setEnrollments(studentRepository.getOne(id).getEnrollments());
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
