package pl.com.pomiarcisnienia.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@Table(name="rola")
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=20)
	private String rola;

	//bi-directional many-to-many association to Osoba
	@ManyToMany(mappedBy="role", fetch=FetchType.EAGER)
	private Set<Osoba> osoby = new HashSet<Osoba>();

	public Rola() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	public Set<Osoba> getOsoby() {
		return this.osoby;
	}

	public void setOsoby(Set<Osoba> osoby) {
		this.osoby = osoby;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((osoby == null) ? 0 : osoby.hashCode());
		result = prime * result + ((rola == null) ? 0 : rola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rola other = (Rola) obj;
		if (id != other.id)
			return false;
		if (osoby == null) {
			if (other.osoby != null)
				return false;
		} else if (!osoby.equals(other.osoby))
			return false;
		if (rola == null) {
			if (other.rola != null)
				return false;
		} else if (!rola.equals(other.rola))
			return false;
		return true;
	}

}