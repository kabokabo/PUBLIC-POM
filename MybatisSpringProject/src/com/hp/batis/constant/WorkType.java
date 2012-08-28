package com.hp.batis.constant;

public enum WorkType {

	REGULOR("regulor"), INTERN("intern"), CONTINGENT("contigent");
	private String type;

	private WorkType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	public String toString(){
		return getType();
	}
}
