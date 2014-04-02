package wkl.training.ws.age_converter.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import wkl.training.ws.age_converter.beans.ConvertObject;
import wkl.training.ws.age_converter.exceptions.InvalidDateException;

@WebService
public interface IAgeService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{date}")
	@WebMethod
	public ConvertObject getAge(@PathParam("date")@WebParam(name="date") String name) throws InvalidDateException;
}
