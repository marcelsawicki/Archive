package pl.com.pomiarcisnienia.model;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-08T14:01:30.535+0000")
@StaticMetamodel(PomiarCisnienia.class)
public class PomiarCisnienia_ {
	public static volatile SingularAttribute<PomiarCisnienia, Integer> id;
	public static volatile SingularAttribute<PomiarCisnienia, Timestamp> dataPomiaru;
	public static volatile SingularAttribute<PomiarCisnienia, Integer> puls;
	public static volatile SingularAttribute<PomiarCisnienia, Integer> rozkurczowe;
	public static volatile SingularAttribute<PomiarCisnienia, Integer> skurczowe;
	public static volatile SingularAttribute<PomiarCisnienia, Osoba> osoba;
}
