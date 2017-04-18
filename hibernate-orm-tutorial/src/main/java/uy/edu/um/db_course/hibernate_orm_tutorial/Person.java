package uy.edu.um.db_course.hibernate_orm_tutorial;

import java.util.Date;

public class Person {
	private String key;
	private Date birthday;
	private Name name;

	public Person() {
		super();
	}

	public Person(Date birthday, Name name) {
		super();
		this.birthday = birthday;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}
