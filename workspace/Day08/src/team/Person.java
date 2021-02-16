package team;

import java.util.HashSet;
import java.util.Set;

public class Person {
	private int id;
	private String name;
	private int balance;
	private Set<Bus> buses;
	
	public Person(int id,String name,int balance) {
		this.id=id;
		this.name=name;
		this.balance=balance;
		buses = new HashSet<Bus>();
	}
	
	public boolean addbus(Bus bus) {
		buses.add(bus);
		
	}
	
}
