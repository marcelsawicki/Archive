package departament.model;

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
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEPARTMENT")
	private Integer id;

	@Column(name = "DEPARTMENTNAME")
	private String name;

	@OneToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDMANAGER", referencedColumnName = "IDUSER")
	private App_User manager;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "MAINPHONE")
	private String mainPhone;

	@Column(name = "MAINMAIL")
	private String mainMail;

	@Column(name = "MAINWWW")
	private String mainWWW;

	@Column(name = "DESCRIPTION")
	private String description;
	
	public Department() {
		super();
	}

	public Department(String name, String address,
			String mainPhone, String mainMail, String mainWWW,
			String description) {
		super();
		this.name = name;
		this.address = address;
		this.mainPhone = mainPhone;
		this.mainMail = mainMail;
		this.mainWWW = mainWWW;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (this.id == null) {
			this.id = id;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public App_User getManager() {
		return manager;
	}

	public void setManager(App_User manager) {
		this.manager = manager;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMainPhone() {
		return mainPhone;
	}

	public void setMainPhone(String mainPhone) {
		this.mainPhone = mainPhone;
	}

	public String getMainMail() {
		return mainMail;
	}

	public void setMainMail(String mainMail) {
		this.mainMail = mainMail;
	}

	public String getMainWWW() {
		return mainWWW;
	}

	public void setMainWWW(String mainWWW) {
		this.mainWWW = mainWWW;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager id="
				+ manager.getId() + ", address=" + address + ", mainPhone=" + mainPhone
				+ ", mainMail=" + mainMail + ", mainWWW=" + mainWWW
				+ ", description=" + description + "]";
	}
	

}