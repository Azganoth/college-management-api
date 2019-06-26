package br.unisul.collegemanagement.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Grade}.
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, GradePKey> {

    /**
     * Retorna uma lista de todas as notas possuidas pelo estudante especificado.
     *
     * @param id o identificador de um estudante
     * @return uma lista de notas
     */
    List<Grade> findAllByStudent_Id(Long id);

    /**
     * Retorna uma lista de todas as notas possuidas pela avaliação especificada.
     *
     * @param id o identificador de uma avaliação
     * @return uma lista de notas
     */
    List<Grade> findAllByExam_Id(Long id);

}
