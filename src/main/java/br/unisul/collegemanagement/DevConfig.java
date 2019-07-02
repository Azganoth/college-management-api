package br.unisul.collegemanagement;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.city.CityRepository;
import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.enrollment.EnrollmentRepository;
import br.unisul.collegemanagement.professor.Professor;
import br.unisul.collegemanagement.professor.ProfessorRepository;
import br.unisul.collegemanagement.person.enums.PersonGender;
import br.unisul.collegemanagement.student.Student;
import br.unisul.collegemanagement.student.StudentRepository;
import br.unisul.collegemanagement.subject.Subject;
import br.unisul.collegemanagement.subject.SubjectRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;

@Configuration
@ConditionalOnProperty(prefix = "spring.jpa.hibernate", name = "ddl-auto", havingValue = "create")
@DependsOn({"initializeStates", "initializeCities"})
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DevConfig {

    private final CityRepository cityRepository;
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final EnrollmentRepository enrollmentRepository;

    /**
     * Populate the database with sample data for testing.
     */
    @Bean
    protected void populateDatabaseForTesting() {
        Address address1 = Address.builder()
                .street("Rua Fernando Antônio dos Santos")
                .postalCode("88790-000")
                .city(cityRepository.getOne(24))
                .build();
        Address address2 = Address.builder()
                .street("Rua Catulo Cearense")
                .postalCode("95680-000")
                .neighborhood("Vila Haity")
                .city(cityRepository.getOne(2313))
                .build();
        Address address3 = Address.builder()
                .street("Praça do Espinhaço")
                .number("321")
                .postalCode("25000-000")
                .neighborhood("Praça Espinhaço")
                .city(cityRepository.getOne(3500))
                .build();
        Address address4 = Address.builder()
                .street("Avenida General San Martin")
                .number("23A")
                .numberAptRoom("2B")
                .neighborhood("Leblon")
                .postalCode("20000-000")
                .city(cityRepository.getOne(4522))
                .build();

        Professor professor1 = Professor.professorBuilder()
                .name("Carlos Fernando")
                .gender(PersonGender.MALE)
                .birthDate(LocalDate.of(1995, 6, 1))
                .email("carlos.fernando@gmail.com")
                .phone("2111-1111").phone("2222-2222")
                .address(address1)
                .build();
        Professor professor2 = Professor.professorBuilder()
                .name("Clara Barros")
                .gender(PersonGender.UNKNOWN)
                .birthDate(LocalDate.of(1996, 2, 13))
                .email("clara.barros@gmail.com")
                .phone("3333-3333").phone("4444-4444")
                .address(address2)
                .build();

        professorRepository.saveAll(Arrays.asList(professor1, professor2));

        Student student1 = Student.studentBuilder()
                .name("Jessica Torres")
                .gender(PersonGender.FEMALE)
                .birthDate(LocalDate.of(2003, 5, 17))
                .email("student.torres@gmail.com")
                .phone("5555-5555").phone("6666-6666")
                .address(address3)
                .build();
        Student student2 = Student.studentBuilder()
                .name("Pedrinho Neutron")
                .gender(PersonGender.UNDEFINED)
                .birthDate(LocalDate.of(2002, 8, 23))
                .email("pedrinho.neutron@gmail.com")
                .phone("7777-7777").phone("8888-8888")
                .address(address4)
                .build();

        studentRepository.saveAll(Arrays.asList(student1, student2));

        Subject subject1 = Subject.builder()
                .name("Matemática")
                .day(DayOfWeek.MONDAY)
                .year(Year.of(2019))
                .professor(professor1)
                .build();

        Subject subject2 = Subject.builder()
                .name("Português")
                .day(DayOfWeek.WEDNESDAY)
                .year(Year.of(2019))
                .professor(professor2)
                .build();

        subjectRepository.saveAll(Arrays.asList(subject1, subject2));

        Enrollment enrollment1 = new Enrollment(subject1, student1);

        Enrollment enrollment2 = new Enrollment(subject1, student2);

        Enrollment enrollment3 = new Enrollment(subject2, student1);

        Enrollment enrollment4 = new Enrollment(subject2, student2);

        enrollmentRepository.saveAll(Arrays.asList(enrollment1, enrollment2, enrollment3,
                enrollment4));
    }

}
