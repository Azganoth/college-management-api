package br.unisul.collegemanagement.student;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de um estudante ({@link Student}).
 */
@Repository
public interface StudentRepository extends PersonRepository<Student> {
}
