package pl.com.pomiarcisnienia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-08T14:01:30.645+0000")
@StaticMetamodel(Rola.class)
public class Rola_ {
	public static volatile SingularAttribute<Rola, Integer> id;
	public static volatile SingularAttribute<Rola, String> rola;
	public static volatile SetAttribute<Rola, Osoba> osoby;
}
