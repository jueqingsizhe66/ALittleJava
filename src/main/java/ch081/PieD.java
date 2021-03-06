package ch081;


//因为RemV SubstV Bot Top四个类极度相似，于是继续抽象。
interface PieVistor1{
	PieD forBot();
	PieD forTop(Object t,PieD r);
}

class RemV implements PieVistor1{
	Object o;
	public RemV(Object _o) {
		// TODO Auto-generated constructor stub
		this.o = _o;
	}
	//为什么要改为Public???
	public PieD forBot(){
		return new Bot();
	}
	//改用Object即可
	public PieD forTop(Object t, PieD r){ //不能用int
		if(o.equals(t)){
			return r.accept(this); //this指代Remv对象
		}else{
			return new Top(t,r.accept(this));
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
	public PieD forBot()
	{
		return new Bot();
	}
	public PieD forTop(Object t,PieD r){
		if(o.equals(t)){
			return new Top(n,r.accept(this));
		}else{
			return new Top(t,r.accept(this));
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
	public PieD forBot() {
		// TODO Auto-generated method stub
		return new Bot();
	}

	@Override
	public PieD forTop(Object t, PieD r) {
		// TODO Auto-generated method stub
		if( 0 == c)
		{
			return new Top(t,r);
		}else{
			if(o.equals(t)){
				return new Top(n,r.accept(new LtSubstV(c-1,n,o)));
			}else{
				return new Top(t,r.accept(this));
			}
		}
	}
	
}
public abstract class PieD { //比萨饼
	
	//定义两个访问者
	//RemV remFn = new RemV();
	//SubstV subFn = new SubstV();
	abstract PieD accept(PieVistor1 ask);
}

class Bot extends PieD{

	@Override
	PieD accept(PieVistor1 ask) {
		// TODO Auto-generated method stub
		return ask.forBot();
	}

	public String toString() {
		return "new " + getClass().getName() ;
	}

}

class Top extends PieD{

	Object t;
	PieD r;
	public Top(Object t,PieD r) {
		// TODO Auto-generated constructor stub
		this.t = t;
		this.r = r;
	}
	@Override
	PieD accept(PieVistor1 ask) {
		// TODO Auto-generated method stub
		return ask.forTop(t, r);
	}
	public String toString() {
		return "new " + getClass().getName() + "(" + t + ", " +r + ")";
	}

}

