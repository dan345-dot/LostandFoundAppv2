package com.example.lostandfoundappv2;

import java.util.Date;

public class Items
{
    public String id;
    public String name;
    public String Phone;
    public String Location;
    public String Description;
    public String Date;
    public String imageUri;
    public String timestamp;

    public Items(String id, String name, String Phone, String Location, String Description, String Date, String timestamp, String imageUri){
        this.id = id;
        this.name = name;
        this.Phone = Phone;
        this.Location = Location;
        this.Description = Description;
        this.Date = Date;
        this.imageUri = imageUri;
        this.timestamp = timestamp;

    }


    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return Phone;
    }

    public String getLocation() {
        return Location;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return Date;
    }

    public String getImageURI(){
        return imageUri;
    }

    public void setId(String id){
        this.id = id;
    }
}