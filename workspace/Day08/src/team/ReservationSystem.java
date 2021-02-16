package team;

public class ReservationSystem {
	private MyQueue queue = new MyQueue();
	private MyDList people = new MyDList();
	
	public void insertBus(int busId) {
		
	}
	
	public void addPerson(int id) {
		people.push_back(new Person(id));
	}
	
	
}
