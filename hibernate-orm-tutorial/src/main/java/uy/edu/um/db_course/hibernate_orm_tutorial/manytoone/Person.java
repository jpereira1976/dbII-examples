package uy.edu.um.db_course.hibernate_orm_tutorial.manytoone;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name = "Person")
public class Person {
	@Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone> phones;

    public Person() {
    	phones = new ArrayList<>();
    }
    
    public Person(Long id) {
    	this();
    	this.id = id;
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
