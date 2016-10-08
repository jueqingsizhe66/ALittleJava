package ch07;

   abstract class TreeD {
	   abstract boolean accept(BTreeVisitorI ask);
	   abstract int accept(ITreeVisitorI ask);
	   abstract TreeD accept(TTreeVisitorI ask);
   } // 树
   
   class Bud extends TreeD{

	@Override
	boolean accept(BTreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forBud();
	}

	@Override
	int accept(ITreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forBud();
	}

	@Override
	TreeD accept(TTreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forBud();
	}// 芽
	   
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
	boolean accept(BTreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forFlat(f, t);
	}

	@Override
	int accept(ITreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forFlat(f, t);
	}

	@Override
	TreeD accept(TTreeVisitorI ask) {
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
	boolean accept(BTreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forSplit(l, t);
	}

	@Override
	int accept(ITreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forSplit(l, t);
	}

	@Override
	TreeD accept(TTreeVisitorI ask) {
		// TODO Auto-generated method stub
		return ask.forSplit(l, t);
	} //分支
	   
   }
  interface  BTreeVisitorI{
	  boolean forBud();
	  boolean forFlat(FruitD f, TreeD t);
	  boolean forSplit(TreeD l,TreeD t);
  }

  class BIsFlatV implements BTreeVisitorI{

	@Override
	public boolean forBud() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return t.accept(this);
	}

	@Override
	public boolean forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return false;
	}
	  
  }

  
  class BIsSplitV implements BTreeVisitorI{

	@Override
	public boolean forBud() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return l.accept(this) || t.accept(this);
	}
	  
  }
  

  
  interface  ITreeVisitorI{
	  int forBud();
	  int forFlat(FruitD f, TreeD t);
	  int forSplit(TreeD l,TreeD t);  
  }
  
  
  // ITreeVistorI
  class BHasFruitV implements BTreeVisitorI{
		@Override
		public boolean forBud() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean forFlat(FruitD f, TreeD t) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean forSplit(TreeD l, TreeD t) {
			// TODO Auto-generated method stub
			return l.accept(this) || t.accept(this);
		}  
  }
  
  class IHeightV implements ITreeVisitorI{

	@Override
	public int forBud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		return t.accept(this)+1;
	}

	@Override
	public int forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		//得对应
		
		return (l.accept(this)| t.accept(this))+1;
	}
	  
  }
  
  class IOccursV implements ITreeVisitorI{

	  FruitD a;
	  public IOccursV(FruitD _a) {
		// TODO Auto-generated constructor stub
		  this.a = _a;
		  
	}
	@Override
	public int forBud() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		if(f.equals(a)){
			return t.accept(this)+1;
		}else
		{
			return t.accept(this);
			
		}
	}

	@Override
	public int forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return l.accept(this)+t.accept(this);
	}
	  
  }
  
  interface TTreeVisitorI{
	  TreeD forBud();
	  TreeD forFlat(FruitD f, TreeD t);
	  TreeD forSplit(TreeD l,TreeD t);    
  }
  
  
  class TSubstsV implements TTreeVisitorI{

	  FruitD n;
	  FruitD o;
	  public TSubstsV(FruitD _n, FruitD _o) {
		// TODO Auto-generated constructor stub
		  this.n = _n;
		  this.o = _o;
	}
	@Override
	public TreeD forBud() {
		// TODO Auto-generated method stub
		return new Bud();
	}

	@Override
	public TreeD forFlat(FruitD f, TreeD t) {
		// TODO Auto-generated method stub
		if(o.equals(f)){
			return new Flat(n,t.accept(this));
		}else{
			return new Flat(f,t.accept(this));
		}
	}

	@Override
	public TreeD forSplit(TreeD l, TreeD t) {
		// TODO Auto-generated method stub
		return new Split(l.accept(this),t.accept(this));
	}
	  
  }
  

   
