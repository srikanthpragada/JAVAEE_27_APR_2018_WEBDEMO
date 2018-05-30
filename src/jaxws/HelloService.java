package jaxws;

import java.time.LocalDate;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService 
public class HelloService {
	
	@WebMethod
	public String hello() {
		return "Hello Web Service. Today is :" + LocalDate.now();
	}

}
