package br.unisul.collegemanagement.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório de uma cidade ({@link City}).
 */
@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
