package br.unisul.collegemanagement.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link State}.
 */
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
}
