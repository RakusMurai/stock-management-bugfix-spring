package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 書籍関連のリクエストパラメータが入るフォーム.
 * 
 * @author igamasayuki
 *
 */
public class BookForm {
	/** id */
	private Integer id;
	/** 書籍名 */
	@NotBlank(message = "入力してください")
	private String name;
	/** 著者 */
	@NotBlank(message = "入力してください")
	private String author;
	/** 出版社 */
	@NotBlank(message = "入力してください")
	private String publisher;
	/** 価格 */
	@NotBlank(message = "入力してください")
	private String price;
	/** ISBNコード */
	@NotBlank(message = "入力してください")
	private String isbncode;
	/** 発売日 */
	@NotBlank(message = "入力してください")
	private String saledate;
	/** 説明 */
	@NotBlank(message = "入力してください")
	private String explanation;
	/** 画像 */
	@NotBlank(message = "入力してください")
	private String image;
	/** 在庫 */
	@NotNull(message = "入力してください")
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIsbncode() {
		return isbncode;
	}

	public void setIsbncode(String isbncode) {
		this.isbncode = isbncode;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
