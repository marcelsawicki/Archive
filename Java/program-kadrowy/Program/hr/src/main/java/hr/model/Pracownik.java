package hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pracownik {

	public Pracownik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pracownik(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDPRACOWNIK")
	private Integer id;

	@Column(name = "PRACOWNIKNAME")
	private String name;
	
	@Column(name = "PRACOWNIKSURNAME")
	private String surname;

	
	@Override
	public String toString() {
		return "Pracownik [id=" + id + ", name=" + name + "]";
	}

}
