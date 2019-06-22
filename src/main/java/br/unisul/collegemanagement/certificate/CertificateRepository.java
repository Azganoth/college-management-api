package br.unisul.collegemanagement.certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para um certificado ({@link Certificate}).
 */
@Repository
public interface CertificateRepository extends JpaRepository<Certificate, CertificatePKey> {
}
