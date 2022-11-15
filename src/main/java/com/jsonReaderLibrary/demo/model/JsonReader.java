package com.jsonReaderLibrary.demo.model;

import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    List<Isbn> isbnList = new ArrayList<Isbn>();
    List<Lccn> lccnList = new ArrayList<Lccn>();

    public List<Isbn> getIsbnList() {
        return isbnList;
    }

    public void setIsbnList(List<Isbn> isbnList) {
        this.isbnList = isbnList;
    }

    public List<Lccn> getLccnList() {
        return lccnList;
    }

    public void setLccnList(List<Lccn> lccnList) {
        this.lccnList = lccnList;
    }

    public JsonReader(List<Isbn> isbnList, List<Lccn> lccnList) {
        this.isbnList = isbnList;
        this.lccnList = lccnList;
    }
}
