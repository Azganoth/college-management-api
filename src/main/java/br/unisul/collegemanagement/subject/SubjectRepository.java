package br.unisul.collegemanagement.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Subject}.
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
