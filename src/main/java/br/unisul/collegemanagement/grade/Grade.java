package br.unisul.collegemanagement.grade;

import br.unisul.collegemanagement.exam.Exam;
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
 * Representa uma nota.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Grade implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave composta de uma avaliação.
     */
    @EmbeddedId
    @ToString.Exclude private GradePKey id;

    /**
     * O estudante.
     */
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id", nullable = false,
            foreignKey = @ForeignKey(name = "grade_student_fkey"))
    private Student student;

    /**
     * A avaliaçao.
     */
    @ManyToOne
    @MapsId("exam_id")
    @JoinColumn(name = "exam_id", nullable = false,
            foreignKey = @ForeignKey(name = "grade_exam_fkey"))
    private Exam exam;

    /**
     * A valor de uma nota.
     */
    private Double value;

    public static class GradeBuilder {
        private GradePKey id = new GradePKey();

        public GradeBuilder student(Student student) {
            this.student = student;
            this.id.setStudentId(student.getId());
            return this;
        }

        public GradeBuilder exam(Exam exam) {
            this.exam = exam;
            this.id.setExamId(exam.getId());
            return this;
        }

    }

}
