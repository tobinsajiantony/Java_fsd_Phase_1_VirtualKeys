package com.VirtualKeys.Entities;

public class File {
	
	//Name of the file
	private String Name;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	//Methods
	public File (String fileName) {
		setName(fileName);
	}
}
