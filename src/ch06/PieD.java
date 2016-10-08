package ch06;



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


/*//删除指定鱼的方法
class RemFishV{
	PieD forBot(FishD f){
		return new Bot();
	}
	//不太明白
	PieD forTop(Object t,PieD r, FishD f){
		if(f.equals(t)){
			return r.remA(this,f);
		}else{
			return new Top(t,r.remA(f));
		}
	}
}

//删除指定的整数
class RemFishInt{
	PieD forBot(FishD f){
		return new Bot();
	}
	//不太明白
	PieD forTop(Object t,PieD r, Integer f){ //不能用int
		if(f.equals(t)){
			return r.remA(f);
		}else{
			return new Top(t,r.remA(f));
		}
	}
}*/

//RemFishV1 and RemFishInt具有相似的逻辑 于是归类

class RemV{
	PieD forBot(Object f){
		return new Bot();
	}
	//改用Object即可
	PieD forTop(Object t,PieD r, Object f){ //不能用int
		if(f.equals(t)){
			return r.remA(this,f); //this指代Remv对象
		}else{
			return new Top(t,r.remA(this,f));
		}
	}
}


/*//增加一个替换操作
class SubstFishV{
	PieD forBot(FishD n,FishD o)
	{
		return new Bot();
	}
	PieD forTop(Object t,PieD r,FishD n,FishD o){
		if(o.equals(t)){
			return new Top(n,r.substFish(new SubstFishV(),n,o));
		}else{
			return new Top(t,r.substFish(this,n,o));
		}
	}
}


class SubstIntV{
	PieD forBot(Integer n,Integer o)
	{
		return new Bot();
	}
	PieD forTop(Object t,PieD r,Integer n,Integer o){
		if(o.equals(t)){
			return new Top(n,r.substFish(n,o));
		}else{
			return new Top(t,r.substFish(n,o));
		}
	}
}
*/
class SubstV{
	PieD forBot(Object n,Object o)
	{
		return new Bot();
	}
	PieD forTop(Object t,PieD r,Object n,Object o){
		if(o.equals(t)){
			return new Top(n,r.substFish(this,n,o));
		}else{
			return new Top(t,r.substFish(this,n,o));
		}
	}
}

public abstract class PieD { //比萨饼
	
	//定义两个访问者
	//RemV remFn = new RemV();
	//SubstV subFn = new SubstV();
	abstract PieD remA(RemV remFn,Object o);
	abstract PieD substFish(SubstV subFn,Object n, Object o);
}

class Bot extends PieD{

	@Override
	PieD remA(RemV remFn,Object o) {
		// TODO Auto-generated method stub
		return remFn.forBot(o);
	}

	@Override
	PieD substFish(SubstV subFn,Object n, Object o) {
		// TODO Auto-generated method stub
		return subFn.forBot(n, o);
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
	PieD remA(RemV remFn,Object f) {
		// TODO Auto-generated method stub
		return remFn.forTop(t, r, f);
	}
	@Override
	PieD substFish(SubstV subFn,Object n, Object o) {
		// TODO Auto-generated method stub
		return subFn.forTop(t, r, n, o);
	}
	
}



