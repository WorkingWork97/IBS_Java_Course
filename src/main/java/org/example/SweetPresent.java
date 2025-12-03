package org.example;

public class SweetPresent {
    private String sweetName;
    private float sweetWeight;
    private float sweetPrice;
    private String sweetSpecialParam;

    public SweetPresent(String sweetName, float sweetWeight, float sweetPrice, String sweetSpecialParam) {
        this.sweetName = sweetName;
        this.sweetWeight = sweetWeight;
        this.sweetPrice = sweetPrice;
        this.sweetSpecialParam = sweetSpecialParam;
    }

    public String getSweetName() {
        return sweetName;
    }

    public float getSweetWeight() {
        return sweetWeight;
    }

    public float getSweetPrice() {
        return sweetPrice;
    }

    public String getSweetSpecialParam() {
        return sweetSpecialParam;
    }

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public void setSweetWeight(float sweetWeight) {
        this.sweetWeight = sweetWeight;
    }

    public void setSweetPrice(float sweetPrice) {
        this.sweetPrice = sweetPrice;
    }

    public void setSweetSpecialParam(String sweetSpecialParam) {
        this.sweetSpecialParam = sweetSpecialParam;
    }
    @Override
    public String toString(){
        return "SweetName: "+sweetName;
    }
}
