package com.bng.zbp.model.response;


import lombok.Getter;
import lombok.Setter;

/**
 * @author Mansi Rajora
 */
@Getter
@Setter
public class LoanDataResponseObject {
    private int balance;
    private String unit;

    public LoanDataResponseObject() {
    }

    public LoanDataResponseObject(int balance, String unit) {
        this.balance = balance;
        this.unit = unit;
    }
}
