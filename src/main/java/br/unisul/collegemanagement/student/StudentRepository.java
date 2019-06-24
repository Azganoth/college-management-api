package br.unisul.collegemanagement.student;

import br.unisul.collegemanagement.person.PersonRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Student}.
 */
@Repository
public interface StudentRepository extends PersonRepository<Student> {

    /**
     * Retorna uma lista de todos os estudantes abrigados pelo endereço postal especificado.
     *
     * @param addressId o identificador de um endereço postal
     * @return uma lista de estudantes
     */
    List<Student> findAllByAddress_Id(Long addressId);

}
