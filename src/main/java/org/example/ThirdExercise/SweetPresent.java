package org.example.ThirdExercise;

public class SweetPresent {
    private String sweetName;
    private float sweetWeight;
    private float sweetPrice;

    public SweetPresent(String sweetName, float sweetWeight, float sweetPrice) {
        this.sweetName = sweetName;
        this.sweetWeight = sweetWeight;
        this.sweetPrice = sweetPrice;
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

    public void setSweetName(String sweetName) {
        this.sweetName = sweetName;
    }

    public void setSweetWeight(float sweetWeight) {
        this.sweetWeight = sweetWeight;
    }

    public void setSweetPrice(float sweetPrice) {
        this.sweetPrice = sweetPrice;
    }

    @Override
    public String toString(){
        return "SweetName: "+sweetName+"; SweetWeight: "+sweetWeight+"; SweetPrice:"+sweetPrice;
    }
}
