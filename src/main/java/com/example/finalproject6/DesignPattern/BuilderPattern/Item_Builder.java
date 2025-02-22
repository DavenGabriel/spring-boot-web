package com.example.finalproject6.DesignPattern.BuilderPattern;
import com.example.finalproject6.pojo.Item;

public class Item_Builder {
    private String name;
    private String category;
    private String price;
    private String itemPic;
    public Item_Builder setName(String name) {
        this.name = name;
        return this;
    }
    public Item_Builder setCategory(String category) {
        this.category = category;
        return this;
    }
    public Item_Builder setPrice(String price) {
        this.price = price;
        return this;
    }
    public Item_Builder setItemPic(String itemPic) {
        this.itemPic = itemPic;
        return this;
    }
    public Item build() {
        Item item = new Item();
        item.setName(name);
        item.setCategory(category);
        item.setPrice(price);
        item.setItemPic(itemPic);
        return item;
    }


}
