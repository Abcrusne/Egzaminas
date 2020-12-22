package lt2020.sveikinimai.entities;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Place {

	private Long id;
	@Id
	private String title;
	private String address;
	private String image;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "greeting_id")
	private Greeting greeting;

	public Place() {
		super();
	}

	public Place(Long id, String title, String address, String image) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.image = image;
	}

	public Place(Long id, String title, String address, String image, Greeting greeting) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.image = image;
		this.greeting = greeting;
	}

	public String getTitle() {
		return title;
	}

	public String getAddress() {
		return address;
	}

	public String getImage() {
		return image;
	}

	public Greeting getGreeting() {
		return greeting;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((greeting == null) ? 0 : greeting.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Place other = (Place) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (greeting == null) {
			if (other.greeting != null)
				return false;
		} else if (!greeting.equals(other.greeting))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
