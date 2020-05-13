package hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class WniosekUrlopowy {

	public WniosekUrlopowy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WniosekUrlopowy(Integer id, String name, Pracownik pracownik, Status status, Date odkiedy, Date dokiedy) {
		super();
		this.id = id;
		this.name = name;
		this.pracownik = pracownik;
		this.status = status;
		this.odkiedy = odkiedy;
		this.dokiedy = dokiedy;
	}

	// public WniosekUrlopowy(String name, Integer status, Date odkiedy, Date dokiedy) {
	public WniosekUrlopowy(String name, Pracownik pracownik, Status status, Date odkiedy, Date dokiedy) {
		super();
		this.name = name;
		this.pracownik = pracownik;
		this.status = status;
		this.odkiedy = odkiedy;
		this.dokiedy = dokiedy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDWNIOSEKURLOPOWY")
	private Integer id;

	@Column(name = "WNIOSEKURLOPOWYNAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "IDPRACOWNIK", referencedColumnName = "IDPRACOWNIK")
	private Pracownik pracownik;
	
	@Column(name = "WNIOSEKURLOPOWYSTATUS")
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	
	@Column(name = "WNIOSEKURLOPOWYODKIEDY")
	private Date odkiedy;
	
	@Column(name = "WNIOSEKURLOPOWYDOKIEDY")
	private Date dokiedy;

	@Override
	public String toString() {
		return "WniosekUrlopowy [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
}
