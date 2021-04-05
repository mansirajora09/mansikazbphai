package com.bng.zbp.model.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Getter
@Setter
public class CampaignRequest {
    Long sessionId;
    Integer adsSize;
    String userAgent;
    String ip;
    Boolean redirect;
    String txnId;
    Boolean isCampaign;
    String msisdn;
    String pubId;
    Integer height;
    Integer width;
    Boolean square;
    Boolean vertical;
    Boolean horizontal;
    String device;
    String camptype;

    public CampaignRequest() {
    }

    public CampaignRequest(Long sessionId, Integer adsSize, String userAgent, String ip,
                           Boolean redirect, String txnId,
                           Boolean isCampaign, String msisdn, String pubId, Integer height, Integer width,
                           Boolean square, Boolean vertical, Boolean horizontal, String device,String camptype) {
        this.sessionId = sessionId;
        this.adsSize = adsSize;
        this.userAgent = userAgent;
        this.ip = ip;
        this.redirect = redirect;
        this.txnId = txnId;
        this.isCampaign = isCampaign;
        this.msisdn = msisdn;
        this.pubId = pubId;
        this.height = height;
        this.width = width;
        this.square = square;
        this.vertical = vertical;
        this.horizontal = horizontal;
        this.device = device;
        this.camptype=camptype;
    }
}
