/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author LeNoVo
 */
public class produit {
    private int id_product,stock,id_vendor ;
    private String title,description_prod,photo_prod;
    private float price;

    public produit() {
    }

    public produit(int id_product, int stock, int id_vendor, String title, String description_prod, String photo_prod, float price) {
        this.id_product = id_product;
        this.stock = stock;
        this.id_vendor = id_vendor;
        this.title = title;
        this.description_prod = description_prod;
        this.photo_prod = photo_prod;
        this.price = price;
    }

   

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_vendor() {
        return id_vendor;
    }

    public void setId_vendor(int id_vendor) {
        this.id_vendor = id_vendor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription_prod() {
        return description_prod;
    }

    public void setDescription_prod(String description_prod) {
        this.description_prod = description_prod;
    }

    public String getPhoto_prod() {
        return photo_prod;
    }

    public void setPhoto_prod(String photo_prod) {
        this.photo_prod = photo_prod;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "produit{" + "id_product=" + id_product + ", stock=" + stock + ", id_vendor=" + id_vendor + ", title=" + title + ", description_prod=" + description_prod + ", photo_prod=" + photo_prod + ", price=" + price + "}\n";
    }
    
    
    
    
    
}
