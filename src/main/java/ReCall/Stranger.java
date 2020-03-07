package ReCall;

public class Stranger implements Callback {
    private Ye ye;
    public Stranger(Ye ye){
        this.ye =ye;
    }


    public void askQuestion(final String question){
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 陌生人调用小叶的方法，在这里注册会掉借口
                 * A类调用B的方法C
                 * 实现和继承都是一种子类的实现方法
                 */
                ye.accept(Stranger.this,question);
            }
        }).start();

        /**
         * 老王问完问题 挂掉电话就去出差了
         */
        play();
    }

    private void play() {
        System.out.println("叶老师：\"我先忙其他事情了，麻烦您到时候联系我\"");
    }

    @Override
    public void receive(String result) {
        System.out.println("小叶告诉陌生人的答案是:"+result);
    }
}
