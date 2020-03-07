package ch05;


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

//删除凤尾鱼方法

class RemAV{
	PieD forBot(){
		return new Bot();
	}
	PieD forTop(Object t ,PieD r){
		if(new AnchovyFish().equals(t)){
			return r.remA();
		}else{
			return new Top(t,r.remA());
		}
	}
}
//删除指定鱼的方法
class RemFishV{
	PieD forBot(FishD f){
		return new Bot();
	}
	//不太明白
	PieD forTop(Object t,PieD r, FishD f){
		if(f.equals(t)){
			return r.remFish(f);
		}else{
			return new Top(t,r.remFish(f));
		}
	}
}
public abstract class PieD { //比萨饼
	
	//定义两个访问者
	RemAV raFn = new RemAV();
	RemFishV rfFn = new RemFishV();
	abstract PieD remA();
	abstract PieD remFish(FishD f);
}

class Bot extends PieD{//底料

	@Override
	PieD remA() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	PieD remFish(FishD f) {
		// TODO Auto-generated method stub
		return null;
	}//底料
	
}


class Top extends PieD{

	Object t;
	PieD r;
	public Top(Object t, PieD r) {
		// TODO Auto-generated constructor stub
		this.t = t;
		this.r = r;
	}

	@Override
	PieD remA() {
		// TODO Auto-generated method stub
		return raFn.forTop(t, r);
	}

	@Override
	PieD remFish(FishD f) {
		// TODO Auto-generated method stub
		return rfFn.forTop(f, r, f);
	}//顶料
	
}



