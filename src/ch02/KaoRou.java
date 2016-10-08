package ch02;

//类型是什么？
//::

//	   A type is a name for a collection of values

//第一个程序 无构造函数
public abstract class KaoRou {//烤肉
	abstract boolean isVeggie(); //是否以纯蔬菜当作辅料
	abstract Object whatHolder(); //烤肉的拜访工具是什么
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.getClass().toString();
		}

}

class Holder extends KaoRou{

	Object o;
	public Holder(Object _o) {
		// TODO Auto-generated constructor stub
		this.o = _o;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return o;
	}}; //烤肉摆放工具
class Shallot extends KaoRou{

	KaoRou kaoroujia;
	public Shallot(KaoRou kaoroujia) {
		// TODO Auto-generated constructor stub
		this.kaoroujia = kaoroujia;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return kaoroujia.isVeggie();
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return kaoroujia.whatHolder();
	}};//葱
class Shrimp extends KaoRou{

	KaoRou kaoroujia;
	public Shrimp(KaoRou kaoroujia) {
		// TODO Auto-generated constructor stub
		this.kaoroujia = kaoroujia;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return kaoroujia.whatHolder();
	}}; //小虾
class Radish extends KaoRou{

	KaoRou kaoroujia;
	public Radish(KaoRou kaoroujia) {
		// TODO Auto-generated constructor stub
		this.kaoroujia = kaoroujia;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return kaoroujia.isVeggie();
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return kaoroujia.whatHolder();
	}}; //萝卜
class Pepper extends KaoRou{

	KaoRou kaoroujia;
	public Pepper(KaoRou kaoroujia) {
		// TODO Auto-generated constructor stub
		this.kaoroujia = kaoroujia;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return kaoroujia.isVeggie();
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return kaoroujia.whatHolder();
	}}; //胡椒粉
class Zucchini extends KaoRou{

	KaoRou kaoroujia;
	public Zucchini(KaoRou kaoroujia) {
		// TODO Auto-generated constructor stub
		this.kaoroujia = kaoroujia;
	}
	@Override
	boolean isVeggie() {
		// TODO Auto-generated method stub
		return kaoroujia.isVeggie();
	}

	@Override
	Object whatHolder() {
		// TODO Auto-generated method stub
		return kaoroujia.whatHolder();
	}}; //西葫芦


	//接下来

/*定义一下烤肉摆放的工具。

大致分成两种:

* 一种是将烤肉串起来的工具*/