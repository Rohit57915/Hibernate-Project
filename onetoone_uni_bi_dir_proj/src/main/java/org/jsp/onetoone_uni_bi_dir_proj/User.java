package org.jsp.onetoone_uni_bi_dir_proj;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class User {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private long phone;

@JoinColumn
@OneToOne(cascade= CascadeType.ALL)
private AadharCard card;
public AadharCard getCard() {
	return card;
}

public void setCard(AadharCard card) {
	this.card = card;
}


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

public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", card=" + card + "]";
}






}
