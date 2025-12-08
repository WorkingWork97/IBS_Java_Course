package org.example.ThirdExercise;

public class JellyBean extends SweetPresent{
    private String jellySpecial;

    public JellyBean(String sweetName, float sweetWeight, float sweetPrice, String jellySpecial) {
        super(sweetName, sweetWeight, sweetPrice);
        this.jellySpecial = jellySpecial;
    }

    public void setJellySpecial(String jellySpecial) {
        this.jellySpecial = jellySpecial;
    }

    public String getJellySpecial() {
        return jellySpecial;
    }
    @Override
    public String toString(){
        return "SweetName: "+getSweetName()+"; SweetWeight: "+getSweetWeight()+"; SweetPrice:"+getSweetPrice()+"; JellySpecial: "+jellySpecial;
    }
}
