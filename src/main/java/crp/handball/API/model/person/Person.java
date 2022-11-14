package crp.handball.API.model.person;

import crp.handball.API.model.person.DTO.DataCreatePerson;
import crp.handball.API.model.person.DTO.DataUpdatePerson;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Person")
@Table(name = "people")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personid", nullable = false)
	private Integer id;

	private String name;
	private String birthDate;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Double height;
	private Double weight;

	private Boolean active;

	@Enumerated(EnumType.STRING)
	private TypePlayer type;

	public Person(DataCreatePerson data) {
		this.active = true;
		this.name = data.name();
		this.birthDate = data.birthDate();
		this.gender = data.gender();
		this.height = data.height();
		this.weight = data.weight();
		this.type = TypePlayer.PLAYER;
	}

	public void updateData(DataUpdatePerson data) {

		if (data.name() != null) {
			this.name = data.name();
		}
		if (data.birthDate() != null) {
			this.birthDate = data.birthDate();
		}
		if (data.gender() != null) {
			this.gender = data.gender();
		}
		if (data.height() != null) {
			this.height = data.height();
		}
		if (data.weight() != null) {
			this.weight = data.weight();
		}
	}

	public void inactivate() {
		this.active = false;
	}
}