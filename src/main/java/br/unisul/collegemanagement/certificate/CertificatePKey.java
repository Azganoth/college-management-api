package br.unisul.collegemanagement.certificate;

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
 * A chave composta de {@link Certificate}.
 * Uma combinação entre {@link br.unisul.collegemanagement.course.Course}
 * e {@link br.unisul.collegemanagement.instructor.Instructor}.
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode
public class CertificatePKey implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * O identificador de um curso.
     */
    @Column(name = "course_id")
    private Integer courseId;

    /**
     * O identificador de um instrutor.
     */
    @Column(name = "instructor_id")
    private Long instructorId;

}
