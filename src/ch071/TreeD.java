package ch071;

   abstract class TreeD {
	   abstract Object accept(TreeVisitorI ask);
	  
   } // 树
   
   class Bud extends TreeD{

	@Override
	Object accept(TreeVisitorI ask) {
		// TODO Auto-generated method stub
		return new Bud();
	}

	
	   
   }
   
   class Flat extends TreeD{//平顶

	   FruitD f;
	   TreeD t;
	   
	public Flat(FruitD _f, TreeD _t) {
		// TODO Auto-generated constructor stub
		this.f = _f;
		this.t = _t;
	}

	@Override
	Object accept(TreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forFlat(f, t);
	}

	
	   
   }
   
   
   class Split extends TreeD{

	   TreeD l;
	   TreeD t;
	public Split(TreeD _l, TreeD _t) {
		// TODO Auto-generated constructor stub
		this.l = _l;
		this.t = _t;
	}
	@Override
	Object accept(TreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forSplit(l, t);
	}

	 //分支
	   
   }
  interface  TreeVisitorI{
	  Object forBud();
	  Object forFlat(FruitD f, TreeD t);
	  Object forSplit(TreeD l,TreeD t);
  }

  class IsFlatV implements TreeVisitorI{

	@Override
	public Object forBud() {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}

	@Override
	public Object forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return t.accept(this);
	}

	@Override
	public Object forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return new Boolean(false);
	}

	
	  
  }

  
  class IsSplitV implements TreeVisitorI{

	@Override
	public Object forBud() {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}

	@Override
	public Object forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return new Boolean(false);
	}

	@Override
	public Object forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		if(((Boolean)(l.accept(this))).booleanValue()){
			return t.accept(this);
		}else{
			return new Boolean(false);
		}
	}
	  
  }
  
  
  // ITreeVistorI
  class HasFruitV implements TreeVisitorI{
		@Override
		public Object forBud() {
			// TODO Auto-generated method stub
			return new Boolean(false);
		}

		@Override
		public Object forFlat(FruitD f, TreeD t) {
			// TODO Auto-generated method stub
			return new Boolean(true);
		}

		@Override
		public Object forSplit(TreeD l, TreeD t) {
			// TODO Auto-generated method stub
			return new Boolean((boolean)l.accept(this) ||(boolean) t.accept(this));
			//return new Boolean( (boolean) t.accept(this));
		}  
  }
  
  class IHeightV implements TreeVisitorI{

	@Override
	public Object forBud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return (int)t.accept(this)+1;
	}

	@Override
	public Object forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		//得对应
		
		return ((int)l.accept(this)| (int)t.accept(this))+1;
	}
	  
  }
  
  class IOccursV implements TreeVisitorI{

	  FruitD a;
	  public IOccursV(FruitD _a) {
		// TODO Auto-generated constructor stub
		  this.a = _a;
		  
	}
	@Override
	public Object forBud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		if(f.equals(a)){
			return (int)t.accept(this)+1;
		}else
		{
			return (int)t.accept(this);
			
		}
	}

	@Override
	public Object forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return (int)l.accept(this)+(int)t.accept(this);
	}
	  
  }
  
  
  
  class TSubstsV implements TreeVisitorI{

	  FruitD n;
	  FruitD o;
	  public TSubstsV(FruitD _n, FruitD _o) {
		// TODO Auto-generated constructor stub
		  this.n = _n;
		  this.o = _o;
	}
	@Override
	public Object forBud() {
		// TODO Auto-generated method stub
		return new Bud();
	}

	@Override
	public Object forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		if(o.equals(f)){
			return new Flat(n,(TreeD)t.accept(this));
		}else{
			return new Flat(f,(TreeD)t.accept(this));
		}
	}

	@Override
	public TreeD forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return new Split((TreeD)l.accept(this),(TreeD)t.accept(this));
	}
	  
  }
  

   
