package br.unisul.collegemanagement.person;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.person.enums.PersonGender;
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
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa uma pessoa.
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * O nome de uma pessoa.
     */
    @Column(nullable = false)
    private String name;

    /**
     * O gênero de uma pessoa.
     */
    @Column(nullable = false)
    private PersonGender gender;

    /**
     * A data de nascimento de uma pessoa.
     */
    @Column(nullable = false)
    private LocalDate birthDate;

    /**
     * O endereço de email de uma pessoa.
     */
    @Column(unique = true)
    private String email;

    /**
     * Os números de telefone de uma pessoa.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PHONE", foreignKey = @ForeignKey(name = "person_phone_fkey"))
    @Column(name = "p_number", nullable = false, length = 20)
    @NotEmpty // TODO: validation without javax constraints for elementcollections
    private Set<@NotBlank String> phones;

    /**
     * O endereço postal de uma pessoa.
     */
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false,
            foreignKey = @ForeignKey(name = "person_address_fkey"))
    private Address address;

}
