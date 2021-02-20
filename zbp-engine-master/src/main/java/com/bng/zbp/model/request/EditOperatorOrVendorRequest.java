package com.bng.zbp.model.request;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Author Mansi Rajora
 */

public class EditOperatorOrVendorRequest extends CreateOperatorOrVendorRequest {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("is_deleted")
    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
