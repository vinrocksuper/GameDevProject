package sample;

public class Question {
    private String prompt;
    private String yes;
    private String no;
    private int yPollution;
    private int yMoney;
    private int ySupport;
    private int yBiodiversity;
    private int nPollution;
    private int nMoney;
    private int nSupport;
    private int nBiodiversity;

    public Question(String p,String y, String n, int yP, int yM, int yS, int yB, int nP, int nM, int nS, int nB)
    {
        prompt = p;
        yes =y;
        no = n;
        yPollution = yP;
        yMoney = yM;
        ySupport = yS;
        yBiodiversity = yB;
        nPollution = nP;
        nMoney = nM;
        nSupport = nS;
        nBiodiversity = nB;
    }

    public String getPrompt() {
        return prompt;
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }

    public int getyPollution() {
        return yPollution;
    }

    public int getyMoney() {
        return yMoney;
    }

    public int getySupport() {
        return ySupport;
    }

    public int getyBiodiversity() {
        return yBiodiversity;
    }

    public int getnPollution() {
        return nPollution;
    }

    public int getnMoney() {
        return nMoney;
    }

    public int getnSupport() {
        return nSupport;
    }

    public int getnBiodiversity() {
        return nBiodiversity;
    }
}
