package com.sellAnyThing.sellAnyThing.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //inserting data to db
//    public void insertData(String name, String city, String keywords) {
////        var q = "Insert into CityTable (name, city,keywords) values(?,?,?)";
//
//        ArrayList<String> sdf = new ArrayList<>();
//        String[] spliter = keywords.split(",");
//        for (String s : spliter) {
//            sdf.add(s);
//        }
//
//        var q = "Insert into CityTable (name, city,keywords) values('" + name + "','" + city + "',ARRAY[" + sdf + "])";
//
//        int update = this.jdbcTemplate.update(q);
//        System.out.println(update + " rows added");
//    }


//    public void insertData(String name, String city, ArrayList keywords) {
////        var q = "Insert into CityTable (name, city,keywords) values(?,?,?)";
//        var q = "Insert into CityTable (name, city,keywords) values('" + name + "', '" + city + "', ARRAY" + keywords + ")";
//        int update = this.jdbcTemplate.update(q);
//        System.out.println(update + " rows added");
//    }


    public void createAdTable(String country_code) {
        var query = "CREATE TABLE IF NOT EXISTS public." + country_code + " (id serial NOT NULL, ad_id character(100) NOT NULL, user_id character(100) NOT NULL, createdon character(50) NOT NULL, ad_category character(100), ad_latlong geography, ad_visibility character(50), ad_tags text, ad_title text NOT NULL, ad_description text, ad_combo text NOT NULL, ad_expiry character (50) NOT NULL, ad_campaign_price integer NOT NULL, PRIMARY KEY (id))";
        this.jdbcTemplate.update(query);
    }

    public void insertAds(String ad_id, String user_id, String ad_category, String ad_latlong, String ad_visibility,
                          String ad_tags, String ad_title, String ad_description, String ad_combo,
                          String ad_expiry, String ad_campaign_price, String createdon, String country_code) {
        var query = "INSERT INTO public." + country_code + " (ad_id, user_id, ad_category, ad_latlong, ad_visibility, " +
                "ad_tags, ad_title, ad_description, ad_combo, ad_expiry, ad_campaign_price, createdon) VALUES('" + ad_id + "', '" + user_id + "', '" + ad_category + "'," +
                " '" + ad_latlong + "', '" + ad_visibility + "', '" + ad_tags + "', '" + ad_title + "', '" + ad_description + "', '" + ad_combo + "', '" + ad_expiry + "'," +
                " '" + ad_campaign_price + "', '" + createdon + "')";
        this.jdbcTemplate.update(query);
    }


    public void updateAds(String countryCode, String ad_id, String keyName, String keyvalue) {
        var query = "UPDATE public." + countryCode + " SET " + keyName + " = '" + keyvalue + "' WHERE ad_id = '" + ad_id + "'";
        this.jdbcTemplate.update(query);
//        System.out.println(query);
    }


    public void deleteAds(String ad_id, String countryCode) {
        var query = "DELETE FROM public." + countryCode + " WHERE id IN (" + ad_id + ")";
        this.jdbcTemplate.update(query);
//        System.out.println(query);
    }


}