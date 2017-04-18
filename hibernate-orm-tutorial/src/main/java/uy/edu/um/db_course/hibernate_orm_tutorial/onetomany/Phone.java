package uy.edu.um.db_course.hibernate_orm_tutorial.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity(name = "Phone")
public class Phone {
	   @Id
	    @GeneratedValue
	    private Long id;

	    @Column(name = "phone_number")
	    private String number;

	    @ManyToOne
	    @JoinColumn(name = "person_id",
	            foreignKey = @ForeignKey(name = "PERSON_ID_FK")
	    )
	    private Person person;

	    public Phone(String number) {
	        this.number = number;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getNumber() {
	        return number;
	    }

	    public Person getPerson() {
	        return person;
	    }

	    public void setPerson(Person person) {
	        this.person = person;
	    }
}
