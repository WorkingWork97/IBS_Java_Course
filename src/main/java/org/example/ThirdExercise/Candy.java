package org.example.ThirdExercise;

public class Candy extends SweetPresent {
    private String candySpecial;

    public Candy(String sweetName, float sweetWeight, float sweetPrice, String candySpecial) {
        super(sweetName, sweetWeight, sweetPrice);
        this.candySpecial = candySpecial;
    }

    public void setCandySpecial(String candySpecial) {
        this.candySpecial = candySpecial;
    }

    public String getCandySpecial() {
        return candySpecial;
    }
    @Override
    public String toString(){
        return "SweetName: "+getSweetName()+"; SweetWeight: "+getSweetWeight()+"; SweetPrice:"+getSweetPrice()+"; CandySpecial: "+candySpecial;
    }
}
