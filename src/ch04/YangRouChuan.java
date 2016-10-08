package ch04;


//增加两个访问者
class OnlyOnionsV{
	boolean forSkewer(){  //串
		return true;
	}
	boolean forOnion(YangRouChuan y){
		return y.onlyOnions();
	}
	boolean forLamb(YangRouChuan y){
		return false;
	}
	boolean forTomato(YangRouChuan y){
		return false;
	}
}

class IsVegetarianV{
	boolean forSkewer(){
		return true;
	}
	boolean forOnion(YangRouChuan y){
		return y.isVegetarian();
	}
	boolean forLamb(YangRouChuan y){
		return false;
	}
	boolean forTomato(YangRouChuan y){
		return y.isVegetarian();
	}
}
public abstract class YangRouChuan {

	//增加两个对象
	OnlyOnionsV ooFn = new OnlyOnionsV();
	IsVegetarianV ivFn = new IsVegetarianV();
	abstract boolean onlyOnions();//烤串上是不是只有洋葱
	abstract boolean isVegetarian();//烤串上是不是全是蔬菜
}
/*书中通过一系列对话和示例来揭示\
自定义类型与Java提供的基本类型的不同之处，\
给读者一个基本印象：基本类型不能直接作用于自定义类型，\
而是将之先转换为类似自定义类型的形式，然后才能使用。
*/

//0
class Skewer extends YangRouChuan{

	@Override
	boolean onlyOnions() {
		// TODO Auto-generated method stub
		return ooFn.forSkewer();
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return ivFn.forSkewer();
	} //烤肉叉子


}


class Onion extends YangRouChuan{ //洋葱
	YangRouChuan s1;

	public Onion(YangRouChuan _s) {
		// TODO Auto-generated constructor stub
		this.s1 = _s;
	}
	@Override
	boolean onlyOnions() {
		// TODO Auto-generated method stub
		return ooFn.forOnion(s1);
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return ivFn.forOnion(s1);
	}

	}


class Lamb extends YangRouChuan{ //羔羊肉

	YangRouChuan y;
	public Lamb(YangRouChuan _y) {
		// TODO Auto-generated constructor stub
		this.y = _y;
		
	}
	@Override
	boolean onlyOnions() {
		// TODO Auto-generated method stub
		return ooFn.forLamb(y);
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return ivFn.forLamb(y);
	}
	
}

class Tomato extends YangRouChuan{ //西红柿

	YangRouChuan y;
	public Tomato(YangRouChuan _y) {
		// TODO Auto-generated constructor stub
		this.y = _y;
	}
	@Override
	boolean onlyOnions() {
		// TODO Auto-generated method stub
		return ooFn.forTomato(y);
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return ivFn.forTomato(y);
	} //西红柿
	
}