package jsp.swiggy_proj;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class FoodOrder {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String food_item;
	private double cost;
	@CreationTimestamp
	private LocalDateTime orderTime;
	@UpdateTimestamp
	private LocalDateTime orderUpdateTime;
	private LocalDateTime deliveryTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_item() {
		return food_item;
	}
	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDateTime getOrderUpdateTime() {
		return orderUpdateTime;
	}
	public void setOrderUpdateTime(LocalDateTime orderUpdateTime) {
		this.orderUpdateTime = orderUpdateTime;
	}
	public LocalDateTime getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(LocalDateTime deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", food_item=" + food_item + ", cost=" + cost + ", orderTime=" + orderTime
				+ ", orderUpdateTime=" + orderUpdateTime + ", deliveryTime=" + deliveryTime + "]";
	}
	
	
}
