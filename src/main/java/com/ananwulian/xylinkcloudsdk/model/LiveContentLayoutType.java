package com.ananwulian.xylinkcloudsdk.model;

public enum LiveContentLayoutType {


	MONO("mono"), PRIMARY("primary"), SLAVE("slave"), SMART("smart");

	private final String type;

	private LiveContentLayoutType(String type) {
		this.type = type;
	}
	
	public String getTextStr() {
		return type;
	}
	
	public static LiveContentLayoutType valueFromString(String type) {

		type = type.toLowerCase();
		if ("mono".equals(type)) {
			return MONO;
		} else if ("primary".equals(type)) {
			return PRIMARY;
		} else if ("slave".equals(type)) {
			return SLAVE;
		} else if ("smart".equals(type)) {
			return SMART;
		} else {
			throw new IllegalArgumentException("Unsupported type:" + type);
		}
	}

}
