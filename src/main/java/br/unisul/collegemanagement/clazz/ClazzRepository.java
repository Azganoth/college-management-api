package br.unisul.collegemanagement.clazz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Clazz}.
 */
@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Long> {

    /**
     * Retorna uma lista de todos as turmas que o curso especificado possui.
     *
     * @param id o identificador de um curso
     * @return uma lista de turmas
     */
    List<Clazz> findAllByCertificate_Course_Id(Integer id);

    /**
     * Retorna uma lista de todos as turmas que o curso especificado possui.
     *
     * @param id o identificador de um instrutor
     * @return uma lista de turmas
     */
    List<Clazz> findAllByCertificate_Instructor_Id(Long id);

}
