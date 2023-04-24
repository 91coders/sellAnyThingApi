package com.sellAnyThing.sellAnyThing.repository;

import com.sellAnyThing.sellAnyThing.model.MyAdsModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MyAdsRepository extends JpaRepository<MyAdsModel, Long> {

    @Query(value = "SELECT * FROM public.testing_table WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) " +
            " AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) " +
            "ORDER BY testing_table.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC",
            nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_test(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);
    //Todo need to pass 'keyword:*' from api

    @Query(value = "SELECT * FROM public.testing_table WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY testing_table.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_test(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);


    //TODO below method for home Dashboard ads

    @Query(value = "SELECT * FROM public.ad WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ad.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ad(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ae WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ae.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ae(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.af WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY af.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_af(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ag WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ag.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ag(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ai WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ai.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ai(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.al WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY al.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_al(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.am WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY am.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_am(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.an WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY an.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_an(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ao WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ao.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ao(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.aq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY aq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_aq(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ar WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ar.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ar(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.as WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY as.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_as(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.at WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY at.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_at(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.au WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY au.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_au(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.aw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY aw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_aw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.az WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY az.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_az(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ba WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ba.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ba(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bb(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bd(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.be WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY be.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_be(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bf(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bi(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bj(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bo(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.br WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY br.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_br(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bs WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bs.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bs(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.by WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY by.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_by(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.bz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY bz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_bz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ca WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ca.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ca(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cd(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cf(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ch WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ch.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ch(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ci WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ci.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ci(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ck WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ck.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ck(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.co WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY co.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_co(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cv(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cx(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cy(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.cz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY cz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_cz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.de WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY de.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_de(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.dj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY dj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_dj(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.dk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY dk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_dk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.dm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY dm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_dm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.do WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY do.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_do(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.dz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY dz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_dz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ec WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ec.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ec(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ee WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ee.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ee(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.eg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY eg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_eg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.eh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY eh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_eh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.er WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY er.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_er(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.es WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY es.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_es(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.et WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY et.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_et(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fi(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fj(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fo(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.fr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY fr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_fr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ga WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ga.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ga(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gb(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gd(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ge WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ge.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ge(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gi(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gq(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.gy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY gy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_gy(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.hk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY hk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_hk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.hn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY hn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_hn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.hr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY hr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_hr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ht WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ht.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ht(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.hu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY hu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_hu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.id WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY id.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_id(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ie WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ie.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ie(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.il WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY il.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_il(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.im WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY im.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_im(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.in WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY in.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_in(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.io WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY io.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_io(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.iq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY iq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_iq(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ir WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ir.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ir(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.is WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY is.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_is(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.it WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY it.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_it(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.je WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY je.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_je(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.jm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY jm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_jm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.jo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY jo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_jo(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.jp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY jp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_jp(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ke WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ke.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ke(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ki WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ki.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ki(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.km WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY km.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_km(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kp(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ky WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ky.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ky(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.kz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY kz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_kz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.la WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY la.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_la(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lb(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.li WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY li.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_li(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ls WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ls.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ls(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.lv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY lv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_lv(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ly WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ly.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ly(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ma WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ma.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ma(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.md WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY md.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_md(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.me WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY me.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_me(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mf(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ml WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ml.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ml(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mo(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mp(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ms WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ms.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ms(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mv(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mx(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.my WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY my.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_my(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.mz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY mz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_mz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.na WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY na.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_na(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.nc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY nc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_nc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ne WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ne.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ne(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ng WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ng.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ng(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ni WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ni.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ni(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.nl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY nl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_nl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.no WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY no.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_no(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.np WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY np.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_np(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.nr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY nr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_nr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.nu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY nu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_nu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.nz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY nz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_nz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.om WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY om.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_om(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pa(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pe WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pe.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pe(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pf(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ph WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ph.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ph(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ps WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ps.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ps(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.pw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY pw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_pw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.py WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY py.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_py(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.qa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY qa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_qa(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.re WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY re.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_re(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ro WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ro.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ro(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.rs WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY rs.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_rs(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ru WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ru.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ru(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.rw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY rw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_rw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sa(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sb(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sd(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.se WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY se.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_se(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sh(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.si WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY si.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_si(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sj(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.so WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY so.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_so(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ss WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ss.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ss(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.st WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY st.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_st(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sv(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sx(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sy(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.sz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY sz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_sz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.td WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY td.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_td(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.th WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY th.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_th(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tj(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tl(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.to WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY to.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_to(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tr(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tv(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.tz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY tz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_tz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ua WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ua.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ua(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ug WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ug.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ug(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.us WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY us.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_us(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.uy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY uy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_uy(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.uz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY uz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_uz(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.va WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY va.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_va(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.vc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY vc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_vc(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ve WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ve.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ve(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.vg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY vg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_vg(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.vi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY vi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_vi(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.vn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY vn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_vn(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.vu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY vu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_vu(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.wf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY wf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_wf(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ws WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ws.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ws(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.xk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY xk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_xk(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.ye WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY ye.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_ye(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.yt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY yt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_yt(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.za WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY za.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_za(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.zm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY zm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_zm(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);

    @Query(value = "SELECT * FROM public.zw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_expiry > (:currentMilli) ORDER BY zw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> homeSearch_zw(Double longitude, Double latitude, Long radius, Pageable pageable, String currentMilli);


    //TODO below filter ads by keywords methods


    @Query(value = "SELECT * FROM public.ad WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ad.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ad(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ae WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ae.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ae(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.af WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY af.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_af(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ag WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ag.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ag(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ai WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ai.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ai(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.al WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY al.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_al(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.am WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY am.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_am(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.an WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY an.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_an(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ao WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ao.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ao(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.aq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY aq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_aq(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ar WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ar.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ar(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.as WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY as.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_as(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.at WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY at.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_at(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.au WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY au.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_au(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.aw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY aw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_aw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.az WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY az.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_az(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ba WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ba.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ba(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bb(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bd(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.be WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY be.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_be(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bf(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bi(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bj(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bo(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.br WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY br.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_br(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bs WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bs.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bs(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.by WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY by.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_by(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.bz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY bz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_bz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ca WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ca.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ca(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cd(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cf(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ch WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ch.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ch(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ci WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ci.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ci(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ck WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ck.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ck(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.co WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY co.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_co(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cv(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cx(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cy(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.cz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY cz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_cz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.de WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY de.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_de(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.dj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY dj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_dj(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.dk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY dk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_dk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.dm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY dm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_dm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.do WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY do.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_do(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.dz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY dz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_dz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ec WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ec.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ec(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ee WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ee.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ee(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.eg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY eg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_eg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.eh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY eh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_eh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.er WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY er.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_er(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.es WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY es.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_es(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.et WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY et.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_et(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fi(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fj(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fo(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.fr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY fr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_fr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ga WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ga.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ga(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gb(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gd(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ge WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ge.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ge(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gi(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gq(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.gy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY gy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_gy(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.hk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY hk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_hk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.hn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY hn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_hn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.hr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY hr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_hr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ht WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ht.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ht(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.hu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY hu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_hu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.id WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY id.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_id(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ie WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ie.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ie(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.il WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY il.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_il(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.im WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY im.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_im(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.in WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY in.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_in(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.io WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY io.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_io(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.iq WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY iq.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_iq(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ir WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ir.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ir(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.is WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY is.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_is(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.it WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY it.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_it(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.je WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY je.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_je(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.jm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY jm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_jm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.jo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY jo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_jo(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.jp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY jp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_jp(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ke WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ke.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ke(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ki WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ki.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ki(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.km WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY km.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_km(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kp(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ky WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ky.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ky(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.kz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY kz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_kz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.la WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY la.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_la(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lb(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.li WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY li.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_li(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ls WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ls.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ls(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.lv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY lv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_lv(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ly WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ly.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ly(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ma WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ma.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ma(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.md WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY md.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_md(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.me WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY me.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_me(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mf(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ml WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ml.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ml(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mo WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mo.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mo(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mp WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mp.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mp(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ms WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ms.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ms(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mv(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mx(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.my WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY my.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_my(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.mz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY mz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_mz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.na WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY na.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_na(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.nc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY nc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_nc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ne WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ne.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ne(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ng WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ng.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ng(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ni WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ni.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ni(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.nl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY nl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_nl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.no WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY no.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_no(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.np WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY np.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_np(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.nr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY nr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_nr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.nu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY nu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_nu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.nz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY nz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_nz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.om WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY om.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_om(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pa(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pe WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pe.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pe(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pf(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ph WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ph.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ph(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ps WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ps.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ps(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.pw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY pw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_pw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.py WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY py.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_py(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.qa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY qa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_qa(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.re WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY re.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_re(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ro WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ro.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ro(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.rs WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY rs.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_rs(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ru WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ru.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ru(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.rw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY rw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_rw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sa WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sa.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sa(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sb WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sb.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sb(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sd WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sd.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sd(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.se WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY se.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_se(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sh WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sh.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sh(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.si WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY si.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_si(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sj(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.so WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY so.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_so(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ss WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ss.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ss(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.st WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY st.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_st(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sv(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sx WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sx.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sx(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sy(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.sz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY sz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_sz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.td WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY td.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_td(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.th WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY th.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_th(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tj WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tj.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tj(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tl WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tl.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tl(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.to WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY to.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_to(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tr WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tr.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tr(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tv WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tv.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tv(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.tz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY tz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_tz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ua WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ua.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ua(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ug WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ug.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ug(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.us WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY us.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_us(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.uy WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY uy.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_uy(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.uz WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY uz.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_uz(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.va WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY va.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_va(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.vc WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY vc.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_vc(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ve WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ve.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ve(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.vg WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY vg.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_vg(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.vi WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY vi.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_vi(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.vn WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY vn.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_vn(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.vu WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY vu.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_vu(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.wf WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY wf.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_wf(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ws WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ws.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ws(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.xk WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY xk.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_xk(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.ye WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY ye.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_ye(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.yt WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY yt.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_yt(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.za WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY za.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_za(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.zm WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY zm.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_zm(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

    @Query(value = "SELECT * FROM public.zw WHERE ST_DWithin(ad_latlong, ST_SetSRID(ST_Point(:longitude, :latitude), 4326), :radius) AND ad_combo @@ to_tsquery('simple', (:keyword)) AND ad_expiry > (:currentMilli) ORDER BY zw.ad_latlong  <-> ST_SetSRID(ST_Point(:longitude, :latitude),4326), ad_campaign_price DESC, published_on DESC", nativeQuery = true)
    Page<MyAdsModel> filterAdsBy_zw(Double longitude, Double latitude, Long radius, Pageable pageable, String keyword, String currentMilli);

}
