package br.unisul.collegemanagement.student;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.person.Person;
import br.unisul.collegemanagement.person.enums.PersonGender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

/**
 * Representa um estudante.
 */
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends Person {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", orphanRemoval = true)
    @JsonIgnore private Set<Enrollment> enrollments;

    @Builder(builderMethodName = "studentBuilder")
    protected Student(Long id, String name, PersonGender gender, LocalDate birthDate,
                      String email, @Singular Set<String> phones, Address address) {
        super(id, name, gender, birthDate, email, phones, address);
    }

}
