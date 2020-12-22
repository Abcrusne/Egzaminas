package lt2020.sveikinimai.model;

import java.math.BigDecimal;

public class CreateCartProductCommand {

	private Long id;
	private String title;
	private String image;
	private String description;
	private BigDecimal price;
	private int quantity;
	private int quantityInCart;

	public CreateCartProductCommand() {
	}

	public CreateCartProductCommand(Long id, String title, String image, String description, BigDecimal price,
			int quantity, int quantityInCart) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.quantityInCart = quantityInCart;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantityInCart() {
		return quantityInCart;
	}

	public void setQuantityInCart(int quantityInCart) {
		this.quantityInCart = quantityInCart;
	}

}
