package br.unisul.collegemanagement.enrollment;

import br.unisul.collegemanagement.clazz.Clazz;
import br.unisul.collegemanagement.student.Student;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

/**
 * Representa uma matricula.
 */
@Entity
@Builder
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
     * A turma.
     */
    @ManyToOne
    @MapsId("class_id")
    @JoinColumn(name = "class_id", nullable = false,
            foreignKey = @ForeignKey(name = "enrollment_class_fkey"))
    private Clazz clazz;

    /**
     * O estudante.
     */
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", nullable = false,
            foreignKey = @ForeignKey(name = "enrollment_student_fkey"))
    private Student student;

    public static class EnrollmentBuilder {
        private EnrollmentPKey id = new EnrollmentPKey();

        public EnrollmentBuilder clazz(Clazz clazz) {
            this.clazz = clazz;
            this.id.setClazzId(clazz.getId());
            return this;
        }

        public EnrollmentBuilder student(Student student) {
            this.student = student;
            this.id.setStudentId(student.getId());
            return this;
        }

    }

}
