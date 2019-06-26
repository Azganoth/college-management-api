package br.unisul.collegemanagement.clazz;

import br.unisul.collegemanagement.certificate.Certificate;
import br.unisul.collegemanagement.clazz.enums.ClazzShift;
import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.exam.Exam;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.Year;
import java.util.Set;

/**
 * Representa uma turma.
 */
@Entity
@Table(name = "class")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Clazz implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de uma turma.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * O certificado de uma turma.
     * O instrutor que irá lecionar e o curso que será lecionado.
     */
    @ManyToOne
    @JoinColumns(value = {
            @JoinColumn(name = "course_id", nullable = false),
            @JoinColumn(name = "instructor_id", nullable = false)
    }, foreignKey = @ForeignKey(name = "class_certificate_fkey"))
    private Certificate certificate;

    /**
     * A descrição de uma turma.
     */
    private String description;

    /**
     * O dia da semana de uma turma.
     */
    @Column(nullable = false)
    private DayOfWeek day;

    /**
     * O semestre de uma turma.
     */
    @Column(nullable = false)
    private Integer semester;

    /**
     * O ano de uma turma.
     */
    @Column(nullable = false)
    private Year year;

    /**
     * O turno do dia de uma turma.
     */
    @Column(nullable = false, length = 30)
    private ClazzShift shift;

    /**
     * A capacidade de estudantes de uma turma.
     */
    @Column(nullable = false)
    private Integer capacity;

    /**
     * As matriculas que uma turma contém.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clazz")
    @ToString.Exclude private Set<Enrollment> enrollments;

    /**
     * As avaliações que uma turma possui.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "clazz")
    @ToString.Exclude private Set<Exam> exams;

}
