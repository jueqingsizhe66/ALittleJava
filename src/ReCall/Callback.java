package ReCall;

public interface Callback {
    /**
     * 小叶知道答案时调用的函数，然后告诉老王，也就是回调函数
     * @param result
     */
    public void receive(String result);
}
