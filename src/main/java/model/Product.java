/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Product {
    //mendeklarasikan variabel id dan name 
    private String id;
    private String name;
    private int disc;
    private int price;
    private int total;

    //membuat method get utuk id
    public String getId() {
        return id;
    }

    //membuat method set untuk id
    public void setId(String id) {
        this.id = id;
    }

    //membuat method get untuk name
    public String getName() {
        return name;
    }

    //membuat method set untuk name
    public void setName(String name) {
        this.name = name;
    }

    public int getDisc() {
        return disc;
    }

    public void setDisc(int disc) {
        this.disc = disc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
