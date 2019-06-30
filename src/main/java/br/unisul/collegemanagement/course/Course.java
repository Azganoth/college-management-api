package br.unisul.collegemanagement.course;

import br.unisul.collegemanagement.certificate.Certificate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

/**
 * Representa um curso.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de um curso.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    /**
     * O nome de um curso.
     */
    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * A descrição de um curso.
     */
    private String description;

    /**
     * Os certificados que um curso possui.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @ToString.Exclude private Set<Certificate> certificates;

}
