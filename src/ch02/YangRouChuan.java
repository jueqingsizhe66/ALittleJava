package ch02;


public abstract class YangRouChuan {

	abstract boolean onlyOnions();//烤串上是不是只有洋葱
	abstract boolean isVegetarian();//烤串上是不是全是蔬菜
	
	public YangRouChuan() {
		// TODO Auto-generated constructor stub
		System.out.print(" new "+ this.getClass().getName()+"()->");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new "+this.getClass().getName()+"()";
	}
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
		return true;
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return true;
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
		return s1.onlyOnions();
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return s1.isVegetarian();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new "+this.getClass().getName()+"()";
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
		return false;
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return false;
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
		return false;
	}

	@Override
	boolean isVegetarian() {
		// TODO Auto-generated method stub
		return y.isVegetarian();
	} //西红柿
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new "+this.getClass().getName()+"()";
	}
}