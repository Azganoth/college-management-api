package br.unisul.collegemanagement.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório de uma unidade federal ({@link State}).
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
