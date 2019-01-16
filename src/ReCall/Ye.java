package ReCall;

public class Ye {

    /**
     *  步骤3
     * @param callback
     * @param question
     */
    public void executeMessage(Callback callback, String question){
        System.out.println("老王的问题--->" + question);

        /**
         * 小叶办自己的事情,可能隔了一天
         */
        for (int i = 0; i < 10000; i++) {

        }

        /**
         * 小叶办完事情后，想到了答案
         */
        String result = "答案时2";

        /**
         * 于是就打电话告诉老王，调用老王的方法
         * 相当于B类反过来调用A类的方法
         */
        callback.accept(result);
    }
}
