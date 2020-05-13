package departament.model;

import java.util.Optional;

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
public class Departament {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String departamentname;
    
    private int idmanager;

    private String address;
    
    private String mainphone;
    
    private String mainmail;
    
    private String mainwww;
    
    private String description;
    
    @OneToOne
    @JoinColumn(name="id")
    private AppUser appUser;
    
    public Departament(String departamentname, int idmanager, String address, String mainphone, String mainmail, String mainwww, String description, int iduser)
    {
    	this.departamentname = departamentname;
    	this.idmanager = idmanager;
    	this.address = address;
    	this.mainphone = mainphone;
    	this.mainmail = mainmail; 
    	this.mainwww = mainwww;
    	this.description = description;

    }
}
