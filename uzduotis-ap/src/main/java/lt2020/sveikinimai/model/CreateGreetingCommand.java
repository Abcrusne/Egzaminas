package lt2020.sveikinimai.model;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class CreateGreetingCommand {

	private String title;

	@NotNull
	@Length(min = 3)
	private String text;
	private String image;
	private String type;
	private String firstname;
	private String lastname;

	private LocalDateTime date;

//	public Long getId() {
//		return id;
//	}

	public String getTitle() {
		return title;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public String getType() {
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

//	public void setId(Long id) {
//		this.id = id;
//	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setType(String type) {
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
