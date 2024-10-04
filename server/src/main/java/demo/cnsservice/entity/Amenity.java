package demo.cnsservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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

    //Getters & Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmenityName(String amenityName) {
        this.amenityName = amenityName;
    }

    public void setAmenityPrice(String amenityPrice) {
        this.amenityPrice = amenityPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
