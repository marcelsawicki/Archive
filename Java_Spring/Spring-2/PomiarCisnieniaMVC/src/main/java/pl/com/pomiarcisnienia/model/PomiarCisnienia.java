package pl.com.pomiarcisnienia.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the pomiar_cisnienia database table.
 * 
 */
@Entity
@Table(name="pomiar_cisnienia")
@NamedQuery(name="PomiarCisnienia.findAll", query="SELECT p FROM PomiarCisnienia p")
public class PomiarCisnienia implements Serializable {
	
	private static final long serialVersionUID = 3439700833754178454L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="data_pomiaru", nullable=false)
	private Timestamp dataPomiaru;

	@Column(nullable=false)
	private int puls;

	@Column(nullable=false)
	private int rozkurczowe;

	@Column(nullable=false)
	private int skurczowe;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	@JoinColumn(name="osoba_id", nullable=false)
	private Osoba osoba;

	public PomiarCisnienia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataPomiaru() {
		return this.dataPomiaru;
	}

	public void setDataPomiaru(Timestamp dataPomiaru) {
		this.dataPomiaru = dataPomiaru;
	}

	public int getPuls() {
		return this.puls;
	}

	public void setPuls(int puls) {
		this.puls = puls;
	}

	public int getRozkurczowe() {
		return this.rozkurczowe;
	}

	public void setRozkurczowe(int rozkurczowe) {
		this.rozkurczowe = rozkurczowe;
	}

	public int getSkurczowe() {
		return this.skurczowe;
	}

	public void setSkurczowe(int skurczowe) {
		this.skurczowe = skurczowe;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPomiaru == null) ? 0 : dataPomiaru.hashCode());
		result = prime * result + id;
		result = prime * result + ((osoba == null) ? 0 : osoba.hashCode());
		result = prime * result + puls;
		result = prime * result + rozkurczowe;
		result = prime * result + skurczowe;
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
		PomiarCisnienia other = (PomiarCisnienia) obj;
		if (dataPomiaru == null) {
			if (other.dataPomiaru != null)
				return false;
		} else if (!dataPomiaru.equals(other.dataPomiaru))
			return false;
		if (id != other.id)
			return false;
		if (osoba == null) {
			if (other.osoba != null)
				return false;
		} else if (!osoba.equals(other.osoba))
			return false;
		if (puls != other.puls)
			return false;
		if (rozkurczowe != other.rozkurczowe)
			return false;
		if (skurczowe != other.skurczowe)
			return false;
		return true;
	}

}