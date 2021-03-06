package com.arwizon.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.arwizon.model.Product;
import com.arwizon.service.AdminInterface;
import com.arwizon.service.AdminInterfaceImpl;
import com.arwizon.utility.ConnectionDB;
import com.arwizon.utility.Utilities;

public class TestAmazon {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		AdminInterface ad = new AdminInterfaceImpl();

		while(true) {
			System.out.println("Press 1 to add product" 
					+"\nPress 2 to display product details"
					+"\nPress 3 to search product details"
					+"\nPress 4 to update for product details"
					+"\nPress 5 to delete the product");

			System.out.println("Please choose  your option");
			int ch = scn.nextInt();
			switch(ch) {

			case 1:

				String name = null;
				while (true) {
					System.out.println("Enter product name");
					name = scn.next();
					try {
						Utilities.validateChar(name);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String description = null;
				while (true) {
					System.out.println("Enter product description");
					description = scn.next();
					try {
						Utilities.validateChar(description);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String manufacturerName = null;
				while (true) {
					System.out.println("Enter Manufacturer name");
					manufacturerName = scn.next();
					try {
						Utilities.validateChar(manufacturerName);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}
				String price = null;
				while (true) {
					System.out.println("Enter Price");
					price= scn.next();
					try {
						Utilities.validatePrice(price);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}


				}
				int price1 = Integer.parseInt(price);

				String discount = null;
				while (true) {
					System.out.println("Enter discount");
					discount = scn.next();
					try {
						Utilities.validateUnits(discount);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}


				}
				int discount1 = Integer.parseInt(discount);

				String noOfUnits = null;
				while (true) {
					System.out.println("Enter Number of Units");
					noOfUnits = scn.next();
					try {
						Utilities.validateUnits(noOfUnits);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}


				}
				int noOfUnits1 = Integer.parseInt(noOfUnits);
				String category = null;
				while (true) {
					System.out.println("Enter category");
					category = scn.next();
					try {
						Utilities.validateChar(category);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				}

				String imgUrl = null;
				while (true) {
					System.out.println("Enter Imageurl");
					imgUrl = scn.next();
					try {
						Utilities.validateUrl(imgUrl);
						break;
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}


				AdminInterface  a = new AdminInterfaceImpl();
				a.addProduct(name,description,price1,manufacturerName,discount1,imgUrl,noOfUnits1,category);

				System.out.println("Product Added Successfully");


				break;

			case 2:
				Set<Product> s = ad.DisplayAllProducts();

				for(Product pro:s) {
					System.out.println(pro);
				}

				break;

			case 3:

				System.out.println("please enter product name");
				String name1=scn.next();

				Set<Product> product= ad.searchProduct(name1);
				if(product.size()==0) {
					System.out.println("Product not found");
				}else {
					System.out.println("Product Found");
					for(Product p1:product) {
						System.out.println(p1);
					}
				}


				break;

			case 4:
				System.out.println("Enter Product Id");
				String proId = scn.next();
				int productId2 = Integer.parseInt(proId);
				System.out.println("Enter your Updated No Of Units");
				String units = scn.next();
				int units1 = Integer.parseInt(units);
				ad.updateProduct(productId2, units1);
				System.out.println("Units Updated Successfully");

				break;


			case 5:
				System.out.println("Enter Product Id");
				String productId = scn.next();
				int productId1 = Integer.parseInt(productId);
				ad.deleteProduct(productId1);
				System.out.println("Product Deleted Successfully");
				break;

			default:

				System.out.println("Invalid option");

			}
		}

	}

}


