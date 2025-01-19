/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import utils.Inputter;

/**
 *
 * @author Gia Huy
 */
public class FruitList {

    HashMap<String, Fruit> fruitList = new HashMap<>();

    public boolean loadFromFile(String url) {
        File f = new File(url);
        try {
            //xử lý file
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while (line != null) {
                //xử lý dòng
                StringTokenizer st = new StringTokenizer(line, ",");
                String id = st.nextToken().trim();
                String name = st.nextToken().trim();
                double price = Double.parseDouble(st.nextToken().trim());
                int quantity = Integer.parseInt(st.nextToken().trim());
                String origin = st.nextToken().trim();

                Fruit fruit = new Fruit(id, name, price, quantity, origin);
                fruitList.put(id, fruit);

            }
            return true;
        } catch (Exception e) {
            System.out.println("Brand file error:" + e);
            return false;
        }
    }

    public void showFruitList(){
        if(fruitList.isEmpty()){
            System.out.println("There is NOTHING to print");
        }
        ArrayList<Fruit> fruit = new ArrayList<>(fruitList.values());
        for (Fruit fruit1 : fruit) {
            System.out.println(fruit1);
        }
    }
    
    public void addFruit(){
        String id = Inputter.getString("Please input an ID to add", "must have valid ID", "[U|u]\\d{3}");
        if (fruitList.containsKey(id)) {
            System.out.println("This key already exist");
            return;
        }

        String name = Inputter.getString("Please input name", "This field is required");
        double price = Inputter.getADouble("Please input price", "Price is not valid");
        int quantity = Inputter.getAnInteger("Please input quantity", "quantity is not valid", 0, 100);
        String origin = Inputter.getString("Please input origin", "This field is required");

        fruitList.put(id, new Fruit(id, name, price, quantity, origin));

        System.out.println("User added successfullly");
    }
    
    public boolean saveToFile(String url){
        File f = new File(url);
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
            for (Fruit value : fruitList.values()) {
                writer.write(value.toString());
                writer.write("\n");
            }
            writer.flush();
            
            return true;
        }catch(Exception e){
            System.out.println("Failed to save to file" + e);
            return false;
        }
    }

    
}
