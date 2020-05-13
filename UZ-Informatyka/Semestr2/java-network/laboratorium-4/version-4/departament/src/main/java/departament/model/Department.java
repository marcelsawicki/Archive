package departament.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDEPARTMENT")
	private Integer id;

	@Column(name = "DEPARTMENTNAME")
	private String name;

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
	
   
    @OneToMany(targetEntity=App_User.class, mappedBy = "department", cascade = CascadeType.REMOVE)
    private Collection<App_User> app_users = new ArrayList<>();
    
	/*@OneToOne(optional = true, cascade = CascadeType.MERGE)
	@JoinColumn(name = "IDMANAGER", referencedColumnName = "IDUSER")
	private App_User manager;
	*/
	
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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name
				+ ", address=" + address + ", mainPhone=" + mainPhone
				+ ", mainMail=" + mainMail + ", mainWWW=" + mainWWW
				+ ", description=" + description + "]";
	}
	

}