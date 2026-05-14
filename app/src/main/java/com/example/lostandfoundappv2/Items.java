package com.example.lostandfoundappv2;

class Items
{
    public String id;
    public String name;

    public Items(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}