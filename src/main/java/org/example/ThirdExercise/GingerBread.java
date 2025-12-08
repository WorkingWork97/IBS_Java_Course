package org.example.ThirdExercise;

public class GingerBread extends SweetPresent{
    private String gingerBreadSpecial;

    public GingerBread(String sweetName, float sweetWeight, float sweetPrice, String gingerBreadSpecial) {
        super(sweetName, sweetWeight, sweetPrice);
        this.gingerBreadSpecial = gingerBreadSpecial;
    }

    public void setGingerBreadSpecial(String gingerBreadSpecial) {
        this.gingerBreadSpecial = gingerBreadSpecial;
    }

    public String getGingerBreadSpecial() {
        return gingerBreadSpecial;
    }
    @Override
    public String toString(){
        return "SweetName: "+getSweetName()+"; SweetWeight: "+getSweetWeight()+"; SweetPrice:"+getSweetPrice()+"; GingerBreadSpecial: "+gingerBreadSpecial;
    }
}
