package ch02;



//如何抽取重复函数 closerToDistance0
public abstract class PointDCloser {

	//空方法也是方法，不能加上大括号！！
	abstract int distanceTo0();
}



//笛卡尔坐标
class CartesianPt1 extends PointDCloser{
	int x;
	int y;
	public CartesianPt1(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return (int)Math.sqrt(x*x+y*y);
	}
	
	//两个对象比较大小
	boolean closerTo0(CartesianPt1 p1)
	{
		return distanceTo0() <= p1.distanceTo0();
	}
}

//曼哈顿坐标

class ManHattanPt1 extends PointDCloser{
	int x;
	int y;
	public ManHattanPt1(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
	}
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return x+y;
	}
		//两个对象比较大小
	boolean closerTo0(ManHattanPt1 p1)
	{
		return distanceTo0() <= p1.distanceTo0();
	}
}

