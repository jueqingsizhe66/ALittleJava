package ch09;

//第二个程序 构造函数
//   手动添加了构造函数 因为需要额外属性添加到构造函数


//笛卡尔坐标
class ShadowCartesian extends CartesianPt2{
	int tx;
	int ty;
	public ShadowCartesian(int _x, int _y, int _tx,int _ty) {
		// TODO Auto-generated constructor stub
		super(_x, _y);
		this.tx = _tx;
		this.ty = _ty;
		
	}
	
	@Override
	int distanceTo0() {
		// TODO Auto-generated method stub
		return super.distanceTo0()+ (int)Math.sqrt(tx*tx+ ty*ty);
	}
	
}

//曼哈顿坐标