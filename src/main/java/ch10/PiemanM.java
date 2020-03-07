package ch10;

interface PiemanI{
	
	int addTop(Object t);
	int remTop(Object t);
	int substTop(Object n, Object o);
	int occTop(Object o);
}
class PiemanM implements PiemanI{

	PieD p  = new Bot();
	public PiemanM(PieD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	public int addTop(Object t) {
		// TODO Auto-generated method stub
		p = new Top(t, p);
		return occTop(t);
	}

	@Override
	public int remTop(Object t) {
		// TODO Auto-generated method stub
		p = (PieD)p.accept(new RemV(t));
		return occTop(p);
	}

	@Override
	public int substTop(Object n, Object o) {
		// TODO Auto-generated method stub
		p =(PieD)p.accept(new SubstV(n,o));
		return occTop(p);
	}

	@Override
	public int occTop(Object o) {
		// TODO Auto-generated method stub
		return ((Integer)p.accept(new OccursV(o))).intValue();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

}

class OccursV implements PieVistor1{

	Object 	a;
	public OccursV(Object _a) {
		// TODO Auto-generated constructor stub
		this.a = _a;
	}

	@Override
	public Object forBot() {
		// TODO Auto-generated method stub
		return new Integer(0);
	}

	@Override
	public Object forTop(Object t, PieD r) {
		// TODO Auto-generated method stub
		if(t.equals(a)){
			return new Integer(((Integer)(r.accept(this))).intValue()+1);
		}else{
			return r.accept(this); 
		}
	}
	
}
