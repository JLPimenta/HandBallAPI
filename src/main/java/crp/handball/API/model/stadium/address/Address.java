package crp.handball.API.model.stadium.address;

import crp.handball.API.model.stadium.address.DTO.DataAddress;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String place;
	private String number;
	private String city;
	private String state;
	private String zipCode;

	public Address(DataAddress data) {
		this.place = data.place();
		this.number = data.number();
		this.city = data.city();
		this.state = data.state();
		this.zipCode = data.zipCode();
	}

	public void DataUpdateAddress(DataAddress data) {

		if (data.place() != null) {
			this.place = data.place();
		}
		if (data.number() != null) {
			this.number = data.number();
		}
		if (data.city() != null) {
			this.city = data.city();
		}
		if (data.state() != null) {
			this.state = data.state();
		}
		if (data.zipCode() != null) {
			this.zipCode = data.zipCode();
		}
	}

}