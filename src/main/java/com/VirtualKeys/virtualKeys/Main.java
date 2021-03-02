package com.VirtualKeys.virtualKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.management.OperationsException;

import com.VirtualKeys.Entities.*;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println("************* Welcome to Virtual Keys****************");
			System.out.println("************* Developed By Tobin ********************");
			File file1 = new File("file1");
			File file2 = new File("file2");
			Directory rootDirectory = new Directory("Root Directory");
			rootDirectory.AddFile(file1);
			rootDirectory.AddFile(file2);
			rootDirectory.AddDirectory(new Directory("Directory1"));
			rootDirectory.AddDirectory(new Directory("Directory2"));
			rootDirectory.DisplayDirectoriesAndFiles();
			Operations(rootDirectory);
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	static void Operations(Directory rootDirectory) {
		ArrayList<String> options = new ArrayList<String>(Arrays.asList("\nPlease Select Option"
				,"1.View Files in Ascending Order"
				,"2.Business Operations"
				,"3.Close The Application"));
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			for(String s : options) {
				System.out.println(s);
			}
			System.out.println("Select the option");
			option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				rootDirectory.DisplayDirectoriesAndFiles();
				break;
			case 2:
				BusinessOperations(rootDirectory);
				break;
			case 3:
				System.out.println("Thank you for using the application.....");
				break;

			default:
				System.out.println("Invalid Option. Try Again!");
				break;
			}
		}while(option !=3);
	}

	static void BusinessOperations(Directory rootDirectory) {
		ArrayList<String> businessOptions = new ArrayList<String>(Arrays.asList("\nPlease Select Option"
				,"1.Add File to the Directory"
				,"2.Delete File from the Directory"
				,"3.Search a File in the Directory"
				,"4.Return to Main Menu"));
		Scanner sc = new Scanner(System.in);
		int businessOption = 0;
		do {
			for(String s : businessOptions) {
				System.out.println(s);
			}
			businessOption = sc.nextInt();
			sc.nextLine();
			switch (businessOption) {
			case 1:
				System.out.println("Enter File Name");
				if(rootDirectory.AddFile(new File(sc.nextLine())))
					System.out.println("File Added Successfully");
				else
					System.out.println("File Could Not Be Added. Please Try Again!");
				break;

			case 2:
				System.out.println("Enter File Name");
				System.out.println(rootDirectory.DeleteFile(sc.nextLine()));
				break;

			case 3:
				System.out.println("Enter File Name");
				if(rootDirectory.SearchFile(sc.nextLine()))
					System.out.println("File is present in the directory");
				else
					System.out.println("File Not Found! Please Try Again!");
				break;

			case 4:
				System.out.println("Returning To Main Menu...");
				break;
			default:
				break;
			}
		}while(businessOption!=4);
	}

}
