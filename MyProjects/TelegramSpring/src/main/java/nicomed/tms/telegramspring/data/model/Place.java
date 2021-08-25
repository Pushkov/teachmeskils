package nicomed.tms.telegramspring.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nicomed.tms.telegramspring.data.enums.Grade;

import javax.persistence.*;

@Entity
@Table(name = "places")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Enumerated(value = EnumType.STRING)
    private Grade grade;

    public Place(String name, Grade grade) {
        this.name = name;
        this.grade = grade;
    }
}
