package ch09;



//抽取变体类型中公共的部分到抽象类型中。
//如何抽取重复函数 closerToDistance0
public abstract class PointDCloserSimplify {

	int x;
	int y;
	public PointDCloserSimplify(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}
	//空方法也是方法，不能加上大括号！！
	abstract int distanceTo0();
	//两个对象比较大小
		boolean closerTo0(CartesianPt2 p1)
		{
			return distanceTo0() <= p1.distanceTo0();
		}
	PointDCloserSimplify minus(PointDCloserSimplify p)
	{
		return new CartesianPt2(x-p.x, y-p.y);
	}
}



//笛卡尔坐标
class CartesianPt2 extends PointDCloserSimplify{
	int x;
	int y;
	//如果抽象类有构造函数 必须用super
	public CartesianPt2(int _x, int _y) {
		// TODO Auto-generated constructor stub
		super(_x, _y);
	}
	/*public CartesianPt2(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}*/
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return (int)Math.sqrt(x*x+y*y);
	}
	
	
}

//曼哈顿坐标

class ManHattanPt2 extends PointDCloserSimplify{
	int x;
	int y;
/*	public ManHattanPt2(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}*/
	public ManHattanPt2(int _x, int _y) {
		// TODO Auto-generated constructor stub
		super(_x, _y);
	}
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return x+y;
	}
		//两个对象比较大小
	boolean closerTo0(CartesianPt2 p1)
	{
		return distanceTo0() <= p1.distanceTo0();
	}
}

