import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @EmbeddedId
    @Getter
    @Setter
    private Key3 key;

    public LinkedPurchaseList(Student student, Course course) {
        this.key = new Key3(student, course);
    }

    public LinkedPurchaseList() {
    }

    @Data
    @Embeddable
    public class Key3 implements Serializable {

        public Key3(Student student, Course course) {
            this.student = student;
            this.course = course;
        }

        public Key3() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key3 key3 = (Key3) o;
            return Objects.equals(student, key3.student) && Objects.equals(course, key3.course);
        }

        @Override
        public int hashCode() {
            return Objects.hash(student, course);
        }

        @Getter
        @Setter
        @ManyToOne
        @JoinColumn(name = "student_id", insertable = false, updatable = false)
        private Student student;

        @Getter
        @Setter
        @ManyToOne
        @JoinColumn(name = "course_id", insertable = false, updatable = false)
        private Course course;
    }
}
