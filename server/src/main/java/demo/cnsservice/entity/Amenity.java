package demo.cnsservice.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "amenities")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amenityName")
    private String amenityName;

    @Column(name = "amenityPrice")
    private String amenityPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;
}
