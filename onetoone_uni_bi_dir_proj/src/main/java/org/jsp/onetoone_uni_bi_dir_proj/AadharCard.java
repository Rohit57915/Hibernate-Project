package org.jsp.onetoone_uni_bi_dir_proj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AadharCard {
    
    @Id
   /* @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int aId;*/
    private long aadharNo;
    private String address;

    @OneToOne(mappedBy = "card")
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    // Getters and setter
	
	/*public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}*/
	
	public long getAadharNo() {
	return aadharNo;
	}

     public void setAadharNo(long aadharNo) {
     this.aadharNo = aadharNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*@Override
	public String toString() {
		return "AadharCard [aId=" + aId + ", aadharNo=" + aadharNo + ", address=" + address + ", user=" + user + "]";
	}*/

	
}
