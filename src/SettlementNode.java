public class SettlementNode {
    private int playerNum;
    private int development;
    public SettlementNode(){}
    public int getPlayer(){
        return playerNum;
    }
    public int getDevelopment(){
        return development;
    }
    public void setPlayer(int n){
        playerNum=n;
    }

    public void setDevelopment(int n){
        development=n;
    }
}
