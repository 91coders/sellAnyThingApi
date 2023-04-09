package com.sellAnyThing.sellAnyThing.controller;

import com.sellAnyThing.sellAnyThing.dao.StudentDao;
import com.sellAnyThing.sellAnyThing.model.InsertAdsModel;
import com.sellAnyThing.sellAnyThing.model.UpdateAdsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserResources {

    @Autowired
    private StudentDao studentDao;

//    @PostMapping("/insertAdd")
//    public String insert(@RequestBody Map<String, Object> userMap) {
//        String firstName =  userMap.get("firstName");
//        String city =  userMap.get("city");
//        ArrayList keywords = (ArrayList) userMap.get("keywords");
//
//        studentDao.insertData(firstName, city, keywords);
//        return "Data Inserted Successfully ";
//    }


    // Todo below code to accept arrays in api
//    @PostMapping("/insertAdd")
//    public String insert(@RequestBody Map<String, Object> userMap) {
//        String firstName =  userMap.get("firstName");
//        String city =  userMap.get("city");
//        ArrayList keywords = (ArrayList) userMap.get("keywords");
//
//        studentDao.insertData(firstName, city, keywords);
//        return "Data Inserted Successfully ";
//    }

    @GetMapping("/create_table")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public String createTable(@RequestParam String country_code) {
        studentDao.createAdTable(country_code);
        return "Table Created Successfully";
    }

    @PostMapping(path = "/insert_ads", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public ResponseEntity<InsertAdsModel> insertAds(InsertAdsModel userMap) {

        String ad_id = userMap.getAd_id();
        String user_id = userMap.getUser_id();
        String ad_category = userMap.getAd_category();
        String ad_latlong = userMap.getAd_latlong();
        String ad_visibility = userMap.getAd_visibility();
        String ad_tags = userMap.getAd_tags();
        String ad_title = userMap.getAd_title();
        String ad_description = userMap.getAd_description();
        String ad_combo = userMap.getAd_combo();
        String ad_expiry = userMap.getAd_expiry();
        String ad_campaign_price = userMap.getAd_campaign_price();
        String createdon = userMap.getCreatedon();
        String country_code = userMap.getCountry_code();

        studentDao.insertAds(ad_id, user_id, ad_category, ad_latlong, ad_visibility, ad_tags,
                ad_title, ad_description, ad_combo, ad_expiry, ad_campaign_price, createdon, country_code);
        return new ResponseEntity<InsertAdsModel>(userMap, HttpStatus.OK);
    }

    @PatchMapping(path = "/update_ad", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public String updateAd(UpdateAdsModel userMap) {

        String country_code = userMap.getCountry_code();
        String ad_id = userMap.getAd_id();
        String keyname = userMap.getKey_name();
        String keyvalue = userMap.getKey_value();

        studentDao.updateAds(country_code, ad_id, keyname, keyvalue);
        return "Ad Updated Successfully";
    }


    @DeleteMapping("/remove_ad")
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public String deleteAd(@RequestParam String country, @RequestParam String adid) {
        studentDao.deleteAds(adid, country);
        return "Ad Deleted Successfully";
    }


}
