package com.rizzotti.restclient.dto;

import java.math.BigDecimal;

public class Payment {

    String currency;
    BigDecimal amount;
    Customer originator;
    Customer beneficiary;
    Account sender;
    Account receiver;

    public Payment(String currency, BigDecimal amount, Customer originator, Customer beneficiary, Account sender, Account receiver) {
        this.currency = currency;
        this.amount = amount;
        this.originator = originator;
        this.beneficiary = beneficiary;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Customer getOriginator() {
        return originator;
    }

    public void setOriginator(Customer originator) {
        this.originator = originator;
    }

    public Customer getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Customer beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }
}
