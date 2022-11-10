package br.com.handballCamp.data.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String birthDate;

	@Enumerated(EnumType.ORDINAL) // M == 1 | F == 2 | OT == 3
	private Gender gender;
	private Double height;

	@Enumerated(EnumType.ORDINAL) // Capitão == 2
	private TypePlayer type;

	public Person(String name, String birthDate, Gender gender, Double height) {
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.height = height;
		this.type = TypePlayer.PLAYER;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", height="
				+ height + ", type=" + type + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TypePlayer getType() {
		return type;
	}

	public void setType(TypePlayer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
}