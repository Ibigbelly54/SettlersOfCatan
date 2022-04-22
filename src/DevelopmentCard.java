public class DevelopmentCard {

    private String resource;
    private int playerPossesion; //0-3

    public DevelopmentCard(String str) {
        resource = str;
        playerPossesion = -1;
    }
    public void setPos(int num) {
        playerPossesion = num;
    }
    public int getPlayerPossesion() {
        return playerPossesion;
    }
    public String getResource() { return resource; }
}
