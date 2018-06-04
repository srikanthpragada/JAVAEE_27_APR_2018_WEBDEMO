package jsf;



import java.time.LocalTime;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {
     // Property message 
	 public String getMessage() {
		 return  LocalTime.now().toString();
	 }
}
