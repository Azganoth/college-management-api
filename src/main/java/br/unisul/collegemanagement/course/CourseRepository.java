package br.unisul.collegemanagement.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de um curso ({@link Course}).
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
