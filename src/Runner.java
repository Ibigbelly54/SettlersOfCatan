public class Runner {

    private static StartFrame output;
    public static void main(String[] args)
    {
        output = new StartFrame();

    }
    static StartFrame returnStartFrame(){
        return output;
    }


}
