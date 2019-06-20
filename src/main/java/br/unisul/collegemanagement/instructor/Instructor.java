package br.unisul.collegemanagement.instructor;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.person.Person;
import br.unisul.collegemanagement.person.enums.PersonGender;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa um instrutor.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Instructor extends Person {

    @Builder(builderMethodName = "instructorBuilder")
    protected Instructor(Long id, String name, PersonGender gender, LocalDate birthDate, String email,
                      Set<String> phones, Address address) {
        super(id, name, gender, birthDate, email, phones, address);
    }
}
