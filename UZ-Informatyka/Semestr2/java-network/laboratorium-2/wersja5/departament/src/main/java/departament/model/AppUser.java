package departament.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppUser 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int iddepartament;

    private String username;
    
    private String password;
    
    private String firstname;
    
    private String lastname;
    
    private String description;
    
    private float payment;
    private float bonus;
    private Date dateofpayment;
    
    @OneToOne
    @JoinColumn(name="id")
    private Departament departament;
    
    public AppUser(int iddepartment, String username, String password, String firstname, String lastname, String description, float payment, float bonus)
    {
    	this.iddepartament = iddepartment;
    	this.username = username;
    	this.password = password;
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.description = description;
    	this.payment = payment;
    	this.bonus = bonus;
    	this.dateofpayment = new Date();
    }
    
}
