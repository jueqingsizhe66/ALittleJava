package ch081;
//因为RemV SubstV Bot Top四个类极度相似，于是继续抽象。

abstract class SubstD implements PieVistor1{
	
	Object n;
	Object o;
	public SubstD(Object _n, Object _o) {
		// TODO Auto-generated constructor stub
		this.n = _n;
		this.o = _o;
	}
	@Override
	public PieD forBot() {
		// TODO Auto-generated method stub
		return new Bot();
	}
	
	public abstract PieD forTop(Object t, PieD r);
}


class SubstV1 extends SubstD{

	public SubstV1(Object _n,Object _o) {
		// TODO Auto-generated constructor stub
		super(_n, _o);
	}
	@Override
	public PieD forTop(Object t, PieD r) {
		// TODO Auto-generated method stub
		if(o.equals(t))
		{
			return new Top(n,r.accept(this));
		}else{
			return new Top(t,r.accept(this));
		}
	}

}

class LtSubstV1 extends SubstD{
	int c;
	public LtSubstV1(int c, Object _n,Object _o) {
		// TODO Auto-generated constructor stub
		super(_n, _o);
		this.c = c;
	}
	@Override
	public PieD forTop(Object t, PieD r) {
		// TODO Auto-generated method stub
		if( 0 == c )
		{
			return new Top(t,r);
		}else{
			if(o.equals(t)){
				return new Top(n,r.accept(new LtSubstV1(c-1,n,o)));
			}else{
				return new Top(t, r.accept(this));
			}
		}
	}
}