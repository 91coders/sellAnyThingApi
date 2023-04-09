package com.sellAnyThing.sellAnyThing.model;

public class UpdateAdsModel {
    private String ad_id;
    private String country_code;
    private String key_name;
    private String key_value;

    public UpdateAdsModel() {
    }

    public UpdateAdsModel(String ad_id, String country_code, String key_name, String key_value) {
        this.ad_id = ad_id;
        this.country_code = country_code;
        this.key_name = key_name;
        this.key_value = key_value;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getKey_value() {
        return key_value;
    }

    public void setKey_value(String key_value) {
        this.key_value = key_value;
    }
}
