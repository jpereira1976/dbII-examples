package uy.edu.um.db_course.hibernate_orm_tutorial.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Phone")
public class Phone {
	    @Id
	    @GeneratedValue
	    private Long id;

	    @Column(name = "phone_number")
	    private String number;

	    public Phone() {
	    }

	    public Phone(String number) {
	        this.number = number;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNumber() {
	        return number;
	    }
}
