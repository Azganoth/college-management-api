package br.unisul.collegemanagement.instructor;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Instructor}.
 */
@Repository
public interface InstructorRepository extends PersonRepository<Instructor> {
}
