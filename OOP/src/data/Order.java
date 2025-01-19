/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Gia Huy
 */
public class Order {
    ArrayList<Customer> orderList = new ArrayList<>();
    ArrayList<Fruit> shoppingList = new ArrayList<>();
    FruitList fruitList;
    
    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            //xử lý file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                //xử lý dòng
                StringTokenizer st = new StringTokenizer(line, ",");
                String customer = st.nextToken().trim();
                String product = st.nextToken().trim();
                int quantity = Integer.parseInt(st.nextToken().trim());
                double price = Double.parseDouble(st.nextToken().trim());
                double amount = Double.parseDouble(st.nextToken().trim());
                
                orderList.add(new Customer(customer, product, quantity, price, amount));
            }
            return true;
        } catch (Exception e) {
            System.out.println("Brand file error:" + e);
            return false;
        }
    }
    
    public void showOrder(){
        for (Fruit fruit : orderList) {
            
            System.out.println(fruit);
        }
    }
    
}
