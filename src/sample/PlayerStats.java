package sample;

public class PlayerStats
{
    private int biodiversity;
    private int money;
    private int pollution;
    private int publicSupport;

    public PlayerStats(int biodiversity, int money, int pollution, int publicSupport)
    {
        this.biodiversity = biodiversity;
        this.money = money;
        this.pollution = pollution;
        this.publicSupport = publicSupport;
    }

    public int getBiodiversity() {return biodiversity;}
    public int getMoney() {return money;}
    public int getPollution() {return pollution;}
    public int getPublicSupport() {return publicSupport;}
    public void setBiodiversity(int bio) {biodiversity = bio;}
    public void setMoney(int mon) {money = mon;}
    public void setPollution(int pol) {pollution = pol;}
    public void setPublicSupport(int sup) {publicSupport = sup;}
}
