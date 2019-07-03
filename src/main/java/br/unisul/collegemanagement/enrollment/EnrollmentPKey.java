package br.unisul.collegemanagement.enrollment;

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
 * A chave composta de {@link Enrollment}.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EnrollmentPKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * O identificador de uma disciplina.
     */
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    /**
     * O identificador de um estudante.
     */
    @Column(name = "student_id", nullable = false)
    private Long studentId;

}
