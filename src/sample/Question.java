package sample;

public class Question {
    private String scenario;
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

    public Question(String s,String y, String n, int yP, int yM, int yS, int yB, int nP, int nM, int nS, int nB)
    {
        scenario = s;
        yes = y;
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

    public String getScenario() {
        return scenario;
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
    public static Question createQuestion(String[] info)
    {
        String sc = info[0];
        String yP = info[1];
        String nP = info[2];
        int yPol = Integer.parseInt(info[3]);
        int yMon = Integer.parseInt(info[4]);
        int ySup = Integer.parseInt(info[5]);
        int yBio = Integer.parseInt(info[6]);
        int nPol = Integer.parseInt(info[7]);
        int nMon = Integer.parseInt(info[8]);
        int nSup = Integer.parseInt(info[9]);
        int nBio = Integer.parseInt(info[10]);
        return new Question(sc,yP,nP,yPol,yMon,ySup,yBio,nPol,nMon,nSup,nBio);
}

    public void setText(String txt) { scenario = txt; }
}
