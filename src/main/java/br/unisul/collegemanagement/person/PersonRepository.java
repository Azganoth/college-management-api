package br.unisul.collegemanagement.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório genérico para especializações de uma pessoa ({@link Person}).
 */
@Repository
public interface PersonRepository<T extends Person> extends JpaRepository<T, Long> {
}
