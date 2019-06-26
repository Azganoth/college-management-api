package br.unisul.collegemanagement.grade;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * A chave composta de {@link Grade}.
 * Uma combinação entre
 * {@link br.unisul.collegemanagement.student.Student}
 * e {@link br.unisul.collegemanagement.exam.Exam}.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode
public class GradePKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * O identificador de um estudante.
     */
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    /**
     * O identificador de uma avaliação.
     */
    @Column(name = "exam_id", nullable = false)
    private Long examId;

}
