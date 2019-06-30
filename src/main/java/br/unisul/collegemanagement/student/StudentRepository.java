package br.unisul.collegemanagement.student;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Student}.
 */
@Repository
public interface StudentRepository extends PersonRepository<Student> {
}
