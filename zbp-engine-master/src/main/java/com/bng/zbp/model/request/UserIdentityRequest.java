package com.bng.zbp.model.request;

import java.util.Date;

/**
 * @Author Mansi Rajora
 */
public class UserIdentityRequest {
    private final Long userId;
    private final int userTypeId;
    private final String userName;
    private final String lastName;
    private final String vendorId;
    private final Date crdt;
    private final String emailId;
    private Boolean isSubUser;


    public UserIdentityRequest(Long userId, int userTypeId, String userName, String lastName, String vendorId, Date crdt, String emailId,Boolean isSubUser) {
        this.userId = userId;
        this.userTypeId = userTypeId;
        this.userName = userName;
        this.lastName = lastName;
        this.vendorId = vendorId;
        this.crdt = crdt;
        this.emailId = emailId;
        this.isSubUser=isSubUser;
    }

    public Long getUserId() {
        return userId;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getVendorId() {
        return vendorId;
    }

    public Date getCrdt() {
        return crdt;
    }

    public String getEmailId() {
        return emailId;
    }

	public Boolean getIsSubUser() {
		return isSubUser;
	}

	public void setIsSubUser(Boolean isSubUser) {
		this.isSubUser = isSubUser;
	}
    
}
