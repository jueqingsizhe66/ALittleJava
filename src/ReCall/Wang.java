package ReCall;

public class Wang implements Callback{
    /**
     * 小叶的对象引用 步骤二
     */
    private Ye ye;

    /**
     * 老王的构造方法，带有小叶的手机号
     * @param ye
     */
    public Wang(Ye ye) {
        this.ye = ye;
    }

    /**
     * 老王通过这个方法问小叶问题
     * @param question
     */
    public void askQuestion(final String question){
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 老王调用小叶的方法，在这里注册会掉借口
                 * A类调用B的方法C
                 * 实现和继承都是一种子类的实现方法
                 */
                ye.executeMessage(Wang.this,question);
            }
        }).start();

        /**
         * 老王问完问题 挂掉电话就去出差了
         */
        play();
    }

    private void play() {
        System.out.println("我要出差了");
    }

    @Override
    public void accept(String result) {
        System.out.println("小叶告诉小王的答案时-->"+result);
    }
}
