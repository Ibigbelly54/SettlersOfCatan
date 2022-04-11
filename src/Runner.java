public class Runner {

    private static StartFrame output;
    private static BuildFrame build;
    public static void main(String[] args)
    {
        output = new StartFrame();
        build= new BuildFrame();

    }
    static StartFrame returnStartFrame(){
        return output;
    }


}
