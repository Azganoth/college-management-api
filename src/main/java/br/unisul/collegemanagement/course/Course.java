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

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    /**
     * O nome do curso.
     */
    @Column(unique = true, nullable = false)
    private String name;

    /**
     * A descrição do curso.
     */
    private String description;

    /**
     * Os certificados que um curso contém.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "course")
    @ToString.Exclude private Set<Certificate> certificates;

}
