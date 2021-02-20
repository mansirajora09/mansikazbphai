package com.bng.zbp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mansi Rajora
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date crdt;
    @Column(name = "created_by")
    private Long createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_on")
    private Date lastModifiedOn;

    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @Column(name = "is_active")
    private Boolean isActive = true;

}