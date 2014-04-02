package wkl.training.ws.age_converter.ws.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;
import org.springframework.stereotype.Service;

import wkl.training.ws.age_converter.beans.ConvertObject;
import wkl.training.ws.age_converter.exceptions.InvalidDateException;
import wkl.training.ws.age_converter.ws.IAgeService;

@Service
@WebService(endpointInterface = "wkl.training.ws.age_converter.ws.IAgeService")
public class AgeService implements IAgeService{
	private final Logger log = LogManager.getLogger(AgeService.class);
	
	/**
	 * @param date - birthday of a man, date in format "yyyy-MM-dd"
	 * 
	 * @return age of the man
	 */
	public ConvertObject getAge(@WebParam(name="date")String date) throws InvalidDateException {
		try{
			log.info("Entered date: " + date);
			
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			DateTime dtDate = new DateTime(format.parseObject(date));
			DateTime dtNow = new DateTime();
			
			if(dtDate.isAfter(dtNow)){
				log.error("Entered date is greater than current date");
				throw new InvalidDateException("Entered date is greater than current date!!!");
			}
			
			Years years = Years.yearsBetween(dtDate, dtNow);
			
			ConvertObject result;
			if(years.getYears() < 1){
				Months months = Months.monthsBetween(dtDate, dtNow);
				result = new ConvertObject("months", months.getMonths());
			}else{
				result = new ConvertObject("years", years.getYears());
			}
			
			
			log.info(format.parseObject(date));
			
			return result;
		}catch(ParseException e){
			log.error("Date parsing error");
			throw new InvalidDateException(e);
		}
		/*if(date.length() > 2){
			throw new InvalidDateException("Error on server side");
		}*/
	}

}
