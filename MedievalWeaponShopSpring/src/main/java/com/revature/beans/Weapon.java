package com.revature.beans;

public class Weapon {
	private int weaponId;
	private int numberBlades;
	private double weight;
	private String weaponType;
	private int userId;

	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weapon(int weaponId, int numberBlades, double weight, String weaponType, int userId) {
		super();
		this.weaponId = weaponId;
		this.numberBlades = numberBlades;
		this.weight = weight;
		this.weaponType = weaponType;
		this.userId = userId;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public int getNumberBlades() {
		return numberBlades;
	}

	public void setNumberBlades(int numberBlades) {
		this.numberBlades = numberBlades;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberBlades;
		result = prime * result + userId;
		result = prime * result + weaponId;
		result = prime * result + ((weaponType == null) ? 0 : weaponType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
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
		Weapon other = (Weapon) obj;
		if (numberBlades != other.numberBlades)
			return false;
		if (userId != other.userId)
			return false;
		if (weaponId != other.weaponId)
			return false;
		if (weaponType == null) {
			if (other.weaponType != null)
				return false;
		} else if (!weaponType.equals(other.weaponType))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weapon [weaponId=" + weaponId + ", numberBlades=" + numberBlades + ", weight=" + weight
				+ ", weaponType=" + weaponType + ", userId=" + userId + "]";
	}

}
