package com.sellAnyThing.sellAnyThing.model;

public class InsertAdsModel {
    private String ad_id;
    private String user_id;
    private String ad_category;
    private String ad_latlong;
    private String ad_visibility;
    private String ad_tags;
    private String ad_title;
    private String ad_description;
    private String ad_combo;
    private String ad_expiry;
    private String ad_campaign_price;
    private String createdon;
    private String country_code;

    public InsertAdsModel() {
    }

    public InsertAdsModel(String ad_id, String user_id, String ad_category, String ad_latlong, String ad_visibility, String ad_tags, String ad_title, String ad_description, String ad_combo, String ad_expiry, String ad_campaign_price, String createdon, String country_code) {
        this.ad_id = ad_id;
        this.user_id = user_id;
        this.ad_category = ad_category;
        this.ad_latlong = ad_latlong;
        this.ad_visibility = ad_visibility;
        this.ad_tags = ad_tags;
        this.ad_title = ad_title;
        this.ad_description = ad_description;
        this.ad_combo = ad_combo;
        this.ad_expiry = ad_expiry;
        this.ad_campaign_price = ad_campaign_price;
        this.createdon = createdon;
        this.country_code = country_code;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAd_category() {
        return ad_category;
    }

    public void setAd_category(String ad_category) {
        this.ad_category = ad_category;
    }

    public String getAd_latlong() {
        return ad_latlong;
    }

    public void setAd_latlong(String ad_latlong) {
        this.ad_latlong = ad_latlong;
    }

    public String getAd_visibility() {
        return ad_visibility;
    }

    public void setAd_visibility(String ad_visibility) {
        this.ad_visibility = ad_visibility;
    }

    public String getAd_tags() {
        return ad_tags;
    }

    public void setAd_tags(String ad_tags) {
        this.ad_tags = ad_tags;
    }

    public String getAd_title() {
        return ad_title;
    }

    public void setAd_title(String ad_title) {
        this.ad_title = ad_title;
    }

    public String getAd_description() {
        return ad_description;
    }

    public void setAd_description(String ad_description) {
        this.ad_description = ad_description;
    }

    public String getAd_combo() {
        return ad_combo;
    }

    public void setAd_combo(String ad_combo) {
        this.ad_combo = ad_combo;
    }

    public String getAd_expiry() {
        return ad_expiry;
    }

    public void setAd_expiry(String ad_expiry) {
        this.ad_expiry = ad_expiry;
    }

    public String getAd_campaign_price() {
        return ad_campaign_price;
    }

    public void setAd_campaign_price(String ad_campaign_price) {
        this.ad_campaign_price = ad_campaign_price;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }
}
