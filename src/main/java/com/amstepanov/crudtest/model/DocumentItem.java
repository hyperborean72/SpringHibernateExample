package com.amstepanov.crudtest.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name="DOCUMENT_ITEM")
public class DocumentItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=100)
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotNull
	@Digits(integer=8, fraction=2)
	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;

	@ManyToOne(optional = false)
	@JoinColumn(name = "DOC_ID")
	private Document document;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + name.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof DocumentItem))
			return false;
		DocumentItem other = (DocumentItem) obj;
		return (id != other.id || !name.equals(other.name) || !(price.compareTo(other.price) == 0));
	}

	@Override
	public String toString() {
		return "DocumentItem -> id=" + id + ", name=" + name + ", price=" + price
				+ ", document.id =" + document.getId() + ", document.name =" + document.getName();
	}
}