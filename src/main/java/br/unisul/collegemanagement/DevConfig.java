package br.unisul.collegemanagement;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.address.AddressRepository;
import br.unisul.collegemanagement.city.City;
import br.unisul.collegemanagement.city.CityRepository;
import br.unisul.collegemanagement.course.Course;
import br.unisul.collegemanagement.course.CourseRepository;
import br.unisul.collegemanagement.instructor.Instructor;
import br.unisul.collegemanagement.instructor.InstructorRepository;
import br.unisul.collegemanagement.person.enums.PersonGender;
import br.unisul.collegemanagement.state.State;
import br.unisul.collegemanagement.state.StateRepository;
import br.unisul.collegemanagement.student.Student;
import br.unisul.collegemanagement.student.StudentRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Set;

@Configuration
@ConditionalOnProperty(prefix = "spring.jpa.hibernate", name = "ddl-auto", havingValue = "create")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Log4j2
public class DevConfig {

    private final StateRepository stateRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    /**
     * Sample data for testing.
     */
    @Bean
    public void letTheDataFlow() {

        State state1 = State.builder().name("Santa Catarina").abbreviation("SC").build();
        State state2 = State.builder().name("Rio de Janeiro").abbreviation("RJ").build();
        State state3 = State.builder().name("Rio Grande do Sul").abbreviation("RS").build();

        stateRepository.saveAll(Arrays.asList(state1, state2, state3));

        City city1 = City.builder().name("Laguna").state(state1).build();
        City city2 = City.builder().name("Ilha de Paquetá").state(state2).build();
        City city3 = City.builder().name("Canela").state(state3).build();

        cityRepository.saveAll(Arrays.asList(city1, city2, city3));

        Address address1 = Address.builder().street("Avenida Principal").number("12A")
                .neighborhood("Caputera").postalCode("12223-321").city(city1).build();
        Address address2 = Address.builder().street("Rua das Flores").number("32")
                .numberAptRoom("8B").postalCode("55213-232").city(city2).build();
        Address address3 = Address.builder().street("Rua Antônio Fernandes")
                .complement("Ao lado da escola.").postalCode("00000-000").city(city3).build();

        addressRepository.saveAll(Arrays.asList(address1, address2, address3));

        Instructor instructor1 = Instructor.instructorBuilder().name("Malfurion Stormrage")
                .gender(PersonGender.UNDEFINED).birthDate(LocalDate.of(1999, 8, 23))
                .email("malfurion.stormrage@gmail.com").phones(Set.of("5511988888888"))
                .address(address1).build();
        Instructor instructor2 = Instructor.instructorBuilder().name("Tyrande Whisperwind")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1996, 3, 17))
                .email("tyrande.whisperwind@gmail.com").phones(Set.of("+55 (11) 98888-8888"))
                .address(address2).build();
        Instructor instructor3 = Instructor.instructorBuilder().name("Illidan Stormrage")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1990, 12, 30))
                .email("illidan.stormrage@gmail.com").phones(Set.of("21 98888-8888"))
                .address(address3).build();

        instructorRepository.saveAll(Arrays.asList(instructor1, instructor2, instructor3));

        Student student1 = Student.studentBuilder().name("James Rob")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1999, 8, 23))
                .email("james.rob@gmail.com").phones(Set.of("0000123456789"))
                .address(address1).build();
        Student student2 = Student.studentBuilder().name("Jon Veles")
                .gender(PersonGender.UNKNOW).birthDate(LocalDate.of(1996, 3, 17))
                .email("jon.veles@gmail.com").phones(Set.of("+00 (00) 123456789"))
                .address(address2).build();
        Student student3 = Student.studentBuilder().name("Leliana Fernandes")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1990, 12, 30))
                .email("leliana.fernandes@gmail.com").phones(Set.of("00 12345-6789"))
                .address(address3).build();

        studentRepository.saveAll(Arrays.asList(student1, student2, student3));

        Course course1 = Course.builder().name("Programação em Python").build();
        Course course2 = Course.builder().name("Treinamento Illidari").build();
        Course course3 = Course.builder().name("Noções de Geometria").description("...").build();

        courseRepository.saveAll(Arrays.asList(course1, course2, course3));

    }

    /**
     * Fetch data from database to domain object, and print it.
     */
    @Bean
    public void printSavedData() {

        for (State state : stateRepository.findAll()) {
            log.info("State Entity: {}", () -> state);
        }

        for (City city : cityRepository.findAll()) {
            log.info("City Entity: {}", () -> city);
        }

        for (Address address : addressRepository.findAll()) {
            log.info("Address Entity: {}", () -> address);
        }

        for (Instructor instructor : instructorRepository.findAll()) {
            log.info("Instructor Entity: {}", () -> instructor);
        }

        for (Student student : studentRepository.findAll()) {
            log.info("Student Entity: {}", () -> student);
        }

        for (Course course : courseRepository.findAll()) {
            log.info("Course Entity: {}", () -> course);
        }

    }

}
