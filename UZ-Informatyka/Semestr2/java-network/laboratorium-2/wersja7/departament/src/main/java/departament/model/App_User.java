package departament.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class App_User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDUSER")
	private Integer id;

	@ManyToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDDEPARTMENT", referencedColumnName = "IDDEPARTMENT")
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

	@Column(name = "DAY_OF_PAYMANT")
	private Date dayOfPaymant;

	public App_User() {
		super();
	}

	public App_User(String username, String password, String firstName,
			String lastName, String description, Long pay, Long bonus,
			Date dayOfPaymant) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.pay = pay;
		this.bonus = bonus;
		this.dayOfPaymant = dayOfPaymant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (this.id == null) {
			this.id = id;
		}
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPay() {
		return pay;
	}

	public void setPay(Long pay) {
		this.pay = pay;
	}

	public Long getBonus() {
		return bonus;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}

	public Date getDayOfPaymant() {
		return dayOfPaymant;
	}

	public void setDayOfPaymant(Date dayOfPaymant) {
		this.dayOfPaymant = dayOfPaymant;
	}

	@Override
	public String toString() {
		return "App_User [id=" + id + ", department id=" + department.getId()
				+ ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", description=" + description + ", pay=" + pay + ", bonus="
				+ bonus + ", dayOfPaymant:" + dayOfPaymant.getDay() + "-"
				+ dayOfPaymant.getMonth() + "-"+ dayOfPaymant.getYear() + "]";
	}

}
