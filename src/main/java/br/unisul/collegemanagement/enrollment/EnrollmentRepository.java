package br.unisul.collegemanagement.enrollment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Enrollment}.
 */
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPKey> {
}
