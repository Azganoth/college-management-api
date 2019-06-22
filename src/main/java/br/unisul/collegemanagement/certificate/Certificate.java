package br.unisul.collegemanagement.certificate;

import br.unisul.collegemanagement.course.Course;
import br.unisul.collegemanagement.instructor.Instructor;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

/**
 * Representa um certificado.
 * (Um certificado representa o direito de um instrutor ({@link Instructor})
 * lecionar um curso ({@link Course}) para uma turma.)
 */
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Certificate implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CertificatePKey id;

    /**
     * O curso.
     */
    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    /**
     * O instrutor.
     */
    @ManyToOne
    @MapsId("instructor_id")
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    // Override default builder to properly initialize the composite primary key.
    public static class CertificateBuilder {

        CertificateBuilder() {
            this.id = new CertificatePKey();
        }

        public Certificate.CertificateBuilder course(Course course) {
            this.course = course;
            this.id.setCourse(course.getId());
            return this;
        }

        public Certificate.CertificateBuilder instructor(Instructor instructor) {
            this.instructor = instructor;
            this.id.setInstructor(instructor.getId());
            return this;
        }
    }

}
