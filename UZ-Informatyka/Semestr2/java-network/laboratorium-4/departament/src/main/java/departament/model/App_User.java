package departament.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "APP_USER")
public class App_User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSER")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "IDDEPARTMENT", referencedColumnName = "IDDEPARTMENT")
	@JsonIgnore
	private Department department;
	
	
	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PAY")
	private Long pay;
	@Column(name = "BONUS")
	private Long bonus;

	@Column(name = "DAY_OF_PAYMENT")
	private Date dayOfPayment;

	public App_User() {
		super();
	}

	public App_User(String username, String password, String firstName,
			String lastName, String description, Long pay, Long bonus,
			Date dayOfPayment) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.pay = pay;
		this.bonus = bonus;
		this.dayOfPayment = dayOfPayment;
	}

	@Override
	public String toString() {
		return "App_User [id=" + id + ", department id=" 
				+ ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", description=" + description + ", pay=" + pay + ", bonus="
				+ bonus + ", dayOfPayment:" + dayOfPayment.getDay() + "-"
				+ dayOfPayment.getMonth() + "-"+ dayOfPayment.getYear() + "]";
	}

}
