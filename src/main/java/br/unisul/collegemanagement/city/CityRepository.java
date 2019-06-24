package br.unisul.collegemanagement.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * O repositório responsável pela persistência de {@link City}.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    /**
     * Retorna uma lista de todas as cidades abrigadas pelo estado especificado.
     *
     * @param id o identificador de um estado
     * @return uma lista de cidades
     */
    List<City> findAllByState_Id(Integer id);

}
