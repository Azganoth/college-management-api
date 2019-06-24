package br.unisul.collegemanagement.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * O repositório responsável pela persistência de {@link Course}.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
