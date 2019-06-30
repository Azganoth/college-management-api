package br.unisul.collegemanagement.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Address}.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
