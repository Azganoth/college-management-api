package br.unisul.collegemanagement;

import br.unisul.collegemanagement.address.Address;
import br.unisul.collegemanagement.address.AddressRepository;
import br.unisul.collegemanagement.certificate.Certificate;
import br.unisul.collegemanagement.certificate.CertificateRepository;
import br.unisul.collegemanagement.city.City;
import br.unisul.collegemanagement.city.CityRepository;
import br.unisul.collegemanagement.clazz.Clazz;
import br.unisul.collegemanagement.clazz.ClazzRepository;
import br.unisul.collegemanagement.clazz.enums.ClazzShift;
import br.unisul.collegemanagement.course.Course;
import br.unisul.collegemanagement.course.CourseRepository;
import br.unisul.collegemanagement.enrollment.Enrollment;
import br.unisul.collegemanagement.enrollment.EnrollmentRepository;
import br.unisul.collegemanagement.exam.Exam;
import br.unisul.collegemanagement.exam.ExamRepository;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Objects;

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
    private final CertificateRepository certificateRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final ClazzRepository clazzRepository;
    private final ExamRepository examRepository;

    /**
     * Sample data for testing purpuses.
     */
    @Bean
    public void populateDatabase() {

        //region states
        State state1 = State.builder().abbreviation("SC").name("Santa Catarina").build();
        State state2 = State.builder().abbreviation("RS").name("Rio Grande do Sul").build();
        State state3 = State.builder().abbreviation("SP").name("São Paulo").build();
        State state4 = State.builder().abbreviation("RJ").name("Rio de Janeiro").build();

        stateRepository.saveAll(Arrays.asList(state1, state2, state3, state4));
        //endregion

        //region cities
        City city1 = City.builder().name("Laguna").state(state1).build();
        City city2 = City.builder().name("Tubarão").state(state1).build();
        City city3 = City.builder().name("Canela").state(state2).build();
        City city4 = City.builder().name("Gramado").state(state2).build();
        City city5 = City.builder().name("São Paulo").state(state3).build();
        City city6 = City.builder().name("Campinas").state(state3).build();
        City city7 = City.builder().name("Rio de Janeiro").state(state4).build();
        City city8 = City.builder().name("Duque de Caxias").state(state4).build();

        cityRepository.saveAll(Arrays.asList(city1, city2, city3, city4, city5, city6, city7,
                city8));
        //endregion

        //region addresses
        Address address1 = Address.builder().street("Rua Fernando Antônio dos Santos")
                .postalCode("88790-000").city(city1).build();
        Address address2 = Address.builder().street("Rua Antônio Delpizzo Júnior")
                .postalCode("88700-000").city(city2).build();
        Address address3 = Address.builder().street("Rua Londres")
                .neighborhood("Vila Haity").postalCode("95680-000").city(city3).build();
        Address address4 = Address.builder().street("Rua Germano Boff")
                .postalCode("95670-000").city(city4).build();
        Address address5 = Address.builder().street("Praça do Espinhaço")
                .neighborhood("Praça Espinhaço").postalCode("04317-250").city(city5).build();
        Address address6 = Address.builder().street("Rua Marcolina Pereira")
                .postalCode("64730-000").city(city6).build();
        Address address7 = Address.builder().street("Avenida General San Martin").number("23A")
                .numberAptRoom("6")
                .neighborhood("Leblon").postalCode("20000-000").city(city7).build();
        Address address8 = Address.builder().street("Rua Catulo Cearense").number("321")
                .postalCode("25000-000").city(city8).build();

        addressRepository.saveAll(Arrays.asList(address1, address2, address3, address4, address5,
                address6, address7, address8));
        //endregion

        //region instructors
        Instructor instructor1 = Instructor.instructorBuilder().name("Roberto B. Taylor")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1991, 4, 26))
                .email("roberto.taylor@hotmail.com").phone("4986-4196")
                .address(address1).build();
        Instructor instructor2 = Instructor.instructorBuilder().name("Betty Bean")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1964, 4, 25))
                .email("betty.bean@gmail.com").phone("+55 92317-8426").phone("(61) 3980-5802")
                .address(address1).build();
        Instructor instructor3 = Instructor.instructorBuilder().name("Jack Williams")
                .gender(PersonGender.UNDEFINED).birthDate(LocalDate.of(1985, 6, 27))
                .email("jack.williams@gmail.com").phone("3641-2376").phone("99231-7866")
                .address(address2).build();
        Instructor instructor4 = Instructor.instructorBuilder().name("Janet Landry")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1995, 7, 8))
                .email("janet.landry@outlook.com").phone("(41) 25621-9654").phone("(85) 2136-4693")
                .address(address3).build();
        Instructor instructor5 = Instructor.instructorBuilder().name("Júlia Sousa Cavalcanti")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1999, 11, 9))
                .email("julia.sousa.cavalcanti@gmail.com").phone("(75) 7858-2643")
                .address(address3).build();
        Instructor instructor6 = Instructor.instructorBuilder().name("Thiago Cunha Ferreira")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1957, 3, 15))
                .email("thiago.cunha.ferreira@hotmail.com").phone("(11) 6545-9133")
                .address(address4).build();
        Instructor instructor7 = Instructor.instructorBuilder().name("Julieta Ribeiro")
                .gender(PersonGender.UNKNOWN).birthDate(LocalDate.of(1984, 9, 2))
                .email("julieta.ribeiro@outlook.com").phone("(13) 7237-5184")
                .address(address4).build();
        Instructor instructor8 = Instructor.instructorBuilder().name("Nicolash Barros Rodrigues")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1992, 1, 17))
                .email("nicolash.barros.rodrigues@gmail.com").phone("(19) 5318-2186")
                .address(address4).build();

        instructorRepository.saveAll(Arrays.asList(instructor1, instructor2, instructor3,
                instructor4, instructor5, instructor6, instructor7, instructor8));
        //endregion

        //region students
        Student student1 = Student.studentBuilder().name("Luan Santos Barros")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1997, 1, 30))
                .email("luan.santos.barros.@hotmail.com").phone("(47) 8156-9292")
                .address(address1).build();
        Student student2 = Student.studentBuilder().name("Gabriel Martins Rodrigues")
                .gender(PersonGender.UNDEFINED).birthDate(LocalDate.of(1999, 8, 13))
                .email("gabriel.martins.rodrigues@gmail.com").phone("(44) 7786-7857")
                .address(address5).build();
        Student student3 = Student.studentBuilder().name("Beatriz Oliveira")
                .gender(PersonGender.FEMALE).birthDate(LocalDate.of(1998, 9, 3))
                .email("beatriz.oliveira@gmail.com").phone("(19) 8729-6920").phone("(62) 7638-3989")
                .address(address5).build();
        Student student4 = Student.studentBuilder().name("Daniel Alves Santos")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(2001, 8, 27))
                .email("daniel.alves.santos@hotmail.com").phone("(44) 9056-4990")
                .address(address6).build();
        Student student5 = Student.studentBuilder().name("José Castro Souza")
                .gender(PersonGender.MALE).birthDate(LocalDate.of(1995, 12, 30))
                .email("jose.castro.souza@outlook.com").phone("(54) 9388-6357")
                .address(address8).build();
        Student student6 = Student.studentBuilder().name("Bruna Fernandes")
                .gender(PersonGender.UNDEFINED).birthDate(LocalDate.of(2000, 5, 25))
                .email("bruna.fernandes@gmail.com").phone("(81) 9547-2704").phone("(19) 8105-4624")
                .address(address8).build();

        studentRepository.saveAll(Arrays.asList(student1, student2, student3, student4, student5,
                student6));
        //endregion

        //region courses
        Course course1 = Course.builder().name("Programação Web")
                .description("Angular e Spring Boot").build();
        Course course2 = Course.builder().name("Grafos").build();
        Course course3 = Course.builder().name("Estrutura de Dados")
                .description("Pilha, Fila, Lista e Árvores").build();
        Course course4 = Course.builder().name("Lógica Booleana").build();
        Course course5 = Course.builder().name("Sistemas Operacionais").build();

        courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4, course5));
        //endregion

        //region certificates
        Certificate certificate1 = Certificate.builder()
                .course(course1).instructor(instructor1).build();
        Certificate certificate2 = Certificate.builder()
                .course(course1).instructor(instructor2).build();
        Certificate certificate3 = Certificate.builder()
                .course(course2).instructor(instructor1).build();
        Certificate certificate4 = Certificate.builder()
                .course(course3).instructor(instructor3).build();
        Certificate certificate5 = Certificate.builder()
                .course(course4).instructor(instructor4).build();

        certificateRepository.saveAll(Arrays.asList(certificate1, certificate2, certificate3,
                certificate4, certificate5));
        //endregion

        //region classes
        Clazz clazz1 = Clazz.builder().certificate(certificate1).day(DayOfWeek.MONDAY).semester(1)
                .year(Year.of(2019)).shift(ClazzShift.NIGHT).capacity(25).build();
        Clazz clazz2 = Clazz.builder().certificate(certificate2).day(DayOfWeek.THURSDAY).semester(1)
                .year(Year.of(2019)).shift(ClazzShift.NIGHT).capacity(30).build();
        Clazz clazz3 = Clazz.builder().certificate(certificate3).day(DayOfWeek.TUESDAY).semester(2)
                .year(Year.of(2019)).shift(ClazzShift.AFTERNOON).capacity(30).build();
        Clazz clazz4 = Clazz.builder().certificate(certificate4).day(DayOfWeek.FRIDAY).semester(1)
                .year(Year.of(2019)).shift(ClazzShift.AFTERNOON).capacity(35).build();
        Clazz clazz5 = Clazz.builder().certificate(certificate5).day(DayOfWeek.THURSDAY).semester(2)
                .year(Year.of(2019)).shift(ClazzShift.MORNING).capacity(40).build();

        clazzRepository.saveAll(Arrays.asList(clazz1, clazz2, clazz3, clazz4, clazz5));
        //endregion

        //region exams
        Exam exam1 = Exam.builder().clazz(clazz1).day(LocalDate.of(2019, 4, 15)).build();
        Exam exam2 = Exam.builder().clazz(clazz1).day(LocalDate.of(2019, 5, 23)).build();
        Exam exam3 = Exam.builder().clazz(clazz2).day(LocalDate.of(2019, 5, 14)).build();
        Exam exam4 = Exam.builder().clazz(clazz3).day(LocalDate.of(2019, 8, 13)).build();
        Exam exam5 = Exam.builder().clazz(clazz3).day(LocalDate.of(2019, 9, 17)).build();
        Exam exam6 = Exam.builder().clazz(clazz4).day(LocalDate.of(2019, 5, 24)).build();
        Exam exam7 = Exam.builder().clazz(clazz5).day(LocalDate.of(2019, 8, 22)).build();
        Exam exam8 = Exam.builder().clazz(clazz5).day(LocalDate.of(2019, 9, 26)).build();
        Exam exam9 = Exam.builder().clazz(clazz5).day(LocalDate.of(2019, 10, 17)).build();

        examRepository.saveAll(Arrays.asList(exam1, exam2, exam3, exam4, exam5, exam6, exam7, exam8,
                exam9));
        //endregion

        //region enrollments
        Enrollment enrollment1 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(1L).orElse(null)))
                .student(student1).build();
        Enrollment enrollment2 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(1L).orElse(null)))
                .student(student2).build();
        Enrollment enrollment3 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(1L).orElse(null)))
                .student(student3).build();
        Enrollment enrollment4 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(2L).orElse(null)))
                .student(student1).build();
        Enrollment enrollment5 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(2L).orElse(null)))
                .student(student4).build();
        Enrollment enrollment6 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(3L).orElse(null)))
                .student(student3).build();
        Enrollment enrollment7 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(3L).orElse(null)))
                .student(student5).build();
        Enrollment enrollment8 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(3L).orElse(null)))
                .student(student6).build();
        Enrollment enrollment9 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(4L).orElse(null)))
                .student(student2).build();
        Enrollment enrollment10 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(4L).orElse(null)))
                .student(student3).build();
        Enrollment enrollment11 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(4L).orElse(null)))
                .student(student4).build();
        Enrollment enrollment12 = Enrollment.builder().clazz(
                Objects.requireNonNull(clazzRepository.findById(4L).orElse(null)))
                .student(student5).build();

        enrollmentRepository.saveAll(Arrays.asList(enrollment1, enrollment2, enrollment3,
                enrollment4, enrollment5, enrollment6, enrollment7, enrollment8, enrollment9,
                enrollment10, enrollment11, enrollment12));
        //endregion

    }

    /**
     * Fetch data from database, and print it.
     */
    @Bean
    public void printItAll() {

        for (State state : stateRepository.findAll()) {
            log.info(state);
        }

        for (City city : cityRepository.findAll()) {
            log.info(city);
        }

        for (Address address : addressRepository.findAll()) {
            log.info(address);
        }

        for (Instructor instructor : instructorRepository.findAll()) {
            log.info(instructor);
        }

        for (Student student : studentRepository.findAll()) {
            log.info(student);
        }

        for (Course course : courseRepository.findAll()) {
            log.info(course);
        }

        for (Certificate certificate : certificateRepository.findAll()) {
            log.info(certificate);
        }

        for (Clazz clazz : clazzRepository.findAll()) {
            log.info(clazz);
        }

        for (Exam exam : examRepository.findAll()) {
            log.info(exam);
        }

        for (Enrollment enrollment : enrollmentRepository.findAll()) {
            log.info(enrollment);
        }

    }

}
