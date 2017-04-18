package uy.edu.um.db_course.hibernate_orm_tutorial;

public class Name {
	char initial;
	String first;
	String last;

	public Name() {
		super();
	}

	public Name(char initial, String first, String last) {
		super();
		this.initial = initial;
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	void setLast(String last) {
		this.last = last;
	}

	public char getInitial() {
		return initial;
	}

	void setInitial(char initial) {
		this.initial = initial;
	}
}
