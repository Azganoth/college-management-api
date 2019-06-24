package br.unisul.collegemanagement.state;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Representa uma unidade federal.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class State implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de um estado.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    /**
     * A abreviação de uma unidade federal.
     */
    @Column(name = "abbr", unique = true, nullable = false, length = 2)
    private String abbreviation;

    /**
     * O nome de uma unidade federal.
     */
    @Column(unique = true, nullable = false)
    private String name;

}
