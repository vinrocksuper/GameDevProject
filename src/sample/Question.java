package sample;

public class Question {
    private int qPol;
    private int qMon;
    private int qSup;


    private int qBio;
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

    public Question(int x, int a, int z, int b,String s,String y, String n, int yP, int yM, int yS, int yB, int nP, int nM, int nS, int nB)
    {
        qPol = x;
        qMon = a;
        qSup = z;
        qBio = b;
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
    public int getqPol() {
        return qPol;
    }

    public int getqMon() {
        return qMon;
    }

    public int getqSup() {
        return qSup;
    }

    public int getqBio() {
        return qBio;
    }

    public static Question createQuestion(String[] info)
    {
        int a = Integer.parseInt(info[0]);
        int b = Integer.parseInt(info[1]);
        int c = Integer.parseInt(info[2]);
        int d = Integer.parseInt(info[3]);
        String sc = info[4];
        String yP = info[5];
        String nP = info[6];
        int yPol = Integer.parseInt(info[7]);
        int yMon = Integer.parseInt(info[8]);
        int ySup = Integer.parseInt(info[9]);
        int yBio = Integer.parseInt(info[10]);
        int nPol = Integer.parseInt(info[11]);
        int nMon = Integer.parseInt(info[12]);
        int nSup = Integer.parseInt(info[13]);
        int nBio = Integer.parseInt(info[14]);
        return new Question(a,b,c,d,sc,yP,nP,yPol,yMon,ySup,yBio,nPol,nMon,nSup,nBio);
}

    public void setText(String txt) { scenario = txt; }

    public String toString()
    {
        return this.getScenario();
    }

}
