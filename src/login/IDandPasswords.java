package login;
import java.util.HashMap;

import connData.ConnJDBC;

public class IDandPasswords {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	public IDandPasswords(){
		
	}
	
	public HashMap<String, String> getLoginInfo(){
		return ConnJDBC.findAllAccount();
	}
}