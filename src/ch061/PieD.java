package ch061;



//两个访问者类
abstract class FishD{
	public abstract boolean equals(Object o);
};

class AnchovyFish extends FishD{

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return (o instanceof AnchovyFish);
	}//凤尾鱼
	
}

class SalmonFish extends FishD{

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return(o instanceof SalmonFish);
	} //鲑鱼
	
}

class TunaFish extends FishD{

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return (o instanceof TunaFish);
	}//金枪鱼
	
}

//RemFishV1 and RemFishInt具有相似的逻辑 于是归类

class RemV{
	Object o;
	public RemV(Object _o) {
		// TODO Auto-generated constructor stub
		this.o = _o;
	}
	PieD forBot(Object t, PieD r){
		return new Bot(t,r);
	}
	//改用Object即可
	PieD forTop(Object t, PieD r){ //不能用int
		if(o.equals(t)){
			return r.remA(this); //this指代Remv对象
		}else{
			return new Top(o,r.remA(this));
		}
	}
}


class SubstV{
	Object n;
	Object o;
	public SubstV(Object _n, Object _o) {
		// TODO Auto-generated constructor stub
		this.n = _n;
		this.o = _o;
	}
	PieD forBot(Object t,PieD r)
	{
		return new Bot(t,r);
	}
	PieD forTop(Object t,PieD r){
		if(o.equals(t)){
			return new Top(n,r.substFish(this));
		}else{
			return new Top(t,r.substFish(this));
		}
	}
}

public abstract class PieD { //比萨饼
	
	//定义两个访问者
	//RemV remFn = new RemV();
	//SubstV subFn = new SubstV();
	abstract PieD remA(RemV remFn);
	abstract PieD substFish(SubstV subFn);
}

class Bot extends PieD{

	Object t;
	PieD r;
	public Bot(Object _t,PieD _r) {
		// TODO Auto-generated constructor stub
		this.t = _t;
		this.r = _r;
	}
	@Override
	PieD remA(RemV remFn) {
		// TODO Auto-generated method stub
		return remFn.forBot(t,r);
	}

	@Override
	PieD substFish(SubstV subFn) {
		// TODO Auto-generated method stub
		return subFn.forBot(t, r);
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
	PieD remA(RemV remFn) {
		// TODO Auto-generated method stub
		return remFn.forTop(t, r);
	}
	@Override
	PieD substFish(SubstV subFn) {
		// TODO Auto-generated method stub
		return subFn.forTop(t, r);
	}
	
}



