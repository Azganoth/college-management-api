package br.unisul.collegemanagement.city;

import br.unisul.collegemanagement.state.State;
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
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * Representa uma cidade.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de uma cidade.
     */
    @Positive
    @Id
    private Integer id;

    /**
     * O nome de uma cidade.
     */
    @NotBlank
    @Column(nullable = false)
    private String name;

    /**
     * O estado em que uma cidade reside.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false,
            foreignKey = @ForeignKey(name = "city_state_fkey"))
    private State state;

}
