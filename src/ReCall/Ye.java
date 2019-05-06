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
        String result = "";
       if(callback instanceof Wang){
           result = "王先生，您要的答案是2";
       }else if (callback instanceof Stranger){

           /**
            * 小叶思考了一阵子，这是谁啊！不认识
            */
           for (int i = 0; i < 10000; i++) {

           }
           result = "不好意思 ， 有点忙";
       }else{
           result = "不明白你的问题";
       }

        /**
         * 于是就打电话告诉老王，调用老王的方法
         * 相当于B类反过来调用A类的方法
         */
        callback.accept(result);
    }
}
