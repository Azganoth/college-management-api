package br.unisul.collegemanagement.instructor;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Instructor}.
 */
@Repository
public interface InstructorRepository extends PersonRepository<Instructor> {

    /**
     * Retorna uma lista de todos os instrutores abrigados pelo endereço postal especificado.
     *
     * @param id o identificador de um endereço postal
     * @return uma lista de instrutores
     */
    List<Instructor> findAllByAddress_Id(Long id);

}
