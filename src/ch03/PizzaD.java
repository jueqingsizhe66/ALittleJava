package ch03;


public abstract class PizzaD { //比萨饼
	abstract PizzaD remA(); //去除比萨饼上面的凤尾草（太咸了)
	abstract PizzaD topAwC(); //顶层加上奶酪（盖住凤尾草味道)
	abstract PizzaD subAwC(); //将所有凤尾草替换为奶酪（甜的）

}


//0
class Crust extends PizzaD{ //面包皮  区分下面的各个料

	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		return new Crust();
	}

	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Crust();
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Crust();
	}//面包皮

}

// 以下都是顶料

class Cheese extends PizzaD{

	PizzaD p;
	public Cheese(PizzaD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		return new Cheese(p.remA());
	}

	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Cheese(p.topAwC());
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Cheese(p.subAwC());
	} //奶酪pizzad
	
	
}


//橄榄
class Olive extends PizzaD{

	PizzaD p;
	public Olive(PizzaD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		return new Olive(p.remA());
	}

	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Olive(p.topAwC());
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Olive(p.subAwC());
	} //奶酪pizzad
	
}


//凤尾鱼
class Anchovy extends PizzaD{

	PizzaD p;
	public Anchovy(PizzaD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		//return new Cheese(p.remA());
		return p.remA();
	}

	//不理解
	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Cheese(new Anchovy(p.topAwC()));
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Cheese(p.subAwC()); 
	} //奶酪pizzad
	
}


//香肠
class Sausage extends PizzaD{

	PizzaD p;
	public Sausage(PizzaD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		return new Sausage(p.remA());
	}

	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Sausage(p.topAwC());
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Sausage(p.subAwC());
	} //奶酪pizzad
	
}


/*
如果想要在比萨饼上面添加额外的顶料怎么办？

很简单，再从 `PizzaD` 扩展出一个新的子类型就可以了。

*/


//菠菜
class Spinach extends PizzaD{

	PizzaD p;
	public Spinach(PizzaD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	PizzaD remA() {
		// TODO Auto-generated method stub
		return new Spinach(p.remA());
	}

	@Override
	PizzaD topAwC() {
		// TODO Auto-generated method stub
		return new Spinach(p.topAwC());
	}

	@Override
	PizzaD subAwC() {
		// TODO Auto-generated method stub
		return new Spinach(p.subAwC());
	} //奶酪pizzad
	
}

/*
但是每添加一个新的变体类型都要加上三个方法，好累的说。

有什么比较好的办法解决这个问题呢？

  下一章节给你答案。
*/