package br.unisul.collegemanagement.person;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.person.enums.PersonGender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa uma pessoa.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * A chave primária de uma pessoa.
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    /**
     * O nome de uma pessoa.
     */
    @Column(nullable = false)
    @NotBlank private String name;

    /**
     * O gênero de uma pessoa.
     */
    @Column(nullable = false, length = 30)
    @NotNull private PersonGender gender;

    /**
     * A data de nascimento de uma pessoa.
     */
    @Column(nullable = false)
    @NotNull @Past private LocalDate birthDate;

    /**
     * O endereço de email de uma pessoa.
     */
    @Column(unique = true)
    @Email private String email;

    /**
     * Os números de telefone de uma pessoa.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PHONE", foreignKey = @ForeignKey(name = "person_phone_fkey"))
    @Column(name = "number", nullable = false, length = 19)
    @NotEmpty private Set<@NotBlank String> phones;

    /**
     * O endereço postal de uma pessoa.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "address_id", unique = true, nullable = false,
            foreignKey = @ForeignKey(name = "person_address_fkey"))
    @NotNull private Address address;

}
