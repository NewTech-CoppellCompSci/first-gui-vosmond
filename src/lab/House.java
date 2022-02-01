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
	
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner houseData = new Scanner(("data.txt"));
		Scanner houseData = new Scanner(new File("data.txt"));
		
		ArrayList<String> dataList = new ArrayList<String>();
		while (houseData.hasNext()){
			dataList.add(houseData.next());
		}
		houseData.close();

		 System.out.print(dataList);
//		for(int i = 0; i < dataList.size(); i++) {   
//		    System.out.print(dataList.get(i));
//		}  
		
	}
	
}
