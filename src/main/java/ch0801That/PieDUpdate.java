package ch0801That;

public abstract class PieDUpdate { //比萨饼

    //定义两个访问者
    //RemV remFn = new RemV();
    //SubstV subFn = new SubstV();
    abstract PieDUpdate accept(PieVistor1 ask);
}
class Bot extends PieDUpdate {

    @Override
    PieDUpdate accept(PieVistor1 ask) {
        // TODO Auto-generated method stub
        return ask.forBot(this); // Interesting part, 通过this调用field
    }

    public String toString() {
        return "new " + getClass().getName()  ;
    }
}

class Top extends PieDUpdate {

    Object t;
    PieDUpdate r;
    public Top(Object t, PieDUpdate r) {
        // TODO Auto-generated constructor stub
        this.t = t;
        this.r = r;
    }
    @Override
    PieDUpdate accept(PieVistor1 ask) {
        // TODO Auto-generated method stub
        return ask.forTop(this);
    }
    public String toString() {
        return "new " + getClass().getName() + "(" + this.t + ", " + this.r + ")";
    }
}

//因为RemV SubstV Bot Top四个类极度相似，于是继续抽象。
interface PieVistor1{
    PieDUpdate forBot(Bot that);
    PieDUpdate forTop(Top that);
}

class RemV implements PieVistor1{
    Object o;
    public RemV(Object _o) {
        // TODO Auto-generated constructor stub
        this.o = _o;
    }
    //为什么要改为Public???
    public PieDUpdate forBot(Bot that){
        return new Bot();
    }
    //改用Object即可
    //public PieDUpdate forTop(Object t, PieDUpdate r){ //不能用int
     public PieDUpdate forTop(Top that){ //不能用int
        if(o.equals(that.t)){
            return that.r.accept(this); //this指代Remv对象
        }else{
            return new Top(that.t,that.r.accept(this));
        }
    }
}

class SubstV implements PieVistor1{
    Object n;
    Object o;
    public SubstV(Object _n, Object _o) {
        // TODO Auto-generated constructor stub
        this.n = _n;
        this.o = _o;
    }
    public PieDUpdate forBot(Bot that)
    {
        return new Bot();
    }
    public PieDUpdate forTop(Top that){
        if(o.equals(that.t)){
            return new Top(n,that.r.accept(this));
        }else{
            return new Top(that.t,that.r.accept(this));
        }
    }
}

class LtSubstV implements PieVistor1{

    int c; //次数
    Object n;
    Object o;
    public LtSubstV(int _c, Object _n, Object _o) {
        // TODO Auto-generated constructor stub
        this.c = _c;
        this.n = _n;
        this.o = _o;
    }
    @Override
    public PieDUpdate forBot(Bot that) {
        // TODO Auto-generated method stub
        return new Bot();
    }

    @Override
    public PieDUpdate forTop(Top that) {
        // TODO Auto-generated method stub
        if( 0 == c)
        {
            return new Top(that.t,that.r);
        }else{
            if(o.equals(that.t)){
                return new Top(n,that.r.accept(new LtSubstV(c-1,n,o)));
            }else{
                return new Top(that.t,that.r.accept(this));
            }
        }
    }

}
