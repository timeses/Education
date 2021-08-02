import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchase {
    @EmbeddedId
    @Getter
    @Setter
    private Key2 id;

    @Getter
    @Setter
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Getter
    @Setter
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Getter
    @Setter
    private int price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class Key2 implements Serializable {

        @Column(name = "student_name")
        private String studentName;

        @Column(name = "course_name")
        private String courseName;
    }
}
