package ReCall;

public class Test {
    public static void main(String[] args) {
        Ye zhaoliang=new Ye();
        // Wang and Stranger 内心都有zhaoliang， Ye内心都知道怎么回答问题
        // Wang and Stranger 都具有callback属性，等待被回叫(backcall)
        Wang xiaodong= new Wang(zhaoliang);
        Stranger stranger = new Stranger(zhaoliang);

        /**
         * 老王问小叶问题
         */
        xiaodong.askQuestion("1 + 1 = ?");
        stranger.askQuestion("1 + 1 = ?");

    }
}
