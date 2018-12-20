package ch02;

//第二个程序 构造函数
//   手动添加了构造函数 因为需要额外属性添加到构造函数
public abstract class PointD {

	//空方法也是方法，不能加上大括号！！
	abstract int distanceTo0();
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new " + this.getClass().getName();
	}
}
//当子类型（具体类）从类型（抽象类）继承时，\
//需要同时实现抽象类中的抽象方法


//笛卡尔坐标
class CartesianPt extends PointD{
	int x;
	int y;
	public CartesianPt(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return (int)Math.sqrt(x*x+y*y);
	}
}

//曼哈顿坐标

class ManHattanPt extends PointD{
	int x;
	int y;
	public ManHattanPt(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return x+y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "new "+this.getClass().getName()+"("+x+", "+y+")";
	}
}
