package kz.bitlab.spring.bootfirstapp.DBManager;

import kz.bitlab.spring.bootfirstapp.model.Items;

import java.util.ArrayList;

public class DBManager {
    private static ArrayList<Items> items = new ArrayList<>();
    private static Long id = 7L;

    static {
        items.add(new Items(1L, "Mac Book Pro","8 GB RAM 255 GB SSD Intel Core i7",1199.99));
        items.add(new Items(2L, "Mac Book Pro","16 GB RAM 500 GB SSD Apple M1",1499.99));
        items.add(new Items(3L, "Mac Book Pro","16 GB RAM 1 GB SSD Apple M1",1799.99));
        items.add(new Items(4L, "ASUS Tuf Gaming","8 GB RAM 255 GB SSD Intel Core i7",1299.99));
        items.add(new Items(5L, "HP Laser Pro","8 GB RAM 500 GB SSD Intel Core i5",999.99));
        items.add(new Items(6L, "Lenovo Legion","32 GB RAM 512 GB SSD Intel Core i7",1399.99));

    }

    public static void addItem(Items item){
        item.setId(id);
        items.add(item);
        id++;
    }

    public static ArrayList<Items> getAllItems(){
        return items;
    }

    public static Items getItem(Long id){
        for(Items it : items){
            if(it.getId() == id){
                return it;
            }
        }
        return null;
    }
}
