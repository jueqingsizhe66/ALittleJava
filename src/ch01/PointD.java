package ch01;

//第二个程序 构造函数
//   手动添加了构造函数 因为需要额外属性添加到构造函数
 abstract class PointD {

}


//笛卡尔坐标
class CartesianPt extends PointD{
	int x;
	int y;
	public CartesianPt(int _x, int _y) {
		// TODO Auto-generated constructor stub
		this.x = _x;
		this.y = _y;
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
}
