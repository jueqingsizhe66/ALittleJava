package ch09;

abstract class ShapeD{
	abstract boolean accept(ShapeVisitorI ask);
}

interface ShapeVisitorI{
	boolean forCircle(int r);
	boolean forSquare(int s);
	boolean forTrans(PointDCloserSimplify q,ShapeD s);
}


class Circle extends ShapeD{ //圆心在坐标原点的圆

	int r;
	public Circle(int _r) {
		// TODO Auto-generated constructor stub
		this.r = _r;
	}
	@Override
	boolean accept(ShapeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forCircle(r);
	}
	
}

class Square extends ShapeD{//左上角在坐标原点的正方形
	int s;
	public Square(int _s) {
		// TODO Auto-generated constructor stub
		this.s = _s;
	}
	@Override
	boolean accept(ShapeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forSquare(s);
	}
}

class Trans extends ShapeD{//在指定 位置的图形
	PointDCloserSimplify q;
	ShapeD s;
	public Trans(PointDCloserSimplify _q, ShapeD _s) {
		// TODO Auto-generated constructor stub
		this.q = _q;
		this.s = _s;
	}
	@Override
	boolean accept(ShapeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forTrans(q, s);
	}
}


class HasPtV implements ShapeVisitorI{

	PointDCloserSimplify p;
	public HasPtV(PointDCloserSimplify _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	public boolean forCircle(int r) {
		// TODO Auto-generated method stub
		return p.distanceTo0() <=r;
	}

	@Override
	public boolean forSquare(int s) {
		// TODO Auto-generated method stub
		return p.x <= s && p.y <= s;
	}

	@Override
	public boolean forTrans(PointDCloserSimplify q, ShapeD s) {
		// TODO Auto-generated method stub
		return s.accept(new HasPtV(q));
	}
	
}