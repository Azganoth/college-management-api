package br.unisul.collegemanagement.subject;

import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.professor.Professor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Representa uma disciplina.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de uma disciplina.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    /**
     * O nome de uma disciplina.
     */
    @Column(unique = true, nullable = false)
    @NotBlank private String name;

    /**
     * A descrição de uma disciplina.
     */
    private String description;

    /**
     * O professor que leciona essa disciplina.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "subject_professor_fkey"))
    @NotNull private Professor professor;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "subject", orphanRemoval = true)
    @JsonIgnore private Set<Enrollment> enrollments;

}
