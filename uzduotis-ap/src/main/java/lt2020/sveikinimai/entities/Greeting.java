package lt2020.sveikinimai.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private String type;
	private String firstname;
	private String lastname;

	@OneToOne(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
	@JoinColumn(name = "GreetingDetails_id")
	private GreetingDetails greetingDetails;

	// rysi User user

	public Greeting() {
		super();
	}

	public Greeting(String title, String image, String text, String type, String firstname, String lastname,
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

	public Greeting(String title, String image, String text, String type, String firstname, String lastname) {

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

	public String getType() {
		return type;
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

	public void setType(String type) {
		this.type = type;
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

//	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH })
//	@JoinTable(name = "Product_Cart", joinColumns = @JoinColumn(name = "Product_ID"), inverseJoinColumns = @JoinColumn(name = "Cart_Owner"))
//	private Set<CartProduct> carts;

//	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
//	private Set<CartItem> cartItems;

	// @MapKey(name = "cartProductsByUsername")
	// private final Map<String, List<CartProduct>> userProducts = new HashMap<>();

//	public Product() {
//		super();
//	}
//
//	public Product(String title, BigDecimal price, int quantity) {
//		super();
//		this.title = title;
//		this.price = price;
//		this.quantity = quantity;
//		this.cartItems = new HashSet<>();
//	}
//
//	public Product(String title, BigDecimal price, int quantity, ProductDetails productDetails) {
//		super();
//		this.title = title;
//		this.price = price;
//		this.quantity = quantity;
//		this.productDetails = productDetails;
//		this.cartItems = new HashSet<>();
//	}
//
//	public ProductDetails getProductDetails() {
//		return productDetails;
//	}

}
