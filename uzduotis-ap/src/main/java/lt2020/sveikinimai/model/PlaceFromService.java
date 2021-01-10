package lt2020.sveikinimai.model;

import lt2020.sveikinimai.entities.Greeting;
import lt2020.sveikinimai.entities.PlaceType;

public class PlaceFromService {

	private Long id;

	private String title;
	private String address;
	private String image;
	private PlaceType placeType;
	private Greeting greeting;

	public PlaceFromService() {
		super();
	}

	public PlaceFromService(String title, String address, String image, PlaceType placeType) {
		super();
		this.title = title;
		this.address = address;
		this.image = image;
		this.placeType = placeType;
	}

	public PlaceFromService(String title, String address, String image, PlaceType placeType, Greeting greeting) {
		super();
		this.title = title;
		this.address = address;
		this.image = image;
		this.placeType = placeType;
		this.greeting = greeting;
	}

	public PlaceFromService(Long id, String title, String address, String image, PlaceType placeType,
			Greeting greeting) {
		super();
		this.id = id;
		this.title = title;
		this.address = address;
		this.image = image;
		this.placeType = placeType;
		this.greeting = greeting;
	}

	public PlaceFromService(Long id, String title, String address, String image, PlaceType placeType) {
		super();
		this.id = id;
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

	public Greeting getGreeting() {
		return greeting;
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

	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}

}
