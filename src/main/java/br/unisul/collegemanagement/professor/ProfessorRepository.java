package br.unisul.collegemanagement.professor;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Professor}.
 */
@Repository
public interface ProfessorRepository extends PersonRepository<Professor> {
}
