package br.unisul.collegemanagement.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link Address}.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * Retorna uma lista de todos os endereços postais abrigados pela cidade especificada.
     *
     * @param id o identificador de uma cidade
     * @return uma lista de endereços postais
     */
    List<Address> findAllByCity_Id(Integer id);

}
