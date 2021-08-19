package nicomed.tms.telegramspring.model;

import lombok.Data;
import nicomed.tms.telegramspring.Grade;

import javax.persistence.*;

@Entity
@Table(name = "places")
@Data
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
}
