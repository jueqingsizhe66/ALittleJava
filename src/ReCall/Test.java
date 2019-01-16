package ReCall;

public class Test {
    public static void main(String[] args) {
        Ye zhaoliang=new Ye();
        Wang xiaodong= new Wang(zhaoliang);

        /**
         * 老王问小叶问题
         */
        xiaodong.askQuestion("1 + 1 = ?");

    }
}
