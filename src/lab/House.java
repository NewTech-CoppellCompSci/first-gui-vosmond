package lab;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class House {	
	
//instance variables
	private String address;
	private String sqft;
	private String numBeds;
	private String numBath;
	private String price;
	
//constructor
	public House(String address, String sqft, String numBeds, String numBath, String price) {
		this.address = address;
		this.sqft = sqft;
		this.numBeds = numBeds;
		this.numBath = numBath;
		this.price = price;
		
	}
	
//getter / setter methods
	public String getAddress() { return address; }
	public String getSqft() { return sqft; }
	public String getNumBeds() { return numBeds; }
	public String getNumBath() { return numBath; }
	public String getPrice() { return price; }
	
//override toString
	public String toString() {
		return "Address: " + address + "\nSq Ft: " + sqft + "\nBeds: " + numBeds + 
				"\nBaths: " + numBath + "\nEstimated Price: " + price + "\n\n";
	}
	
}
