package lt2020.sveikinimai.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//@MappedSuperclass

//@Table(name = "products")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Product_Type")
@Entity
public class Greeting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String image;
	private String text;
	private GreetingType type;
	private String firstname;
	private String lastname;

	private String audio;

	@OneToOne(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "GreetingDetails_id")
	private GreetingDetails greetingDetails;

	// rysi User user vietoj firstname ir lastname reiktu

	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
	private Set<Place> place;

	public Greeting() {
		super();
	}

	public Greeting(String title, String image, String text, GreetingType type, String firstname, String lastname,
			GreetingDetails greetingDetails) {
		super();

		this.title = title;
		this.image = image;
		this.text = text;
		this.type = type;
		this.firstname = firstname;
		this.lastname = lastname;
		this.greetingDetails = greetingDetails;
	}

	public Greeting(String title, String image, String text, GreetingType type, String firstname, String lastname) {

		super();

		this.title = title;
		this.image = image;
		this.text = text;
		this.type = type;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public GreetingType getType() {
		return type;
	}

	public String getAudio() {
		return audio;
	}

	public Set<Place> getPlace() {
		return place;
	}

	public void setType(GreetingType type) {
		this.type = type;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public void setPlace(Set<Place> place) {
		this.place = place;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public GreetingDetails getGreetingDetails() {
		return greetingDetails;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setGreetingDetails(GreetingDetails greetingDetails) {
		this.greetingDetails = greetingDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((greetingDetails == null) ? 0 : greetingDetails.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Greeting other = (Greeting) obj;
		if (greetingDetails == null) {
			if (other.greetingDetails != null)
				return false;
		} else if (!greetingDetails.equals(other.greetingDetails))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", text=" + text + ", greetingDetails=" + greetingDetails + "]";
	}

}
