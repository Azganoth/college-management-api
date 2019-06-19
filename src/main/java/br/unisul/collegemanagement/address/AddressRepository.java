package br.unisul.collegemanagement.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório de um endereço postal ({@link Address}).
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
