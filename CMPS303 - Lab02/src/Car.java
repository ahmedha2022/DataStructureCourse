
public class Car {
	private int plateNo;
	private String brand;
	public Car(int plateNo, String brand) {
		super();
		this.plateNo = plateNo;
		this.brand = brand;
	}
	public int getPlateNo() {
		return plateNo;
	}
	public void setPlateNo(int plateNo) {
		this.plateNo = plateNo;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Car [plateNo=" + plateNo + ", brand=" + brand + "]";
	}
}