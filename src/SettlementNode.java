public class SettlementNode {
    private int playerNum;
    private int development;
    public SettlementNode(){}
    public int getPlayer(){
        return playerNum;
    }
    //0,1,2,3,4,5
    public int getDevelopment(){
        return development;
    }
    //0,1,2
    public void setPlayer(int n){
        playerNum=n;
    }

    public void setDevelopment(int n){
        development=n;
    }
}
