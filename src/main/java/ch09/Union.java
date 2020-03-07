package ch09;

class Union extends ShapeD{
	ShapeD s;
	ShapeD t;
	public Union(ShapeD _s, ShapeD _t) {
		// TODO Auto-generated constructor stub
		this.s = _s;
		this.t = _t;
	}
	@Override
	boolean accept(ShapeVisitorI ask) {
		// TODO Auto-generated method stub
		return ((UnionVisitorI)ask).forUnion(s,t);
	}

}

interface UnionVisitorI extends ShapeVisitorI{
	boolean forUnion(ShapeD s,ShapeD t);
}

class UnionHasPtV extends HasPtV implements ShapeVisitorI{

	public UnionHasPtV(CartesianPt2 _p) {
		super(_p);
		// TODO Auto-generated constructor stub
	}
	
	public boolean forUnion(ShapeD s,ShapeD t){
		return s.accept(this) ||t.accept(this);
	}
}
