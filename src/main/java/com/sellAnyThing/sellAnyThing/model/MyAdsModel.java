package com.sellAnyThing.sellAnyThing.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "nz")
public class MyAdsModel implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad_id", columnDefinition = "character")
    private String ad_id;
    @Column(name = "user_id", columnDefinition = "character")
    private String user_id;
    @Column(name = "createdon", columnDefinition = "character")
    private String createdon;
    @Column(name = "ad_category", columnDefinition = "character")
    private String ad_category;

    @Column(name = "ad_latlong", columnDefinition = "geography")
    private String ad_latlong;
    @Column(name = "ad_visibility", columnDefinition = "character")
    private String ad_visibility;
    @Column(name = "ad_tags", columnDefinition = "text")
    private String ad_tags;
    @Column(name = "ad_title", columnDefinition = "text")
    private String ad_title;
    @Column(name = "ad_description", columnDefinition = "text")
    private String ad_description;
    @Column(name = "ad_combo", columnDefinition = "text")
    private String ad_combo;
    @Column(name = "ad_expiry", columnDefinition = "character")
    private String ad_expiry;
    @Column(name = "ad_campaign_price", columnDefinition = "Integer")
    private Integer ad_campaign_price;
}