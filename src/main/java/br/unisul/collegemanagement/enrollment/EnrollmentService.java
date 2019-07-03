package br.unisul.collegemanagement.enrollment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public Enrollment create(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> findAllBySubjectId(Integer id) {
        return enrollmentRepository.findAllBySubject_Id(id);
    }

    public List<Enrollment> findAllByStudentId(Long id) {
        return enrollmentRepository.findAllByStudent_Id(id);
    }

    public void deleteById(Integer subjectId, Long studentId) {
        enrollmentRepository.deleteById(new EnrollmentPKey(subjectId, studentId));
    }

}
