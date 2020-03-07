package ch01;


public abstract class LayerD {

}
/*书中通过一系列对话和示例来揭示\
自定义类型与Java提供的基本类型的不同之处，\
给读者一个基本印象：基本类型不能直接作用于自定义类型，\
而是将之先转换为类似自定义类型的形式，然后才能使用。
*/

//0
class Base extends LayerD{

	Object o1;
	public Base(Object _o) {
		// TODO Auto-generated constructor stub
		this.o1 = _o;
	}
}

//>-1

class Slice extends LayerD{

	LayerD s1;
	public Slice(LayerD _s) {
		// TODO Auto-generated constructor stub
		this.s1 = _s;
	}

}
