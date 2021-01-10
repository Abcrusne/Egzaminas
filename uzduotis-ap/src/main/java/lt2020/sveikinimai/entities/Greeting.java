package lt2020.sveikinimai.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@MappedSuperclass

//@Table(name = "products")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "Product_Type")
@Entity
public class Greeting {

	// private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String text;
	private String image;
	private String audio;

	@Enumerated(EnumType.STRING)
	private GreetingType type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

//	@OneToOne(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
//	@JoinColumn(name = "GreetingDetails_id")
//	private GreetingDetails greetingDetails;

	@OneToMany(mappedBy = "greeting", cascade = CascadeType.ALL)
	private Set<GreetingsPlace> greetingPlaces;

	public Greeting() {
		super();
	}

	public Greeting(String name, String text, String image, String audio, GreetingType type, Date date) {
		super();
		this.name = name;
		this.text = text;
		this.image = image;
		this.audio = audio;
		this.type = type;
		this.date = date;
	}

	public Greeting(String name, String text, String image, String audio, GreetingType type, Date date,
			Set<GreetingsPlace> greetingPlaces) {
		super();
		this.name = name;
		this.text = text;
		this.image = image;
		this.audio = audio;
		this.type = type;
		this.date = date;
		this.greetingPlaces = greetingPlaces;
	}

	public Greeting(Long id, String name, String text, String image, String audio, GreetingType type, Date date,
			Set<GreetingsPlace> greetingPlaces) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.image = image;
		this.audio = audio;
		this.type = type;
		this.date = date;
		this.greetingPlaces = greetingPlaces;
	}

	public Long getId() {
		return id;
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

	public Set<GreetingsPlace> getGreetingPlaces() {
		return greetingPlaces;
	}

	public void setGreetingPlaces(Set<GreetingsPlace> greetingPlaces) {
		this.greetingPlaces = greetingPlaces;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((audio == null) ? 0 : audio.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((greetingPlaces == null) ? 0 : greetingPlaces.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (audio == null) {
			if (other.audio != null)
				return false;
		} else if (!audio.equals(other.audio))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", name=" + name + ", text=" + text + ", image=" + image + ", audio=" + audio
				+ ", type=" + type + ", date=" + date + ", greetingPlaces=" + greetingPlaces + "]";
	}

//	@PostConstruct
//	private void init() {
//		log.info("Verifying Resources");
//	}
//
//	@PreDestroy
//	private void shutdown() {
//		log.info("Shutdown All Resources");
//	}
//
//	public void close() {
//		log.info("Closing All Resources");
//	}

}