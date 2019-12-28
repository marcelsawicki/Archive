package pl.com.pomiarcisnienia.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-06-08T14:01:30.355+0000")
@StaticMetamodel(Osoba.class)
public class Osoba_ {
	public static volatile SingularAttribute<Osoba, Integer> id;
	public static volatile SingularAttribute<Osoba, String> haslo;
	public static volatile SingularAttribute<Osoba, String> imie;
	public static volatile SingularAttribute<Osoba, String> login;
	public static volatile SingularAttribute<Osoba, String> nazwisko;
	public static volatile SingularAttribute<Osoba, Integer> wiek;
	public static volatile SetAttribute<Osoba, Rola> role;
	public static volatile SetAttribute<Osoba, PomiarCisnienia> pomiaryCisnienia;
}
