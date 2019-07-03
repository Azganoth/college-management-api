package br.unisul.collegemanagement.enrollment;

import br.unisul.collegemanagement.student.Student;
import br.unisul.collegemanagement.subject.Subject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Representa uma matricula.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Enrollment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave composta de uma matricula.
     */
    @EmbeddedId
    @ToString.Exclude private EnrollmentPKey id;

    /**
     * A disciplina.
     */
    @ManyToOne
    @MapsId("subject_id")
    @JoinColumn(name = "subject_id", nullable = false,
            foreignKey = @ForeignKey(name = "enrollment_subject_fkey"))
    @NotNull private Subject subject;

    /**
     * O estudante.
     */
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", nullable = false,
            foreignKey = @ForeignKey(name = "enrollment_student_fkey"))
    @NotNull private Student student;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "GRADE", foreignKey = @ForeignKey(name = "enrollment_grade_fkey"))
    @Column(name = "value", nullable = false)
    @NotEmpty @Size(min = 3, max = 3)
    private List<@NotNull @DecimalMin("0.0") @DecimalMax("10.0") BigDecimal> grades;

    public Enrollment(Subject subject, Student student) {
        this.id = new EnrollmentPKey();
        this.subject = subject;
        this.id.setSubjectId(subject.getId());
        this.student = student;
        this.id.setStudentId(student.getId());
        this.initializeGrades();
    }

    public void initializeGrades() {
        this.grades = Arrays.asList(random(), random(), random());
    }

    private BigDecimal random() {
        BigDecimal max = new BigDecimal("10.0");
        return BigDecimal.ZERO.add(max.multiply(new BigDecimal(Math.random())));
    }

}
