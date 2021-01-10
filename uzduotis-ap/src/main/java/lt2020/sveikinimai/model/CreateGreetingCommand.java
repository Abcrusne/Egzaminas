package lt2020.sveikinimai.model;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lt2020.sveikinimai.entities.GreetingType;

public class CreateGreetingCommand {

	private String name;
	private String text;
	private String image;
	private String audio;

	@Enumerated(EnumType.STRING)
	private GreetingType type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public CreateGreetingCommand() {
		super();
	}

	public CreateGreetingCommand(String name, String text, String image, String audio, GreetingType type, Date date) {
		super();
		this.name = name;
		this.text = text;
		this.image = image;
		this.audio = audio;
		this.type = type;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public String getText() {
		return text;
	}

	public String getImage() {
		return image;
	}

	public String getAudio() {
		return audio;
	}

	public GreetingType getType() {
		return type;
	}

	public Date getDate() {
		return date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public void setType(GreetingType type) {
		this.type = type;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
