package br.unisul.collegemanagement.instructor;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de um instrutor ({@link Instructor}).
 */
@Repository
public interface InstructorRepository extends PersonRepository<Instructor> {
}
