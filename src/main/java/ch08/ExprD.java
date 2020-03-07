package ch08;

interface ExprVisitorI{
	   Object forPlus(ExprD l,ExprD r); //相加
	   Object forDiff(ExprD l,ExprD r);//相减
	   Object forProd(ExprD l,ExprD r);//相乘
	   Object forConst(Object c);//常量
}

class IntEvalV implements ExprVisitorI{

	@Override
	public Object forPlus(ExprD l, ExprD r) {
		// TODO Auto-generated method stub
		return plus(l.accpet(this), r.accpet(this));
	}

	@Override
	public Object forDiff(ExprD l, ExprD r) {
		// TODO Auto-generated method stub
		return diff(l.accpet(this), r.accpet(this));
	}

	@Override
	public Object forProd(ExprD l, ExprD r) {
		// TODO Auto-generated method stub
		return prod(l.accpet(this), r.accpet(this));
	}

	@Override
	public Object forConst(Object c) {
		// TODO Auto-generated method stub
		return c;
	}
	
	Object plus(Object l , Object r){
		return new Integer(((Integer)l).intValue()+((Integer)r).intValue());
	}
	Object diff(Object l , Object r){
		return new Integer(((Integer)l).intValue()-((Integer)r).intValue());
	}
	Object prod(Object l , Object r){
		return new Integer(((Integer)l).intValue()*((Integer)r).intValue());
	}
	  
}
   abstract class ExprD {
	  abstract Object accpet(ExprVisitorI ask); 
   } // 水果

   
 
   
   class Plus extends ExprD{

	   ExprD l;
	   ExprD r;
	   public Plus(ExprD _l,ExprD _r) {
		// TODO Auto-generated constructor stub
		   this.l = _l;
		   this.r = _r;
	}
	@Override
	Object accpet(ExprVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forPlus(l, r);
	}
	   
   }
   
   class Diff extends ExprD{
	   ExprD l;
	   ExprD r;
	   public Diff(ExprD _l,ExprD _r) {
		// TODO Auto-generated constructor stub
		   this.l = _l;
		   this.r = _r;
	}
	@Override
	Object accpet(ExprVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forDiff(l, r);
	}  
   }
   
   class Prod extends ExprD{
	   ExprD l;
	   ExprD r;
	   public Prod(ExprD _l,ExprD _r) {
		// TODO Auto-generated constructor stub
		   this.l = _l;
		   this.r = _r;
	}
	@Override
	Object accpet(ExprVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forProd(l, r);
	} 
   }

   
   class Const extends ExprD{
	   Object c;
	   public Const(Object _c) {
		// TODO Auto-generated constructor stub
		   this.c= _c;
	}
	@Override
	Object accpet(ExprVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forConst(c);
	} 
   }
   
 