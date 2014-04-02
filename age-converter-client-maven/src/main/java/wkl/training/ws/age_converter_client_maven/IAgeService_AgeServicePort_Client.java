package wkl.training.ws.age_converter_client_maven;

import java.io.File;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.xml.namespace.QName;

import wkl.training.ws.age_converter.ws.ConvertObject;
import wkl.training.ws.age_converter.ws.IAgeService;
import wkl.training.ws.age_converter.ws.InvalidDateException_Exception;
import wkl.training.ws.age_converter.ws.impl.AgeServiceService;

public final class IAgeService_AgeServicePort_Client
{
  private static final QName SERVICE_NAME = new QName("http://impl.ws.age_converter.ws.training.wkl/", "AgeServiceService");
  
  public static void main(String[] args)
    throws Exception
  {
    URL wsdlURL = AgeServiceService.WSDL_LOCATION;
    if (args.length > 0)
    {
      File wsdlFile = new File(args[0]);
      try
      {
        if (wsdlFile.exists()) {
          wsdlURL = wsdlFile.toURI().toURL();
        } else {
          wsdlURL = new URL(args[0]);
        }
      }
      catch (MalformedURLException e)
      {
        e.printStackTrace();
      }
    }
    AgeServiceService ss = new AgeServiceService(wsdlURL, SERVICE_NAME);
    IAgeService port = ss.getAgeServicePort();
    

    System.out.println("Invoking getAge...");
    String _getAge_name = "";
    try
    {
      ConvertObject _getAge__return = port.getAge(_getAge_name);
      System.out.println("getAge.result=" + _getAge__return);
    }
    catch (InvalidDateException_Exception e)
    {
      System.out.println("Expected exception: InvalidDateException has occurred.");
      System.out.println(e.toString());
    }
    System.exit(0);
  }
}
