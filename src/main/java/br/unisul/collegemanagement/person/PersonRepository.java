package br.unisul.collegemanagement.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório de uma pessoa ({@link Person}).
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
