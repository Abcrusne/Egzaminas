package lt2020.sveikinimai.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class GreetingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private Long id;
	private LocalDateTime date;

	@OneToOne(mappedBy = "greetingDetails")
	private Greeting greeting;

	public GreetingDetails() {
		super();
	}

	public GreetingDetails(LocalDateTime date) {
		super();

		this.date = date;

	}

	public LocalDateTime getDate() {
		return date;
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((greeting == null) ? 0 : greeting.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GreetingDetails other = (GreetingDetails) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (greeting == null) {
			if (other.greeting != null)
				return false;
		} else if (!greeting.equals(other.greeting))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
