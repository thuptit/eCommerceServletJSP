/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author thunv
 */
public class RequestOrderDto {
    public String ids;
    public int amount;
    public int status;
    public float totalPrice;
    public String address;
    public String typeShip;
    public int typePayment;
    public int customerId;
    public String bankid;
    public String bankName;
    public String expDate;
    public String typeCard;
    public String number;

    public RequestOrderDto() {
    }

    public RequestOrderDto(String ids, int amount, int status, float totalPrice, String address, String typeShip, int typePayment, int customerId, String bankid, String bankName, String expDate, String typeCard, String number) {
        this.ids = ids;
        this.amount = amount;
        this.status = status;
        this.totalPrice = totalPrice;
        this.address = address;
        this.typeShip = typeShip;
        this.typePayment = typePayment;
        this.customerId = customerId;
        this.bankid = bankid;
        this.bankName = bankName;
        this.expDate = expDate;
        this.typeCard = typeCard;
        this.number = number;
    }
    
}
