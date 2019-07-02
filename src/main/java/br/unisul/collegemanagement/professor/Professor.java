package br.unisul.collegemanagement.professor;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.person.Person;
import br.unisul.collegemanagement.person.enums.PersonGender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa um professor.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Professor extends Person {

    @Builder(builderMethodName = "professorBuilder")
    protected Professor(Long id, String name, PersonGender gender, LocalDate birthDate,
                        String email, @Singular Set<String> phones, Address address) {
        super(id, name, gender, birthDate, email, phones, address);
    }

}
