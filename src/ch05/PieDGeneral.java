package ch05;



//删除指定鱼的方法
class RemFishV1{
	PieDGeneral forBot(FishD f){
		return new Bot1();
	}
	//不太明白
	PieDGeneral forTop(Object t,PieDGeneral r, FishD f){
		if(f.equals(t)){
			return r.remA(f);
		}else{
			return new Top1(t,r.remA(f));
		}
	}
}

//删除指定的整数
class RemFishInt{
	PieDGeneral forBot(FishD f){
		return new Bot1();
	}
	//不太明白
	PieDGeneral forTop(Object t,PieDGeneral r, Integer f){ //不能用int
		if(f.equals(t)){
			return r.remA(f);
		}else{
			return new Top1(t,r.remA(f));
		}
	}
}

//RemFishV1 and RemFishInt具有相似的逻辑 于是归类

class RemV{
	PieDGeneral forBot(Object f){
		return new Bot1();
	}
	//改用Object即可
	PieDGeneral forTop(Object t,PieDGeneral r, Object f){ //不能用int
		if(f.equals(t)){
			return r.remA(f);
		}else{
			return new Top1(t,r.remA(f));
		}
	}
}
public abstract class PieDGeneral { //比萨饼
	
	//定义两个访问者
	RemV remFn = new RemV();
	abstract PieDGeneral remA(Object o);
}

class Bot1 extends PieDGeneral{

	@Override
	PieDGeneral remA(Object o) {
		// TODO Auto-generated method stub
		return remFn.forBot(o);
	}
	
}

class Top1 extends PieDGeneral{

	Object t;
	PieDGeneral r;
	public Top1(Object t,PieDGeneral r) {
		// TODO Auto-generated constructor stub
		this.t = t;
		this.r = r;
	}
	@Override
	PieDGeneral remA(Object f) {
		// TODO Auto-generated method stub
		return remFn.forTop(t, r, f);
	}
	
}



