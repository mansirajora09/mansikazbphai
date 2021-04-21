package com.bng.zbp.model.entity;

import com.bng.zbp.model.enums.CampaignType;
import com.bng.zbp.model.enums.FlowType;
import com.bng.zbp.model.enums.MediaType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * @author Mansi Rajora
 */
@Entity
@Table(name = "black_out_hours", catalog = "zbp")
@Getter
@Setter
public class BlackoutHours extends BaseEntity {
  
    @Column(name = "start_hour")
    private String start_hour;
    @Column(name = "end_hour")
    private String end_hour;
    @Column(name = "campaing_id")
    private Long campaing_id;

   
       
    
}
