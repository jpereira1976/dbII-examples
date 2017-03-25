package uy.edu.um.db_course.hibernate_orm_tutorial;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "EVENTS" )
public class Event {
	private Long id;
	private String text;
	private Date date;
	private boolean enabled;

	public Event() {
		super();
	}

	public Event(String text) {
		super();
		this.text = text;
	}

	@Id
	@GeneratedValue(generator="native")
	@Column(name="EVENT_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="EVENT_TEXT")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name="EVENT_DATE")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
