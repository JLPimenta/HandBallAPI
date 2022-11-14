package crp.handball.API.model.stadium;

import crp.handball.API.model.stadium.DTO.DataCreateStadium;
import crp.handball.API.model.stadium.DTO.DataUpdateStadium;
import crp.handball.API.model.stadium.address.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Stadium")
@Table(name = "stadiums")
public class Stadium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadiumid", nullable = false)
    private Integer id;

    private String name;

    @Embedded
    private Address address;

    private Boolean active;

    public Stadium(DataCreateStadium data) {
        this.active = true;
        this.name = data.name();
        this.address = new Address(data.address());
    }

    public void updateData(DataUpdateStadium data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.address() != null) {
            this.address.DataUpdateAddress(data.address());
        }
    }

    public void inactivate() {
        this.active = false;
    }

}
