package lt2020.sveikinimai.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true)
	private String title;

	private String address;
	private String image;

	@Enumerated(EnumType.STRING)
	private PlaceType placeType;

	@OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
	@OrderBy(value = "name asc")
	private Set<GreetingsPlace> greetingPlaces;

	public Place() {
		super();
	}

	public Place(String title, String address, String image, PlaceType placeType) {
		super();
		this.title = title;
		this.address = address;
		this.image = image;
		this.placeType = placeType;
	}

	public Long getId() {
		return id;
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

	public PlaceType getPlaceType() {
		return placeType;
	}

	public Set<GreetingsPlace> getGreetingPlaces() {
		return greetingPlaces;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}

	public void setGreetingPlaces(Set<GreetingsPlace> greetingPlaces) {
		this.greetingPlaces = greetingPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((greetingPlaces == null) ? 0 : greetingPlaces.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((placeType == null) ? 0 : placeType.hashCode());
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
		if (greetingPlaces == null) {
			if (other.greetingPlaces != null)
				return false;
		} else if (!greetingPlaces.equals(other.greetingPlaces))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (placeType != other.placeType)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
