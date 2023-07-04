package com.example.myapplication2;

public class Diary {

        private Integer id;
        private String  name;
        private String  tittle;
        private String  note;
        private String  creatday;
        private String  picture;

    public Diary(){}
    public Diary(Integer id,String name,String note,String creatday,String picture){
        this.id       =  id;
        this.name     =  name;
        this.tittle   =  tittle;
        this.note     =  note;
        this.creatday =  creatday;
        this.picture  =  picture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreatday() {
        return creatday;
    }

    public void setCreatday(String creatday) {
        this.creatday = creatday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getTittle() {
        return tittle;
    }

    public void setTittlee(String tittle) {
        this.tittle = tittle;
    }
}
