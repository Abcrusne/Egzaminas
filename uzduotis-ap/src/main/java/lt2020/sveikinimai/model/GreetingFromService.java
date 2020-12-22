package lt2020.sveikinimai.model;

import java.time.LocalDateTime;

import lt2020.sveikinimai.entities.GreetingType;

public class GreetingFromService {

	private Long id;
	private String text;
	private String image;
	private GreetingType type;
	private String firstname;
	private String lastname;
	private String title;

	private LocalDateTime date;

	public GreetingFromService() {
		super();
	}

	public GreetingFromService(Long id, String text, String image, GreetingType type, String firstname, String lastname,
			String title, LocalDateTime date) {
		super();
		this.id = id;
		this.text = text;
		this.image = image;
		this.type = type;
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
		this.date = date;
	}

	public GreetingFromService(Long id, String text, String image, GreetingType type, String firstname, String lastname,
			String title) {
		super();
		this.id = id;
		this.text = text;
		this.image = image;
		this.type = type;
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public GreetingType getType() {
		return type;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setType(GreetingType type) {
		this.type = type;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}