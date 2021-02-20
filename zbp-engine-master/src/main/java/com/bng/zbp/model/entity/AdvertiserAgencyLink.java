package com.bng.zbp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "advertiser_agency_link", catalog = "zbp")
@Getter
@Setter
public class    AdvertiserAgencyLink extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertiser_id", nullable = false)
    private Advertiser advertiserId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agencyId;

}
