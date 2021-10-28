package com.example.hf4_orszaglista;

public class Currency {
    private int flag;
    private String currencyName;
    private String currencyCode;
    private double buyRate;
    private double sellRate;

    Currency(int pFlag, String pName, String pCurrencyCode, double pSellRate, Double pBuyRate){
        this.currencyCode=pCurrencyCode;
        this.flag = pFlag;
        this.currencyName = pName;
        this.buyRate = pBuyRate;
        this.sellRate = pSellRate;
    }

    public int getFlag() {
        return flag;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getBuyRate() {
        return buyRate;
    }

    public double getSellRate() {
        return sellRate;
    }
}
