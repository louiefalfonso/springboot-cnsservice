package demo.cnsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmenityDto {

    private Long id;

    private String amenityName;

    private String amenityPrice;

    private String description;

    private String status;

    public String getAmenityName() {
        return amenityName;
    }

    public String getAmenityPrice() {
        return amenityPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
}
