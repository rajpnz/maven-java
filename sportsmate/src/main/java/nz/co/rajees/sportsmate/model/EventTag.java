package nz.co.rajees.sportsmate.model;

public class EventTag {

	private String name; 
	private String code;
	
	public EventTag(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
	
}
