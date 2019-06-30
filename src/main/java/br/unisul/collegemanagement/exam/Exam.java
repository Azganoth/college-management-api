package br.unisul.collegemanagement.exam;

import br.unisul.collegemanagement.clazz.Clazz;
import br.unisul.collegemanagement.grade.Grade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa uma avaliação.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de uma avaliação.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * A turma da avaliação.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "class_id", nullable = false,
            foreignKey = @ForeignKey(name = "exam_class_fkey"))
    private Clazz clazz;

    /**
     * O tópico da avaliação.
     */
    private String topic;

    /**
     * A data da avaliação.
     */
    @NotNull
    @Column(nullable = false)
    private LocalDate day;

    /**
     * As notas que uma avaliação possui.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exam")
    @ToString.Exclude private Set<Grade> grades;

}
