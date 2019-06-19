package br.unisul.collegemanagement.address;

import br.unisul.collegemanagement.city.City;
import br.unisul.collegemanagement.person.Person;
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
import java.util.Set;

/**
 * Representa de um endereço postal.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * O nome do logradouro de um endereço postal.
     */
    @Column(nullable = false)
    private String street;

    /**
     * O número/identificador da residência de um endereço postal. (Pode conter letras.)
     */
    private String number;

    /**
     * O número/identificador do apartamento/quarto de um endereço postal. (Pode conter letras.)
     */
    private String numberAptRoom;

    /**
     * As informações adicionais de um endereço postal.
     */
    private String complement;

    /**
     * O nome do bairro de um endereço postal.
     */
    private String neighborhood;

    /**
     * O código postal de um endereço postal.
     */
    @Column(nullable = false, length = 12)
    private String postalCode;

    /**
     * A cidade em que um endereço postal reside.
     */
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false,
            foreignKey = @ForeignKey(name = "address_city_fkey"))
    private City city;

    // O estado está implícito em uma cidade.

    /**
     * As pessoas que residem em um endereço postal.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "address")
    @ToString.Exclude private Set<Person> people;

}
