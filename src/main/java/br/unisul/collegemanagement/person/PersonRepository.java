package br.unisul.collegemanagement.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório genérico usado pelas especializações de uma {@link Person}.
 */
@Repository
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {

    /**
     * Retorna uma lista de todos os {@link T} abrigados pelo endereço postal especificado.
     *
     * @param id o identificador de um endereço postal
     * @return uma lista de {@link T}
     */
    List<T> findAllByAddress_Id(Long id);

}
