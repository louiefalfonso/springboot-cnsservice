package demo.cnsservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookingName")
    private String bookingName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy")
    @Column(name = "bookingDate")
    private LocalDate bookingDate;

    @Column(name = "price")
    private String price;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    /*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "amenity_id")
    private Amenity amenity;
    */


}
