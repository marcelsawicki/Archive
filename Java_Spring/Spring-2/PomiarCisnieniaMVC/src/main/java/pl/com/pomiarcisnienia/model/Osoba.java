package pl.com.pomiarcisnienia.model;

import java.io.Serializable;
import javax.persistence.*;

import pl.com.pomiarcisnienia.model.PomiarCisnienia;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@Table(name="osoba")
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	
	private static final long serialVersionUID = 6041664398345002745L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=250)
	private String haslo;

	@Column(nullable=false, length=25)
	private String imie;

	@Column(nullable=false, length=25)
	private String login;

	@Column(nullable=false, length=45)
	private String nazwisko;

	@Column(nullable=false)
	private int wiek;

	//bi-directional many-to-many association to Rola
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="osoba_rola"
		, joinColumns={
			@JoinColumn(name="osoba_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="rola_id", nullable=false)
			}
		)
	private Set<Rola> role = new HashSet<Rola>();

	//bi-directional many-to-one association to PomiarCisnienia
	@OneToMany(mappedBy="osoba", fetch=FetchType.EAGER)
	private Set<PomiarCisnienia> pomiaryCisnienia = new HashSet<PomiarCisnienia>();
	public Osoba() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getWiek() {
		return this.wiek;
	}

	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public Set<Rola> getRole() {
		return this.role;
	}

	public void setRole(Set<Rola> role) {
		this.role = role;
	}

	public Set<PomiarCisnienia> getPomiaryCisnienia() {
		return this.pomiaryCisnienia;
	}

	public void setPomiaryCisnienia(Set<PomiarCisnienia> pomiaryCisnienia) {
		this.pomiaryCisnienia = pomiaryCisnienia;
	}

	public PomiarCisnienia addPomiarCisnienia(PomiarCisnienia pomiarCisnienia) {
		getPomiaryCisnienia().add(pomiarCisnienia);
		pomiarCisnienia.setOsoba(this);

		return pomiarCisnienia;
	}

	public PomiarCisnienia removePomiarCisnienia(PomiarCisnienia pomiarCisnienia) {
		getPomiaryCisnienia().remove(pomiarCisnienia);
		pomiarCisnienia.setOsoba(null);

		return pomiarCisnienia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((haslo == null) ? 0 : haslo.hashCode());
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + wiek;
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
		Osoba other = (Osoba) obj;
		if (haslo == null) {
			if (other.haslo != null)
				return false;
		} else if (!haslo.equals(other.haslo))
			return false;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (wiek != other.wiek)
			return false;
		return true;
	}

}