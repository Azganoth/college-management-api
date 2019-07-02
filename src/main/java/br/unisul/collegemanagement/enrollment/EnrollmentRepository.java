package br.unisul.collegemanagement.enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Enrollment}.
 */
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPKey> {

    List<Enrollment> findAllBySubject_Id(Integer id);

    List<Enrollment> findAllByStudent_Id(Long id);

}

