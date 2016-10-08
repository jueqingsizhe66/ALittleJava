package ch02;

/*使用这两个子类型，就可以表示一个整数系统。

1. `Zero` 表示 `0` 

2. `new OneMoreThan(new Zero())` 表示 `1`

3. `new OneMoreThan(new OneMoreThan(new Zero()))` 表示 `2`

4. ... ...*/
/*上面的概念和 `Church encoding`_ 很类似了。

`abstract` 、 `class` 、 `extends` 各代表什么？
::

`abstract` 定义类型

`class` 定义子类型

`extends` 将以上两者联系起来

**第一条建议**

When specifying a collection of data,

use *abstract* classes for datatypes and

*extended* classes for variants.
*/
public abstract class NumD {

}


//0
class Zero extends NumD{

}

//>-1

class MoreThanOne extends NumD{

	NumD predecessor;
	public MoreThanOne(NumD _d) {
		// TODO Auto-generated constructor stub
		predecessor = _d;
	}

}
