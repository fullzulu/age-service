package wkl.training.ws.age_converter.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ConvertObject")
public class ConvertObject {
	private String unit;
	private int age;
	
	public ConvertObject() {
	}

	public ConvertObject(String unit, int age) {
		this.unit = unit;
		this.age = age;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ConvertObject [unit=" + unit + ", age=" + age + "]";
	}
	
	

}
