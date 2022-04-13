public class DevelopmentCard {

    private String resource;
    private int playerPossesion;

    public DevelopmentCard(String str) {
        resource = str;
        playerPossesion = 0;
    }
    public void setPos(int num) {
        playerPossesion = num;
    }
    public int getPlayerPossesion() {
        return playerPossesion;
    }
    public String getResource() { return resource; }
}
