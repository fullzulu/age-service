package wkl.training.ws.age_converter_client_maven;

import wkl.training.ws.age_converter.ws.ConvertObject;
import wkl.training.ws.age_converter.ws.IAgeService;
import wkl.training.ws.age_converter.ws.InvalidDateException_Exception;
import wkl.training.ws.age_converter.ws.impl.AgeServiceService;

public class Client {

	public static void main(String[] args) {
		AgeServiceService service = new AgeServiceService();
		IAgeService soap = service.getAgeServicePort();
		try {
			ConvertObject co = soap.getAge("1990-11-29");
			System.out.println("Unit: " + co.getUnit());
			System.out.println("Age: " + co.getAge());
		} catch (InvalidDateException_Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
