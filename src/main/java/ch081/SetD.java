package ch081;

abstract class SetD{
	SetD add(Integer i){
		if(mem(i)){
			return this;
		}else{
			return new Add(i,this);
		}
	}
	
	abstract boolean mem(Integer i);
	abstract SetD plus(SetD s);
	abstract SetD diff(SetD s);
	abstract SetD prod(SetD s);
}


class Empty extends SetD{

	@Override
	boolean mem(Integer i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	SetD plus(SetD s) {
		// TODO Auto-generated method stub
		return s;
	}

	@Override
	SetD diff(SetD s) {
		// TODO Auto-generated method stub
		return new Empty();
	}

	@Override
	SetD prod(SetD s) {
		// TODO Auto-generated method stub
		return new Empty();
	}
	
}


class Add extends SetD{

	Integer i;
	SetD s;
	public Add(Integer _i, SetD _s) {
		// TODO Auto-generated constructor stub
		this.i = _i;
		this.s = _s;
	}
	@Override
	boolean mem(Integer n) {
		// TODO Auto-generated method stub
		if(i.equals(n)){
			return true;
		}else{
			return s.mem(n);
		}
	}

	@Override
	SetD plus(SetD t) {
		// TODO Auto-generated method stub
		return s.plus(t.add(i));
	}

	@Override
	SetD diff(SetD t) {
		// TODO Auto-generated method stub
		if(t.mem(i)){
			return s.diff(t);
		}else{
			return s.diff(t).add(i);
		}
	}

	@Override
	SetD prod(SetD t) {
		// TODO Auto-generated method stub
		if(t.mem(i)){
			return s.prod(t).add(i);
		}else{
			return s.prod(t);
		}
	}
	
}


//改用EvalV
class SetEvalV extends EvalV{
	@Override
	Object plus(Object l, Object r) {
		// TODO Auto-generated method stub
		return ((SetD) l).plus((SetD) r);
	}
	@Override
	Object diff(Object l, Object r) {
		// TODO Auto-generated method stub
		return ((SetD)l).diff((SetD) r);
	}
	@Override
	Object prod(Object l, Object r) {
		// TODO Auto-generated method stub
		return ((SetD)l).prod((SetD) r);
	}
}