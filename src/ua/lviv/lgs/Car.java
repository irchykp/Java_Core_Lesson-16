package ua.lviv.lgs;

import java.io.Serializable;

public class Car extends Auto implements Serializable{

	public String model;
	private int maxSpeed ;
	private Double price;

	public Car(String model, int maxSpeed, double price) {
		super();
		this.model = model;
		this.maxSpeed = maxSpeed;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxSpeed;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Car other = (Car) obj;
		if (maxSpeed != other.maxSpeed)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", maxSpeed=" + maxSpeed + ", price=" + price + "]";
	}

	
	private void myMethod(String a, int i) {
		for (int temp = 0; temp < i; temp++) {
			System.out.println(a + this.model +temp+ " !");
		}
	}

	private void myMethod(String a) {
		System.out.println(a + this.model + " !");
	}
}
