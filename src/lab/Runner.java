package lab;

import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
//import java.awt.font.*;
//import java.awt.font.*;
//import java.io.*;

public class Runner {	
	public static void main(String[] args) throws Exception {
		
		//Setting up scanner to get txt file
		Scanner houseData = new Scanner(new File("src/lab/data.txt"));
		Scanner picData = new Scanner(new File("src/lab/dataPics.txt"));
		
		//Pulling data from file
		ArrayList<House> dataList = new ArrayList<House> ();
		ArrayList<HousePics> picList = new ArrayList<HousePics> ();
		
//		while (houseData.hasNext())
		for (int i = 0; i < 6; i++) {   
			
		    houseData.nextLine();
			String address = houseData.nextLine();
			String sqft = houseData.nextLine();
			String numBeds = houseData.nextLine();
			String numBath = houseData.nextLine();
			String price = houseData.next();
			
			//Testing that data prints
//			System.out.println("address: " + address);
//			System.out.println("sqft: " + sqft);
//			System.out.println("numBeds: " + numBeds);
//			System.out.println("numBath: " + numBath);
//			System.out.println("price: " + price);
			
			//add new house
			dataList.add(new House(address, sqft, numBeds, numBath, price));		
			
		} 
		
		for (int i = 0; i < 6; i++) {
			
			picData.nextLine();
			String picSrc = picData.nextLine();
			
			picList.add(new HousePics(picSrc));		
			
		}
		
		realEstate(dataList, picList);
		
//		for(int i = 0; i < dataList.size(); i++) {   
//		    System.out.print(dataList.get(i));
//		}  
	}
	
	public static void realEstate(final ArrayList<House> dataList, final ArrayList<HousePics> picList) throws Exception {
		//Setting up initial GUI window
		JFrame agent = new JFrame("House List");
		agent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		agent.setSize(905, 610); //width, height
		
		//creates font
		Font titleFont = new Font("SansSerif", Font.BOLD, 25);
		
		JLabel title = new JLabel("It's Free Real Estate!! :)");
		//activates label
		title.setBounds(15, 10, 1500, 50); //x, y, width, height	
		title.setFont(titleFont);
		//add label to the frame
		agent.add(title);
		
		JButton exitButton = new JButton ("Exit");
//		exitButton.setFont(buttons);
		exitButton.setBounds(690, 15, 200, 35); //x, y, width, height
		agent.add(exitButton);
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
/*
 * adding different variables to the home page
 */
		Font buttons = new Font("Monospaced", Font.PLAIN, 15);
		
		//prints pictures on home page
		int x = 20;
		int y = 70; //340
		for (int i = 0; i < 6; i++) {
			if (i == 3) {
				x = 20;
				y = 340;
			}
			ImageIcon picture = new ImageIcon(picList.get(i).getPicSrc());
			ImageIcon scaled = new ImageIcon(picture.getImage().getScaledInstance(275,166,java.awt.Image.SCALE_SMOOTH));
			JLabel picLabel1 = new JLabel(scaled);
			picLabel1.setBounds(x, y, scaled.getIconWidth(), scaled.getIconHeight());
			agent.add(picLabel1);
				
			x = x + 295;
			
		}
		
		//making and printing the view buttons on the home page		
		x = 20;
		y = 250;	
		int num = 0;
		for (int i = 0; i < 6; i++) {			
			if (i == 3) {
				x = 20;
				y = 520;
			}
			
			JButton viewButton = new JButton ("View House");
			viewButton.setFont(buttons);
			viewButton.setBounds(x, y, 275, 50); //x, y, width, height
			agent.add(viewButton);
			
			final int numFinal = num;
			viewButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (numFinal == 0) {
						try {
							House1(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} if (numFinal == 1) {
						try {
							House2(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}	
					} if (numFinal == 2) {
						try {
							House3(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} if (numFinal == 3) {
						try {
							House4(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} if (numFinal == 4) {
						try {
							House5(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} if (numFinal == 5) {
						try {
							House6(dataList, picList);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				
			});
			
			x = x + 295;
			num++;
		}
		
		//don't use a layout
		agent.setLayout(null);
		//build the frame(make it visible)
		agent.setVisible(true);
		
	}
	
	
	public static void House1(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 1");
		house.setSize(1200, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(0).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(0).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(0).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(0).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(0).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(0).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}
	
	public static void House2(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 2");
		house.setSize(1205, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(1).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(1).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(1).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(1).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(1).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(1).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}
	
	public static void House3(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 3");
		house.setSize(1150, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(2).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(2).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(2).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(2).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(2).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(2).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}
	
	public static void House4(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 4");
		house.setSize(1210, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(3).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(3).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(3).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(3).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(3).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(3).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}
	
	public static void House5(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 5");
		house.setSize(1150, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(4).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(4).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(4).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(4).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(4).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(4).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}
	
	public static void House6(ArrayList<House> dataList, ArrayList<HousePics> picList) throws Exception {
		JFrame house = new JFrame("House Listing 6");
		house.setSize(1140, 523); //width, height
		
		//picture of house
		ImageIcon pic = new ImageIcon(picList.get(5).getPicSrc());
		ImageIcon scaled = new ImageIcon(pic.getImage().getScaledInstance(775,467,java.awt.Image.SCALE_SMOOTH));
		JLabel picLabel = new JLabel(scaled);
		picLabel.setBounds(15, 15, scaled.getIconWidth(), scaled.getIconHeight());
		house.add(picLabel);
		
		//Constants
		Font askFont = new Font("SansSerif", Font.BOLD, 13); //13
		
		JLabel address = new JLabel("Address");
		address.setBounds(825, 15, 1500, 20); //x, y, width, height
		address.setFont(askFont);
		house.add(address);
		
		JLabel sqft = new JLabel("SqFt");
		sqft.setBounds(825, 40, 1500, 20); //x, y, width, height
		sqft.setFont(askFont);
		house.add(sqft);
		
		JLabel bed = new JLabel("Beds");
		bed.setBounds(825, 65, 1500, 20); //x, y, width, height
		bed.setFont(askFont);
		house.add(bed);
		
		JLabel bath = new JLabel("Baths");
		bath.setBounds(825, 90, 1500, 20); //x, y, width, height
		bath.setFont(askFont);
		house.add(bath);
		
		Font askPrice = new Font("SansSerif", Font.BOLD, 15); //13
		
		JLabel price = new JLabel("Estimate Price");
		price.setBounds(830, 130, 1500, 20); //x, y, width, height
		price.setFont(askPrice);
		house.add(price);
		
		//dataList info pulled
		Font replyFont = new Font("SansSerif", Font.PLAIN, 13);
		
		JLabel address1 = new JLabel(dataList.get(5).getAddress());
		address1.setBounds(900, 15, 1500, 20); //x, y, width, height
		address1.setFont(replyFont);
		house.add(address1);
		
		JLabel sqft1 = new JLabel(dataList.get(5).getSqft());
		sqft1.setBounds(900, 40, 1500, 20); //x, y, width, height
		sqft1.setFont(replyFont);
		house.add(sqft1);
		
		JLabel bed1 = new JLabel(dataList.get(5).getNumBeds());
		bed1.setBounds(900, 65, 1500, 20); //x, y, width, height
		bed1.setFont(replyFont);
		house.add(bed1);
		
		JLabel bath1 = new JLabel(dataList.get(5).getNumBath());
		bath1.setBounds(900, 90, 1500, 20); //x, y, width, height
		bath1.setFont(replyFont);
		house.add(bath1);
		
		Font replyPrice = new Font("SansSerif", Font.PLAIN, 30); //13
		
		JLabel price1 = new JLabel("$" + dataList.get(5).getPrice());
		price1.setBounds(850, 155, 1500, 30); //x, y, width, height
		price1.setFont(replyPrice);
		house.add(price1);
		
		//don't use a layout
		house.setLayout(null);
		//build the frame(make it visible)
		house.setVisible(true);
	}

}

