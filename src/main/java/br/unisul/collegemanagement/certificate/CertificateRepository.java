package br.unisul.collegemanagement.certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Certificate}.
 */
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, CertificatePKey> {

    /**
     * Retorna uma lista de todos os certificados possuidos pelo instrutor especificado.
     *
     * @param id o identificador de um instrutor
     * @return uma lista de certificados
     */
    List<Certificate> findAllByInstructor_Id(Long id);

    /**
     * Retorna uma lista de todos os certificados possuidos pelo curso especificado.
     *
     * @param id o identificador de um curso
     * @return uma lista de certificados
     */
    List<Certificate> findAllByCourse_Id(Integer id);

}
