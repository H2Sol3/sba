package mvc;

import java.util.HashMap;

public class HandlerMapping {
	HashMap<String, Controller> mappings;
	HandlerMapping(){
		mappings = new HashMap();
		mappings.put("hello", new HelloController());
	//	mappings.put("list", new ListController());
	}
	
	Controller getController(String url) {
		System.out.println("HandlerMapping 실행중");
		return mappings.get(url);
	}
}
