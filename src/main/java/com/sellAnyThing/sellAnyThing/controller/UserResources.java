package com.sellAnyThing.sellAnyThing.controller;

import com.sellAnyThing.sellAnyThing.dao.StudentDao;
import com.sellAnyThing.sellAnyThing.dto.PageRequestDto;
import com.sellAnyThing.sellAnyThing.model.InsertAdsModel;
import com.sellAnyThing.sellAnyThing.model.MyAdsModel;
import com.sellAnyThing.sellAnyThing.model.UpdateAdsModel;
import com.sellAnyThing.sellAnyThing.repository.MyAdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResources {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private MyAdsRepository myAdsRepository;

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
        String published_on = userMap.getPublished_on();
        String ad_selling_price = userMap.getAd_selling_price();

        studentDao.insertAds(ad_id, user_id, ad_category, ad_latlong, ad_visibility, ad_tags,
                ad_title, ad_description, ad_combo, ad_expiry, ad_campaign_price, createdon, country_code, published_on, ad_selling_price);
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

    @GetMapping("/create_index")
    @PreAuthorize("hasRole('ADMIN')")
    public String createIndexOnColumn(@RequestParam String country) {
        studentDao.createIndex(country);
        return "Index created on '" + country + "' Successfully";
    }


    @GetMapping(path = "/get_single_ad")
    public List<MyAdsModel> findById(@RequestParam("country_code") String country_code, @RequestParam("ad_id") String ad_id) {
        return studentDao.getSingleAd(country_code, ad_id);
    }

    @PostMapping(path = "/get_all_ads", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public Page<MyAdsModel> getAllItemsPaginated(PageRequestDto pageDto) {
        Pageable pageable = new PageRequestDto().getPageable(pageDto);
        Page<MyAdsModel> adPage = myAdsRepository.findAll(pageable);
        return adPage;
    }

    @PostMapping(path = "/get_filter_adopa", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public List<MyAdsModel> getFilterAdopa(PageRequestDto pageDto, @RequestParam String country_code, @RequestParam Double longitude, @RequestParam Double latitude, @RequestParam Long radius) {
        return studentDao.getAllAd(country_code, longitude, latitude, radius);
    }

    @PostMapping(path = "/get_all_filter_ads", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public List<MyAdsModel> getAllFilterAds(PageRequestDto pageDto, @RequestParam String country_code, @RequestParam Double longitude, @RequestParam Double latitude, @RequestParam Long radius, @RequestParam String keyword) {
        return studentDao.getAllFilterAd(country_code, longitude, latitude, radius, keyword);
    }

    @PostMapping(path = "/get_near_by_ads", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public Page<MyAdsModel> getDashboardAds(PageRequestDto pageDto, @RequestParam Double longitude, @RequestParam Double latitude,
                                            @RequestParam Long radius, @RequestParam String expiryMillis, @RequestParam String country_code) {
        Pageable pageable = new PageRequestDto().getPageable(pageDto);
//        Page<MyAdsModel> adPage = myAdsRepository.homeSearch_test(longitude, latitude, radius, pageable);
        Page<MyAdsModel> adPage = null;
        switch (country_code) {
            case "ad":
                adPage = myAdsRepository.homeSearch_ad(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ae":
                adPage = myAdsRepository.homeSearch_ae(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "af":
                adPage = myAdsRepository.homeSearch_af(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ag":
                adPage = myAdsRepository.homeSearch_ag(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ai":
                adPage = myAdsRepository.homeSearch_ai(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "al":
                adPage = myAdsRepository.homeSearch_al(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "am":
                adPage = myAdsRepository.homeSearch_am(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "an":
                adPage = myAdsRepository.homeSearch_an(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ao":
                adPage = myAdsRepository.homeSearch_ao(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "aq":
                adPage = myAdsRepository.homeSearch_aq(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ar":
                adPage = myAdsRepository.homeSearch_ar(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "as":
                adPage = myAdsRepository.homeSearch_as(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "at":
                adPage = myAdsRepository.homeSearch_at(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "au":
                adPage = myAdsRepository.homeSearch_au(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "aw":
                adPage = myAdsRepository.homeSearch_aw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "az":
                adPage = myAdsRepository.homeSearch_az(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ba":
                adPage = myAdsRepository.homeSearch_ba(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bb":
                adPage = myAdsRepository.homeSearch_bb(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bd":
                adPage = myAdsRepository.homeSearch_bd(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "be":
                adPage = myAdsRepository.homeSearch_be(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bf":
                adPage = myAdsRepository.homeSearch_bf(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bg":
                adPage = myAdsRepository.homeSearch_bg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bh":
                adPage = myAdsRepository.homeSearch_bh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bi":
                adPage = myAdsRepository.homeSearch_bi(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bj":
                adPage = myAdsRepository.homeSearch_bj(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bl":
                adPage = myAdsRepository.homeSearch_bl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bm":
                adPage = myAdsRepository.homeSearch_bm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bn":
                adPage = myAdsRepository.homeSearch_bn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bo":
                adPage = myAdsRepository.homeSearch_bo(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "br":
                adPage = myAdsRepository.homeSearch_br(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bs":
                adPage = myAdsRepository.homeSearch_bs(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bt":
                adPage = myAdsRepository.homeSearch_bt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bw":
                adPage = myAdsRepository.homeSearch_bw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "by":
                adPage = myAdsRepository.homeSearch_by(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "bz":
                adPage = myAdsRepository.homeSearch_bz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ca":
                adPage = myAdsRepository.homeSearch_ca(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cc":
                adPage = myAdsRepository.homeSearch_cc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cd":
                adPage = myAdsRepository.homeSearch_cd(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cf":
                adPage = myAdsRepository.homeSearch_cf(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cg":
                adPage = myAdsRepository.homeSearch_cg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ch":
                adPage = myAdsRepository.homeSearch_ch(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ci":
                adPage = myAdsRepository.homeSearch_ci(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ck":
                adPage = myAdsRepository.homeSearch_ck(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cl":
                adPage = myAdsRepository.homeSearch_cl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cm":
                adPage = myAdsRepository.homeSearch_cm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cn":
                adPage = myAdsRepository.homeSearch_cn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "co":
                adPage = myAdsRepository.homeSearch_co(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cr":
                adPage = myAdsRepository.homeSearch_cr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cu":
                adPage = myAdsRepository.homeSearch_cu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cv":
                adPage = myAdsRepository.homeSearch_cv(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cw":
                adPage = myAdsRepository.homeSearch_cw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cx":
                adPage = myAdsRepository.homeSearch_cx(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cy":
                adPage = myAdsRepository.homeSearch_cy(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "cz":
                adPage = myAdsRepository.homeSearch_cz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "de":
                adPage = myAdsRepository.homeSearch_de(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "dj":
                adPage = myAdsRepository.homeSearch_dj(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "dk":
                adPage = myAdsRepository.homeSearch_dk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "dm":
                adPage = myAdsRepository.homeSearch_dm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "do":
                adPage = myAdsRepository.homeSearch_do(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "dz":
                adPage = myAdsRepository.homeSearch_dz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ec":
                adPage = myAdsRepository.homeSearch_ec(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ee":
                adPage = myAdsRepository.homeSearch_ee(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "eg":
                adPage = myAdsRepository.homeSearch_eg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "eh":
                adPage = myAdsRepository.homeSearch_eh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "er":
                adPage = myAdsRepository.homeSearch_er(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "es":
                adPage = myAdsRepository.homeSearch_es(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "et":
                adPage = myAdsRepository.homeSearch_et(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fi":
                adPage = myAdsRepository.homeSearch_fi(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fj":
                adPage = myAdsRepository.homeSearch_fj(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fk":
                adPage = myAdsRepository.homeSearch_fk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fm":
                adPage = myAdsRepository.homeSearch_fm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fo":
                adPage = myAdsRepository.homeSearch_fo(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "fr":
                adPage = myAdsRepository.homeSearch_fr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ga":
                adPage = myAdsRepository.homeSearch_ga(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gb":
                adPage = myAdsRepository.homeSearch_gb(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gd":
                adPage = myAdsRepository.homeSearch_gd(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ge":
                adPage = myAdsRepository.homeSearch_ge(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gg":
                adPage = myAdsRepository.homeSearch_gg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gh":
                adPage = myAdsRepository.homeSearch_gh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gi":
                adPage = myAdsRepository.homeSearch_gi(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gl":
                adPage = myAdsRepository.homeSearch_gl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gm":
                adPage = myAdsRepository.homeSearch_gm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gn":
                adPage = myAdsRepository.homeSearch_gn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gq":
                adPage = myAdsRepository.homeSearch_gq(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gr":
                adPage = myAdsRepository.homeSearch_gr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gt":
                adPage = myAdsRepository.homeSearch_gt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gu":
                adPage = myAdsRepository.homeSearch_gu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gw":
                adPage = myAdsRepository.homeSearch_gw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "gy":
                adPage = myAdsRepository.homeSearch_gy(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "hk":
                adPage = myAdsRepository.homeSearch_hk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "hn":
                adPage = myAdsRepository.homeSearch_hn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "hr":
                adPage = myAdsRepository.homeSearch_hr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ht":
                adPage = myAdsRepository.homeSearch_ht(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "hu":
                adPage = myAdsRepository.homeSearch_hu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "id":
                adPage = myAdsRepository.homeSearch_id(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ie":
                adPage = myAdsRepository.homeSearch_ie(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "il":
                adPage = myAdsRepository.homeSearch_il(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "im":
                adPage = myAdsRepository.homeSearch_im(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "in":
                adPage = myAdsRepository.homeSearch_in(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "io":
                adPage = myAdsRepository.homeSearch_io(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "iq":
                adPage = myAdsRepository.homeSearch_iq(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ir":
                adPage = myAdsRepository.homeSearch_ir(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "is":
                adPage = myAdsRepository.homeSearch_is(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "it":
                adPage = myAdsRepository.homeSearch_it(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "je":
                adPage = myAdsRepository.homeSearch_je(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "jm":
                adPage = myAdsRepository.homeSearch_jm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "jo":
                adPage = myAdsRepository.homeSearch_jo(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "jp":
                adPage = myAdsRepository.homeSearch_jp(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ke":
                adPage = myAdsRepository.homeSearch_ke(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kg":
                adPage = myAdsRepository.homeSearch_kg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kh":
                adPage = myAdsRepository.homeSearch_kh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ki":
                adPage = myAdsRepository.homeSearch_ki(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "km":
                adPage = myAdsRepository.homeSearch_km(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kn":
                adPage = myAdsRepository.homeSearch_kn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kp":
                adPage = myAdsRepository.homeSearch_kp(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kr":
                adPage = myAdsRepository.homeSearch_kr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kw":
                adPage = myAdsRepository.homeSearch_kw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ky":
                adPage = myAdsRepository.homeSearch_ky(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "kz":
                adPage = myAdsRepository.homeSearch_kz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "la":
                adPage = myAdsRepository.homeSearch_la(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lb":
                adPage = myAdsRepository.homeSearch_lb(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lc":
                adPage = myAdsRepository.homeSearch_lc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "li":
                adPage = myAdsRepository.homeSearch_li(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lk":
                adPage = myAdsRepository.homeSearch_lk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lr":
                adPage = myAdsRepository.homeSearch_lr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ls":
                adPage = myAdsRepository.homeSearch_ls(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lt":
                adPage = myAdsRepository.homeSearch_lt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lu":
                adPage = myAdsRepository.homeSearch_lu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "lv":
                adPage = myAdsRepository.homeSearch_lv(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ly":
                adPage = myAdsRepository.homeSearch_ly(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ma":
                adPage = myAdsRepository.homeSearch_ma(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mc":
                adPage = myAdsRepository.homeSearch_mc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "md":
                adPage = myAdsRepository.homeSearch_md(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "me":
                adPage = myAdsRepository.homeSearch_me(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mf":
                adPage = myAdsRepository.homeSearch_mf(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mg":
                adPage = myAdsRepository.homeSearch_mg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mh":
                adPage = myAdsRepository.homeSearch_mh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mk":
                adPage = myAdsRepository.homeSearch_mk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ml":
                adPage = myAdsRepository.homeSearch_ml(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mm":
                adPage = myAdsRepository.homeSearch_mm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mn":
                adPage = myAdsRepository.homeSearch_mn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mo":
                adPage = myAdsRepository.homeSearch_mo(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mp":
                adPage = myAdsRepository.homeSearch_mp(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mr":
                adPage = myAdsRepository.homeSearch_mr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ms":
                adPage = myAdsRepository.homeSearch_ms(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mt":
                adPage = myAdsRepository.homeSearch_mt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mu":
                adPage = myAdsRepository.homeSearch_mu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mv":
                adPage = myAdsRepository.homeSearch_mv(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mw":
                adPage = myAdsRepository.homeSearch_mw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mx":
                adPage = myAdsRepository.homeSearch_mx(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "my":
                adPage = myAdsRepository.homeSearch_my(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "mz":
                adPage = myAdsRepository.homeSearch_mz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "na":
                adPage = myAdsRepository.homeSearch_na(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "nc":
                adPage = myAdsRepository.homeSearch_nc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ne":
                adPage = myAdsRepository.homeSearch_ne(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ng":
                adPage = myAdsRepository.homeSearch_ng(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ni":
                adPage = myAdsRepository.homeSearch_ni(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "nl":
                adPage = myAdsRepository.homeSearch_nl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "no":
                adPage = myAdsRepository.homeSearch_no(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "np":
                adPage = myAdsRepository.homeSearch_np(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "nr":
                adPage = myAdsRepository.homeSearch_nr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "nu":
                adPage = myAdsRepository.homeSearch_nu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "nz":
                adPage = myAdsRepository.homeSearch_nz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "om":
                adPage = myAdsRepository.homeSearch_om(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pa":
                adPage = myAdsRepository.homeSearch_pa(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pe":
                adPage = myAdsRepository.homeSearch_pe(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pf":
                adPage = myAdsRepository.homeSearch_pf(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pg":
                adPage = myAdsRepository.homeSearch_pg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ph":
                adPage = myAdsRepository.homeSearch_ph(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pk":
                adPage = myAdsRepository.homeSearch_pk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pl":
                adPage = myAdsRepository.homeSearch_pl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pm":
                adPage = myAdsRepository.homeSearch_pm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pn":
                adPage = myAdsRepository.homeSearch_pn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pr":
                adPage = myAdsRepository.homeSearch_pr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ps":
                adPage = myAdsRepository.homeSearch_ps(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pt":
                adPage = myAdsRepository.homeSearch_pt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "pw":
                adPage = myAdsRepository.homeSearch_pw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "py":
                adPage = myAdsRepository.homeSearch_py(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "qa":
                adPage = myAdsRepository.homeSearch_qa(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "re":
                adPage = myAdsRepository.homeSearch_re(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ro":
                adPage = myAdsRepository.homeSearch_ro(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "rs":
                adPage = myAdsRepository.homeSearch_rs(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ru":
                adPage = myAdsRepository.homeSearch_ru(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "rw":
                adPage = myAdsRepository.homeSearch_rw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sa":
                adPage = myAdsRepository.homeSearch_sa(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sb":
                adPage = myAdsRepository.homeSearch_sb(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sc":
                adPage = myAdsRepository.homeSearch_sc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sd":
                adPage = myAdsRepository.homeSearch_sd(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "se":
                adPage = myAdsRepository.homeSearch_se(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sg":
                adPage = myAdsRepository.homeSearch_sg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sh":
                adPage = myAdsRepository.homeSearch_sh(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "si":
                adPage = myAdsRepository.homeSearch_si(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sj":
                adPage = myAdsRepository.homeSearch_sj(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sk":
                adPage = myAdsRepository.homeSearch_sk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sl":
                adPage = myAdsRepository.homeSearch_sl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sm":
                adPage = myAdsRepository.homeSearch_sm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sn":
                adPage = myAdsRepository.homeSearch_sn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "so":
                adPage = myAdsRepository.homeSearch_so(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sr":
                adPage = myAdsRepository.homeSearch_sr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ss":
                adPage = myAdsRepository.homeSearch_ss(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "st":
                adPage = myAdsRepository.homeSearch_st(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sv":
                adPage = myAdsRepository.homeSearch_sv(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sx":
                adPage = myAdsRepository.homeSearch_sx(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sy":
                adPage = myAdsRepository.homeSearch_sy(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "sz":
                adPage = myAdsRepository.homeSearch_sz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tc":
                adPage = myAdsRepository.homeSearch_tc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "td":
                adPage = myAdsRepository.homeSearch_td(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tg":
                adPage = myAdsRepository.homeSearch_tg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "th":
                adPage = myAdsRepository.homeSearch_th(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tj":
                adPage = myAdsRepository.homeSearch_tj(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tk":
                adPage = myAdsRepository.homeSearch_tk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tl":
                adPage = myAdsRepository.homeSearch_tl(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tm":
                adPage = myAdsRepository.homeSearch_tm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tn":
                adPage = myAdsRepository.homeSearch_tn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "to":
                adPage = myAdsRepository.homeSearch_to(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tr":
                adPage = myAdsRepository.homeSearch_tr(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tt":
                adPage = myAdsRepository.homeSearch_tt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tv":
                adPage = myAdsRepository.homeSearch_tv(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tw":
                adPage = myAdsRepository.homeSearch_tw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "tz":
                adPage = myAdsRepository.homeSearch_tz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ua":
                adPage = myAdsRepository.homeSearch_ua(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ug":
                adPage = myAdsRepository.homeSearch_ug(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "us":
                adPage = myAdsRepository.homeSearch_us(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "uy":
                adPage = myAdsRepository.homeSearch_uy(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "uz":
                adPage = myAdsRepository.homeSearch_uz(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "va":
                adPage = myAdsRepository.homeSearch_va(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "vc":
                adPage = myAdsRepository.homeSearch_vc(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ve":
                adPage = myAdsRepository.homeSearch_ve(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "vg":
                adPage = myAdsRepository.homeSearch_vg(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "vi":
                adPage = myAdsRepository.homeSearch_vi(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "vn":
                adPage = myAdsRepository.homeSearch_vn(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "vu":
                adPage = myAdsRepository.homeSearch_vu(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "wf":
                adPage = myAdsRepository.homeSearch_wf(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ws":
                adPage = myAdsRepository.homeSearch_ws(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "xk":
                adPage = myAdsRepository.homeSearch_xk(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "ye":
                adPage = myAdsRepository.homeSearch_ye(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "yt":
                adPage = myAdsRepository.homeSearch_yt(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "za":
                adPage = myAdsRepository.homeSearch_za(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "zm":
                adPage = myAdsRepository.homeSearch_zm(longitude, latitude, radius, pageable, expiryMillis);
                break;
            case "zw":
                adPage = myAdsRepository.homeSearch_zw(longitude, latitude, radius, pageable, expiryMillis);
                break;
            default:
                adPage = myAdsRepository.homeSearch_test(longitude, latitude, radius, pageable, expiryMillis);
                break;
        }
        return adPage;
    }

    @PostMapping(path = "/get_search_ads", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasRole('ADMIN') || hasRole('USER')")
    public Page<MyAdsModel> getFilterAds(PageRequestDto pageDto, @RequestParam Double
            longitude, @RequestParam Double latitude, @RequestParam Long radius, @RequestParam String
                                                 keyword, @RequestParam String expiryMillis, @RequestParam String country_code) {
        Pageable pageable = new PageRequestDto().getPageable(pageDto);
        Page<MyAdsModel> adPage = null;
        switch (country_code) {
            case "ad":
                adPage = myAdsRepository.filterAdsBy_ad(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ae":
                adPage = myAdsRepository.filterAdsBy_ae(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "af":
                adPage = myAdsRepository.filterAdsBy_af(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ag":
                adPage = myAdsRepository.filterAdsBy_ag(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ai":
                adPage = myAdsRepository.filterAdsBy_ai(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "al":
                adPage = myAdsRepository.filterAdsBy_al(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "am":
                adPage = myAdsRepository.filterAdsBy_am(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "an":
                adPage = myAdsRepository.filterAdsBy_an(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ao":
                adPage = myAdsRepository.filterAdsBy_ao(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "aq":
                adPage = myAdsRepository.filterAdsBy_aq(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ar":
                adPage = myAdsRepository.filterAdsBy_ar(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "as":
                adPage = myAdsRepository.filterAdsBy_as(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "at":
                adPage = myAdsRepository.filterAdsBy_at(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "au":
                adPage = myAdsRepository.filterAdsBy_au(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "aw":
                adPage = myAdsRepository.filterAdsBy_aw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "az":
                adPage = myAdsRepository.filterAdsBy_az(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ba":
                adPage = myAdsRepository.filterAdsBy_ba(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bb":
                adPage = myAdsRepository.filterAdsBy_bb(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bd":
                adPage = myAdsRepository.filterAdsBy_bd(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "be":
                adPage = myAdsRepository.filterAdsBy_be(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bf":
                adPage = myAdsRepository.filterAdsBy_bf(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bg":
                adPage = myAdsRepository.filterAdsBy_bg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bh":
                adPage = myAdsRepository.filterAdsBy_bh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bi":
                adPage = myAdsRepository.filterAdsBy_bi(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bj":
                adPage = myAdsRepository.filterAdsBy_bj(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bl":
                adPage = myAdsRepository.filterAdsBy_bl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bm":
                adPage = myAdsRepository.filterAdsBy_bm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bn":
                adPage = myAdsRepository.filterAdsBy_bn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bo":
                adPage = myAdsRepository.filterAdsBy_bo(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "br":
                adPage = myAdsRepository.filterAdsBy_br(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bs":
                adPage = myAdsRepository.filterAdsBy_bs(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bt":
                adPage = myAdsRepository.filterAdsBy_bt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bw":
                adPage = myAdsRepository.filterAdsBy_bw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "by":
                adPage = myAdsRepository.filterAdsBy_by(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "bz":
                adPage = myAdsRepository.filterAdsBy_bz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ca":
                adPage = myAdsRepository.filterAdsBy_ca(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cc":
                adPage = myAdsRepository.filterAdsBy_cc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cd":
                adPage = myAdsRepository.filterAdsBy_cd(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cf":
                adPage = myAdsRepository.filterAdsBy_cf(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cg":
                adPage = myAdsRepository.filterAdsBy_cg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ch":
                adPage = myAdsRepository.filterAdsBy_ch(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ci":
                adPage = myAdsRepository.filterAdsBy_ci(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ck":
                adPage = myAdsRepository.filterAdsBy_ck(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cl":
                adPage = myAdsRepository.filterAdsBy_cl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cm":
                adPage = myAdsRepository.filterAdsBy_cm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cn":
                adPage = myAdsRepository.filterAdsBy_cn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "co":
                adPage = myAdsRepository.filterAdsBy_co(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cr":
                adPage = myAdsRepository.filterAdsBy_cr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cu":
                adPage = myAdsRepository.filterAdsBy_cu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cv":
                adPage = myAdsRepository.filterAdsBy_cv(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cw":
                adPage = myAdsRepository.filterAdsBy_cw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cx":
                adPage = myAdsRepository.filterAdsBy_cx(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cy":
                adPage = myAdsRepository.filterAdsBy_cy(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "cz":
                adPage = myAdsRepository.filterAdsBy_cz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "de":
                adPage = myAdsRepository.filterAdsBy_de(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "dj":
                adPage = myAdsRepository.filterAdsBy_dj(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "dk":
                adPage = myAdsRepository.filterAdsBy_dk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "dm":
                adPage = myAdsRepository.filterAdsBy_dm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "do":
                adPage = myAdsRepository.filterAdsBy_do(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "dz":
                adPage = myAdsRepository.filterAdsBy_dz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ec":
                adPage = myAdsRepository.filterAdsBy_ec(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ee":
                adPage = myAdsRepository.filterAdsBy_ee(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "eg":
                adPage = myAdsRepository.filterAdsBy_eg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "eh":
                adPage = myAdsRepository.filterAdsBy_eh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "er":
                adPage = myAdsRepository.filterAdsBy_er(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "es":
                adPage = myAdsRepository.filterAdsBy_es(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "et":
                adPage = myAdsRepository.filterAdsBy_et(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fi":
                adPage = myAdsRepository.filterAdsBy_fi(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fj":
                adPage = myAdsRepository.filterAdsBy_fj(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fk":
                adPage = myAdsRepository.filterAdsBy_fk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fm":
                adPage = myAdsRepository.filterAdsBy_fm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fo":
                adPage = myAdsRepository.filterAdsBy_fo(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "fr":
                adPage = myAdsRepository.filterAdsBy_fr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ga":
                adPage = myAdsRepository.filterAdsBy_ga(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gb":
                adPage = myAdsRepository.filterAdsBy_gb(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gd":
                adPage = myAdsRepository.filterAdsBy_gd(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ge":
                adPage = myAdsRepository.filterAdsBy_ge(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gg":
                adPage = myAdsRepository.filterAdsBy_gg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gh":
                adPage = myAdsRepository.filterAdsBy_gh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gi":
                adPage = myAdsRepository.filterAdsBy_gi(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gl":
                adPage = myAdsRepository.filterAdsBy_gl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gm":
                adPage = myAdsRepository.filterAdsBy_gm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gn":
                adPage = myAdsRepository.filterAdsBy_gn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gq":
                adPage = myAdsRepository.filterAdsBy_gq(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gr":
                adPage = myAdsRepository.filterAdsBy_gr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gt":
                adPage = myAdsRepository.filterAdsBy_gt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gu":
                adPage = myAdsRepository.filterAdsBy_gu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gw":
                adPage = myAdsRepository.filterAdsBy_gw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "gy":
                adPage = myAdsRepository.filterAdsBy_gy(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "hk":
                adPage = myAdsRepository.filterAdsBy_hk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "hn":
                adPage = myAdsRepository.filterAdsBy_hn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "hr":
                adPage = myAdsRepository.filterAdsBy_hr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ht":
                adPage = myAdsRepository.filterAdsBy_ht(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "hu":
                adPage = myAdsRepository.filterAdsBy_hu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "id":
                adPage = myAdsRepository.filterAdsBy_id(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ie":
                adPage = myAdsRepository.filterAdsBy_ie(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "il":
                adPage = myAdsRepository.filterAdsBy_il(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "im":
                adPage = myAdsRepository.filterAdsBy_im(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "in":
                adPage = myAdsRepository.filterAdsBy_in(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "io":
                adPage = myAdsRepository.filterAdsBy_io(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "iq":
                adPage = myAdsRepository.filterAdsBy_iq(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ir":
                adPage = myAdsRepository.filterAdsBy_ir(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "is":
                adPage = myAdsRepository.filterAdsBy_is(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "it":
                adPage = myAdsRepository.filterAdsBy_it(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "je":
                adPage = myAdsRepository.filterAdsBy_je(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "jm":
                adPage = myAdsRepository.filterAdsBy_jm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "jo":
                adPage = myAdsRepository.filterAdsBy_jo(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "jp":
                adPage = myAdsRepository.filterAdsBy_jp(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ke":
                adPage = myAdsRepository.filterAdsBy_ke(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kg":
                adPage = myAdsRepository.filterAdsBy_kg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kh":
                adPage = myAdsRepository.filterAdsBy_kh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ki":
                adPage = myAdsRepository.filterAdsBy_ki(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "km":
                adPage = myAdsRepository.filterAdsBy_km(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kn":
                adPage = myAdsRepository.filterAdsBy_kn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kp":
                adPage = myAdsRepository.filterAdsBy_kp(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kr":
                adPage = myAdsRepository.filterAdsBy_kr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kw":
                adPage = myAdsRepository.filterAdsBy_kw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ky":
                adPage = myAdsRepository.filterAdsBy_ky(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "kz":
                adPage = myAdsRepository.filterAdsBy_kz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "la":
                adPage = myAdsRepository.filterAdsBy_la(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lb":
                adPage = myAdsRepository.filterAdsBy_lb(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lc":
                adPage = myAdsRepository.filterAdsBy_lc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "li":
                adPage = myAdsRepository.filterAdsBy_li(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lk":
                adPage = myAdsRepository.filterAdsBy_lk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lr":
                adPage = myAdsRepository.filterAdsBy_lr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ls":
                adPage = myAdsRepository.filterAdsBy_ls(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lt":
                adPage = myAdsRepository.filterAdsBy_lt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lu":
                adPage = myAdsRepository.filterAdsBy_lu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "lv":
                adPage = myAdsRepository.filterAdsBy_lv(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ly":
                adPage = myAdsRepository.filterAdsBy_ly(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ma":
                adPage = myAdsRepository.filterAdsBy_ma(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mc":
                adPage = myAdsRepository.filterAdsBy_mc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "md":
                adPage = myAdsRepository.filterAdsBy_md(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "me":
                adPage = myAdsRepository.filterAdsBy_me(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mf":
                adPage = myAdsRepository.filterAdsBy_mf(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mg":
                adPage = myAdsRepository.filterAdsBy_mg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mh":
                adPage = myAdsRepository.filterAdsBy_mh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mk":
                adPage = myAdsRepository.filterAdsBy_mk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ml":
                adPage = myAdsRepository.filterAdsBy_ml(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mm":
                adPage = myAdsRepository.filterAdsBy_mm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mn":
                adPage = myAdsRepository.filterAdsBy_mn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mo":
                adPage = myAdsRepository.filterAdsBy_mo(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mp":
                adPage = myAdsRepository.filterAdsBy_mp(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mr":
                adPage = myAdsRepository.filterAdsBy_mr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ms":
                adPage = myAdsRepository.filterAdsBy_ms(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mt":
                adPage = myAdsRepository.filterAdsBy_mt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mu":
                adPage = myAdsRepository.filterAdsBy_mu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mv":
                adPage = myAdsRepository.filterAdsBy_mv(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mw":
                adPage = myAdsRepository.filterAdsBy_mw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mx":
                adPage = myAdsRepository.filterAdsBy_mx(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "my":
                adPage = myAdsRepository.filterAdsBy_my(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "mz":
                adPage = myAdsRepository.filterAdsBy_mz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "na":
                adPage = myAdsRepository.filterAdsBy_na(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "nc":
                adPage = myAdsRepository.filterAdsBy_nc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ne":
                adPage = myAdsRepository.filterAdsBy_ne(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ng":
                adPage = myAdsRepository.filterAdsBy_ng(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ni":
                adPage = myAdsRepository.filterAdsBy_ni(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "nl":
                adPage = myAdsRepository.filterAdsBy_nl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "no":
                adPage = myAdsRepository.filterAdsBy_no(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "np":
                adPage = myAdsRepository.filterAdsBy_np(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "nr":
                adPage = myAdsRepository.filterAdsBy_nr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "nu":
                adPage = myAdsRepository.filterAdsBy_nu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "nz":
                adPage = myAdsRepository.filterAdsBy_nz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "om":
                adPage = myAdsRepository.filterAdsBy_om(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pa":
                adPage = myAdsRepository.filterAdsBy_pa(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pe":
                adPage = myAdsRepository.filterAdsBy_pe(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pf":
                adPage = myAdsRepository.filterAdsBy_pf(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pg":
                adPage = myAdsRepository.filterAdsBy_pg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ph":
                adPage = myAdsRepository.filterAdsBy_ph(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pk":
                adPage = myAdsRepository.filterAdsBy_pk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pl":
                adPage = myAdsRepository.filterAdsBy_pl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pm":
                adPage = myAdsRepository.filterAdsBy_pm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pn":
                adPage = myAdsRepository.filterAdsBy_pn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pr":
                adPage = myAdsRepository.filterAdsBy_pr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ps":
                adPage = myAdsRepository.filterAdsBy_ps(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pt":
                adPage = myAdsRepository.filterAdsBy_pt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "pw":
                adPage = myAdsRepository.filterAdsBy_pw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "py":
                adPage = myAdsRepository.filterAdsBy_py(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "qa":
                adPage = myAdsRepository.filterAdsBy_qa(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "re":
                adPage = myAdsRepository.filterAdsBy_re(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ro":
                adPage = myAdsRepository.filterAdsBy_ro(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "rs":
                adPage = myAdsRepository.filterAdsBy_rs(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ru":
                adPage = myAdsRepository.filterAdsBy_ru(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "rw":
                adPage = myAdsRepository.filterAdsBy_rw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sa":
                adPage = myAdsRepository.filterAdsBy_sa(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sb":
                adPage = myAdsRepository.filterAdsBy_sb(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sc":
                adPage = myAdsRepository.filterAdsBy_sc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sd":
                adPage = myAdsRepository.filterAdsBy_sd(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "se":
                adPage = myAdsRepository.filterAdsBy_se(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sg":
                adPage = myAdsRepository.filterAdsBy_sg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sh":
                adPage = myAdsRepository.filterAdsBy_sh(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "si":
                adPage = myAdsRepository.filterAdsBy_si(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sj":
                adPage = myAdsRepository.filterAdsBy_sj(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sk":
                adPage = myAdsRepository.filterAdsBy_sk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sl":
                adPage = myAdsRepository.filterAdsBy_sl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sm":
                adPage = myAdsRepository.filterAdsBy_sm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sn":
                adPage = myAdsRepository.filterAdsBy_sn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "so":
                adPage = myAdsRepository.filterAdsBy_so(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sr":
                adPage = myAdsRepository.filterAdsBy_sr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ss":
                adPage = myAdsRepository.filterAdsBy_ss(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "st":
                adPage = myAdsRepository.filterAdsBy_st(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sv":
                adPage = myAdsRepository.filterAdsBy_sv(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sx":
                adPage = myAdsRepository.filterAdsBy_sx(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sy":
                adPage = myAdsRepository.filterAdsBy_sy(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "sz":
                adPage = myAdsRepository.filterAdsBy_sz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tc":
                adPage = myAdsRepository.filterAdsBy_tc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "td":
                adPage = myAdsRepository.filterAdsBy_td(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tg":
                adPage = myAdsRepository.filterAdsBy_tg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "th":
                adPage = myAdsRepository.filterAdsBy_th(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tj":
                adPage = myAdsRepository.filterAdsBy_tj(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tk":
                adPage = myAdsRepository.filterAdsBy_tk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tl":
                adPage = myAdsRepository.filterAdsBy_tl(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tm":
                adPage = myAdsRepository.filterAdsBy_tm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tn":
                adPage = myAdsRepository.filterAdsBy_tn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "to":
                adPage = myAdsRepository.filterAdsBy_to(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tr":
                adPage = myAdsRepository.filterAdsBy_tr(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tt":
                adPage = myAdsRepository.filterAdsBy_tt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tv":
                adPage = myAdsRepository.filterAdsBy_tv(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tw":
                adPage = myAdsRepository.filterAdsBy_tw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "tz":
                adPage = myAdsRepository.filterAdsBy_tz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ua":
                adPage = myAdsRepository.filterAdsBy_ua(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ug":
                adPage = myAdsRepository.filterAdsBy_ug(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "us":
                adPage = myAdsRepository.filterAdsBy_us(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "uy":
                adPage = myAdsRepository.filterAdsBy_uy(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "uz":
                adPage = myAdsRepository.filterAdsBy_uz(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "va":
                adPage = myAdsRepository.filterAdsBy_va(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "vc":
                adPage = myAdsRepository.filterAdsBy_vc(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ve":
                adPage = myAdsRepository.filterAdsBy_ve(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "vg":
                adPage = myAdsRepository.filterAdsBy_vg(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "vi":
                adPage = myAdsRepository.filterAdsBy_vi(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "vn":
                adPage = myAdsRepository.filterAdsBy_vn(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "vu":
                adPage = myAdsRepository.filterAdsBy_vu(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "wf":
                adPage = myAdsRepository.filterAdsBy_wf(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ws":
                adPage = myAdsRepository.filterAdsBy_ws(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "xk":
                adPage = myAdsRepository.filterAdsBy_xk(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "ye":
                adPage = myAdsRepository.filterAdsBy_ye(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "yt":
                adPage = myAdsRepository.filterAdsBy_yt(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "za":
                adPage = myAdsRepository.filterAdsBy_za(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "zm":
                adPage = myAdsRepository.filterAdsBy_zm(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
            case "zw":
                adPage = myAdsRepository.filterAdsBy_zw(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;

            default:
                adPage = myAdsRepository.filterAdsBy_test(longitude, latitude, radius, pageable, keyword, expiryMillis);
                break;
        }


//        System.out.println("Current Time in Milli " + Constants.getTimeStampInMillis());
//        System.out.println("Current country_code " + country_code);
        return adPage;
    }

}
