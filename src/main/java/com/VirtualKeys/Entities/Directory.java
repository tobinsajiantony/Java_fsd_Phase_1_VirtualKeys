package com.VirtualKeys.Entities;

import java.util.ArrayList;
import java.util.Optional;

public class Directory {
	private String Name;
	ArrayList<Directory> directories = new ArrayList<Directory>();
	ArrayList<File> files = new ArrayList<File>();
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<Directory> getDirectories() {
		return directories;
	}
	public void setDirectories(ArrayList<Directory> directories) {
		this.directories = directories;
	}
	public ArrayList<File> getFile() {
		return files;
	}
	public void setFile(ArrayList<File> file) {
		this.files = file;
	}

	//Methods

	//Constructor
	public Directory() {}

	//Constructor
	public Directory(String directoryName) {
		setName(directoryName);
	}


	//Method to search for a file in this directory
	public boolean SearchFile(String filename) {
		return this.files.stream()
				.filter(i -> i.getName().equals(filename))
				.findFirst()
				.isPresent();
	}

	//Method to delete a file in this directory
	public String DeleteFile(String filename) {
		File file = this.files.stream().filter(i -> i.getName().equals(filename)).findFirst().orElse(null);
		if(file!=null) {
			if(this.files.remove(file))
				return "File Deleted Succesfully";
			else
				return "File Could Not Be Deleted. Please Try Again";
		}
		else
			return "File Not Found";
	}
	public boolean AddFile(File file) {
		return files.add(file);
	}

	//Method to delete a directory in this directory
	public String DeleteDirectory(String directoryName) {
		Directory directory = this.directories.stream().filter(i -> i.getName().toLowerCase().equals(directoryName.toLowerCase())).findFirst().orElse(null);
		if(directory!=null) {
			if(this.directories.remove(directory))
				return "Directory Deleted Succesfully";
			else
				return "Directory Could Not Be Deleted. Please Try Again";
		}
		else
			return "Directory Not Found";
	}

	//Method to add directory to this directory
	public void AddDirectory(Directory directory) {
		this.directories.add(directory);
	}

	//Method to display the directories and files in this directory
	public void DisplayDirectoriesAndFiles() {
		System.out.println("\nThe directories in this directory are:");
		directories.sort((a,b)-> a.getName().compareToIgnoreCase(b.getName()));
		for(Directory d : directories) {
			System.out.print(" "+d.getName() +" ");
		}
		System.out.println("\nThe files in this directory are:");
		files.sort((a,b)->a.getName().compareToIgnoreCase(b.getName()));
		for(File f : files) {
			System.out.print(" " +f.getName() +" ");
		}
	}
}
