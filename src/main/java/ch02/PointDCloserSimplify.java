package ch02;

import java.util.Locale.Category;


//抽取变体类型中公共的部分到抽象类型中。
//如何抽取重复函数 closerToDistance0
public abstract class PointDCloserSimplify {

	//空方法也是方法，不能加上大括号！！
	abstract int distanceTo0();
	//两个对象比较大小
		boolean closerTo0(CartesianPt2 p1)
		{
			return distanceTo0() <= p1.distanceTo0();
		}
}



//笛卡尔坐标
class CartesianPt2 extends PointDCloserSimplify{
	int x;
	int y;
	public CartesianPt2(int _x, int _y) {
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

class ManHattanPt2 extends PointDCloserSimplify{
	int x;
	int y;
	public ManHattanPt2(int _x, int _y) {
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
	boolean closerTo0(CartesianPt p1)
	{
		return distanceTo0() <= p1.distanceTo0();
	}
}

