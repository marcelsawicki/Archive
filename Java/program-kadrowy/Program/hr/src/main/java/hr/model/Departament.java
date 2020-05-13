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
public class Departament {

	public Departament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Departament(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEPARTAMENT")
	private Integer id;

	@Column(name = "DEPARTAMENTNAME")
	private String name;
	
	@Override
	public String toString() {
		return "Departament [id=" + id + ", name=" + name + "]";
	}

}
