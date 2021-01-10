package lt2020.sveikinimai.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "greetings_places")
public class GreetingsPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "greeting_id")
	private Greeting greeting;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "place_id")
	private Place place;

	public GreetingsPlace() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public Place getPlace() {
		return place;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

}
