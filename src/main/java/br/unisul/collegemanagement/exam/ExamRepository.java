package br.unisul.collegemanagement.exam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Exam}
 */
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
}
