package com.ananwulian.xylinkcloudsdk.model;

public enum LivePeopleLayoutType {


	MULTI("multi"), SYM("sym"), MONO("mono"), MANUAL("manual");

	private final String type;

	private LivePeopleLayoutType(String type) {
		this.type = type;
	}
	
	public String getTextStr() {
		return type;
	}
	
	public static LivePeopleLayoutType valueFromString(String type) {

		type = type.toLowerCase();
		if ("multi".equals(type)) {
			return MULTI;
		} else if ("sym".equals(type)) {
			return SYM;
		} else if ("mono".equals(type)) {
			return MONO;
		} else if ("manual".equals(type)) {
			return MANUAL;
		} else {
			throw new IllegalArgumentException("Unsupported type:" + type);
		}

	}

}
