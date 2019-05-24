[A little java笔记][1]

Evaluate(interpret) all the hierarchy objects, apply coresponding operators to every objects.

Introspect 和 retrospect具有类似的地方(review ,look back on, backcall)
经常用的In retrospect.
![eval-apply][2]

[How Do Procurement Networks Become Social? Design Principles Evaluation in a Heterogeneous Environment of Structured and Unstructured Interactions][3]


![design][4]
## 对象和行为


一个访问模式包含着一片对象和一类行为，行为中又可以根据相同和不同点划分
不同的风格(style)和类别

A type is a name for a collection of values

Define-Datetype(Abstract)相当于定义了一个类型，比如KebabD,RobD

### abstract 、 class 、 extends 各代表什么？

1.    `abstract` 定义类型(基本类型)
2.    `class` 定义子类型(自定义类型)
3.    `extends` 将以上两者联系起来(连接起来),属性和行为联合起来,也就是可以使用super(x,y)进行父类构造


### 第一条建议: 

When specifying a collection of data,
use abstract classes for datatypes and
extended classes for variants.

揭示点： java的基本类型(并非对象，是不完整的对象)不能直接作为自定义类型来使用，而是先和自定义类型
结合起来才能使用!

### 第三条建议

When writing a function that returns values of a datatype,
use new to create these values.

揭示点: new可以通过自定义类型产生新值，这边通过toString反馈出来，new类似于+，*， cons的作用，
对应的构造函数类似于-,/,car or cdr的作用(2019-05-24 是有这种感觉,类似下文的非初始原基), 而
terminal element 相当于 0, 1,null?的作用(类似下文的所有初始原基)

#### 拓展延伸(lisp部分)
[From-little-scheme-to-seazon-scheme][6]

[从lambda到simple+complex解释器再到树形抽象 ][7]

[The-Little-Scheme-And-Part-Of-TSS ][8] 学到了equal? 和insert-g以及interpreter

认识到等号的有效性(以及Java中的Comparator类， 联想到sort信息等)
``` scheme

(define equal1?
  (lambda (s1 s2)
    (cond
      ((and (atom? s1) (atom? s2))
       (eqan? s1 s2))
      ((or (atom? s1) (atom? s1))
       #f)
      (else
       (eqlist? s1 s2)))))

```

还比如insert-g

```scheme

;;; so you can (insert-g seqL)  (insert-g seqR)
;;; (define insertL (insert-g seqL))
;;; (define insertR (insert-g seqR))
;;;
;;;
(define insert-g
  (lambda (seq)
    (lambda (new old l)
      (cond
        ((null? l) (quote ()))
        ((eq? (car l) old)
         (seq new old (cdr l)))
        (else (cons (car l)
                    ((insert-g seq) new old
                                    (cdr l))))))))
;;; So we can define insertL again with insert-g *****************************^-^************************************
;;; Do not pass in seqL this time.
(define insertL1
  (insert-g
    (lambda (new old l)
      (cons new (cons old l)))))

```
----------------------------------------------------------------------------------

核心点：通过构造函数（类似于y lambda的功能）  按照natural recursion 不断递归到结尾。

技术点: 把基类的字段添加到自定义类中，通过构造函数的参数赋值，在终止类(terminal class)不添加该
基类字段，直接返回值(new),递归结束
Object是FishD,Int等所有类的父类，最原始类

发展过程：

#### 第一步：


首先是把不相关的属性放入自定义类中，然后是把基类和需要的属性的输入放入自定义类中，
后来是多个行为基类(也叫作行为基函数，省略掉必要的属性, 比如PizzaD的remA,topAwc,subAbc)放入
其中(出现的问题1: 每个自定义子类都有一堆的基类函数需要实现, 这也是我们最先想到方法，比如鸭子
会飞、会叫、会游泳会吃，于是黑鸭子也都会，黄鸭子也会，蓝鸭子也会，臭鸭子也会^-^ 很多很多)
此时，我们用笨方法实现了不同鸭子类, 并且这时候已经有了构造函数的概念(new Olive(new ..))的样子。
并且每一个子类都会出现父类(原基字段，一般和构造函数对应上)这是所有子类都有，后续章节也出现。
原基不断进行迭代，构成了生态链---原基生态链，比如PizzaD、ShishD、LayerD、PointD等都是原基
原基之上有不能吃的子基和能吃的子基

原基示例: 共同特点通过public abstract class定义
``` java

public abstract class PizzaD { //比萨饼
abstract PizzaD remA(); //去除比萨饼上面的凤尾草（太咸了)
abstract PizzaD topAwC(); //顶层加上奶酪（盖住凤尾草味道)
abstract PizzaD subAwC(); //将所有凤尾草替换为奶酪（甜的）

}

public abstract class LayerD {

}

public abstract class PointD {

}

```          

初始原基(不能吃原基,一般也是递归出口，return ture，不进行recursion)示例(一般在该类中不带有原基)
初始原基目的帮你认识什么时候程序终止。
```java

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
```
可以和非初始原基（natural recursion)比较一下,比如Cheese: return newCheese, ，
非初始原基目的帮你认识递归过程
```java

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
```

到此，说明了原基、初始原基(terminate condition)和非初始原基(natural recursion)等概念，
下面借用该概念继续理解该书。
#### 第二步：(开始出现访问者字眼)

提出一个自定义的V类，实现所有针对于各个对象的for函数，然后把V类添加到基类中，并且生成值，
自定义类通过V类值来实现抽象行为。(并没有解决问题，只是把所有类的行为，抽象到一个行为V类，
在该V类，对应各个自定义类的具体实现，相当于横排竖排转置而已，没产生一个新自定义类，你的每一个
行为V类得重写，新的自定义类依然得对对应套餐行为进行实现。 这种想法也是我们能够想到的，
我们知道常见的鸭子有黑鸭子、黄鸭子、蓝鸭子、臭鸭子， 我们把他们飞的行为抽象成一个类，飞类，
他们叫的行为抽象成一个类，叫类，.... 这时候相当于把行为当做横排，而不像上面的把不同鸭子当
做一个一个记录或者叫排，然后我们针对每一类鸭子，完成飞类、叫类等的实现，这时候针对每一个
类型的鸭子，只需要引入该V类调用对应的方法即可，也就是具体的实现都移到了V类去干抽象出行为
特点！！这是他开始要展现与众不同的地方，因为你只要去V类干活就可以，
在鸭子的自定义类中只是去调用V类的对应行为，当然你也可以说上面的方法也可以，我只要到对应鸭
子类的对应行为修改就可以了，好正如上面说的，这种转置变换到此时并没有太多的进步)

中间变异原基示例:(原基引入访问者)，而在原基定义的函数也叫作基函数(基本功能、基本功能，在其他访问者接口
实现具体功能)
```java

public abstract class PieD { //比萨饼

    //定义两个访问者
    //RemV remFn = new RemV();
    //SubstV subFn = new SubstV();
    abstract PieD remA(RemV remFn);
    abstract PieD substFish(SubstV subFn);
}
```

完整变异原基示例：(Object返回+accept,所有访问者归一)
把所有初始原基通过Object代替，所有的行为函数用accept代替，按照行为接口调用对应方法。
已经在脑海中能够反映整个程序框架了（不知道你现在是否具有了？）

```java

abstract class TreeD {
    abstract Object accept(TreeVisitorI ask);

} // 树

```

自定义V类示例:(最初始的V类)

```java

//增加两个访问者
class OnlyOnionsV{
    boolean forSkewer(){  //串
        return true;
    }
    boolean forOnion(YangRouChuan y){
        return y.onlyOnions();
    }
    boolean forLamb(YangRouChuan y){
        return false;
    }
    boolean forTomato(YangRouChuan y){
    return false;
    }
}


public abstract class YangRouChuan {

//增加两个对象----注意可以把两个字段放入形参中，这是你知道的---然后进一步浓缩boolean为Object
/// 并且浓缩OnlyOnionsV 和IsVegetarianV为InterfaceV统一行为接口
    OnlyOnionsV ooFn = new OnlyOnionsV();
    IsVegetarianV ivFn = new IsVegetarianV();
    abstract boolean onlyOnions();//烤串上是不是只有洋葱
    abstract boolean isVegetarian();//烤串上是不是全是蔬菜
}
```



完整行为变异接口(有从abstract过渡到interface)

```java

interface  TreeVisitorI{
    Object forBud();
    Object forFlat(FruitD f, TreeD t);
    Object forSplit(TreeD l,TreeD t);
}

```
#### 第三步：（引入行为V类参数到构造函数)          

把基类中的行为V类放到基函数(构造函数)的参数中，而不是放在基函数的字段field中，减少了基类函数长度。
关键的this出现了，在行为类中引入this,this的出现使得代码本身具有闭包的感觉。this指代当前访问者本身
（也就是说这一步的重要改进就是通过基函数和this改变了代码的显示风格代码量没有太多实质性的减少，
只不过从字段移到了参数，感觉行数少了，但是单词数也多了 这是第二次进化在此基础上，开始进行第三
次进化，把固定不变的量提到访问者V类，比如rem，删除某个东西是固定的，于是改进行为V类的构造函数，
这样可以减少核心函数的参数个数。比如subst，从什么变到什么，也是不变的，于是也提到行为V类中(在这
次进化中，由于你把rem和subst的变化都提到行为V类中，于是对应的自定义类中的基函数实现很像出现重复
性代码，考虑进行第四次进化)

#### 第四步: 行为V类变为行为接口(interface  TreeVisitor)        

把行为V自定义类的方法抽象出一个接口函数，然后行为V类都实现改接口(implements在第四次进化中出现了)
这时候你会去分析行为的异同，对行为接口基函数的实现，和基类基函数(基向量、特征向量)的实现分开， 
你需要对基类进行修正， 行为V类已经通过行为基类结合在一起，那么对应的基类的基函数，
也得用行为基类进行了 行为基函数得浓缩为一个函数，accept(第四次进化很丰富，统一为accept)
(interface的出现也带来了accept函数的归并...参考P92)
基类基函数只存在一个accept函数了这时候你会看到很爽 ，很刺激的感觉。 因为代码量急剧下降了！
此时构建新的行为V类也会简单一些。

通过四次进化，得到关键概念： 基类(行为基类)，行为V类，基函数，函数参数，构造函数，行为基函数，行为自定义V类
abstract,new,extends, super, this, interface,implements都在其中有所体现。

##### closure的出现
另外由于行为追加了行为属性，把一些不变的属性纳入行为的字段，通过构造函数幅值，不需要handle forward and back
传来传去，直接用that.t 和that.r来代替,这也叫做闭包(行为追加属性)。
可以参考第五步的SubstV

#### 第五步 统一结构为that 气动为this

也就是把SubstV 和RemV的forTop等函数的参数通过增加(Top that)来代替，因为结构类中已经追加了
结构属性(在Top Bot等初始原基和非初始原基中增加属性)

```java
class SubstV implements PieVistor1{
    Object n;
    Object o;
    public SubstV(Object _n, Object _o) {
        // TODO Auto-generated constructor stub
        this.n = _n;
        this.o = _o;
    }
    public Object forBot()
    {
        return new Bot();
    }
    public Object forTop(Object t,PieD r){
        if(o.equals(t)){
            return new Top(n,(PieD)r.accept(this));
        }else{
            return new Top(t,(PieD)r.accept(this));
        }
    }
}

```

修改为：(参考为ch081That包)
```java

class Top extends PieDUpdate {

    Object t;
    PieDUpdate r;
    public Top(Object t, PieDUpdate r) {
        // TODO Auto-generated constructor stub
        this.t = t;
        this.r = r;
    }
    @Override
    PieDUpdate accept(PieVistor1 ask) {
        // TODO Auto-generated method stub
        return ask.forTop(this);
    }
    public String toString() {
        return "new " + getClass().getName() + "(" + this.t + ", " + this.r + ")";
    }
}

//因为RemV SubstV Bot Top四个类极度相似，于是继续抽象。
interface PieVistor1{
    PieDUpdate forBot(Bot that);
    PieDUpdate forTop(Top that);
}

class RemV implements PieVistor1{
    Object o;
    public RemV(Object _o) {
        // TODO Auto-generated constructor stub
        this.o = _o;
    }
    //为什么要改为Public???
    public PieDUpdate forBot(Bot that){
        return new Bot();
    }
    //改用Object即可
    //public PieDUpdate forTop(Object t, PieDUpdate r){ //不能用int
    public PieDUpdate forTop(Top that){ //不能用int
        if(o.equals(that.t)){
            return that.r.accept(this); //this指代Remv对象
        }else{
            return new Top(that.t,that.r.accept(this));
        }
    }
}
```
结果
```java

new ch0801That.Top(5, new ch0801That.Top(10, new ch0801That.Bot))
new ch0801That.Top(300, new ch0801That.Top(5, new ch0801That.Top(10, new ch0801That.Bot)))
new ch0801That.Top(300, new ch0801That.Top(5, new ch0801That.Top(10, new ch0801That.Top(3, new ch0801That.Top(13, new ch0801That.Top(3, new ch0801That.Bot))))))
new ch0801That.Top(300, new ch0801That.Top(5, new ch0801That.Top(10, new ch0801That.Top(300, new ch0801That.Top(13, new ch0801That.Top(3, new ch0801That.Bot))))))
new ch0801That.Top(300, new ch0801That.Top(5, new ch0801That.Top(10, new ch0801That.Top(300, new ch0801That.Top(13, new ch0801That.Top(300, new ch0801That.Bot))))))
```
#### PiemanM的作用

只不过是为了侧是方便，在初始原基的基础上可以不断add,rem等基本函数特性。

概念总结：

原基：结构类，rem,subst等最终归并为accept，返回值boolean,int,TreeD等也归并为Object，参数均归并为访问者对象

初始原基: 一般代表递归的结束，直接返回对象
非初始原基(可吃原基):一般代表natural recursion，可以不断递归

行为V类：气动类，用于归并行为 比如早先的subst,rem等
行为接口: 气动类，比如PieVisitor， 提供forBot，forTop等服务，总结仍不到位!
行为变异接口：比如SubstV，RemV，LstSubstV,UnionV等

#### 第6步 修改实例属性，return that

```java
class SubstV implements PieVisitorI {
    Object n;
    Object o;
    SubstV(Object _n, Object _o) {
        n = _n;
        o = _o;
    }
    public Object forBot(Bot that) {
        return that; // interesting
    }
    public Object forTop(Top that) {
        if (o.equals(that.t))
            that.t = n;
            that.r.accept(this);
            return that; // interesting
        else
            that.r.accept(this);
            return that; // interesting
    }
}
```

---------------------------------------------------------------------------------

归纳：怎么把基类的所有行为归到一个accept函数(run，handle等函数),负责侦听服务。
公式： datatype  accept   interface (虚线连接，accept在虚线中间)
箭头表示extends
实现表示implements
说明： The method accepts a visitor and asks(问本身代表行为需求) for its(their) service(本身带有功能实现)
so we call accept as service!
we ask(行为) for services(目的)-----被问的对象都得有accept的功能,但问的对象也有比如下文的ReCall项目的Wang and Stranger
那么区分问与被问等于没说，没说就不写了
行为都具有一定目的性。

(有一个想法： (many hierarchy objects).accept(一个函数))
evaluator会不断解析many hierarchy objects,并对解析的object都运用函数进行apply。
所以这边依然体现着数据和行为分离的思想。数据单独在一块处理，行为又在另一块处理。
需要写过解释器才会明白这个意思----这里面也有pattern-match的思想（自身对象名和结构函数
名是一一对应的，而不用像解释器得把语句解析分为，number,symbol,lambda,cond,application等)。
还有一个三点一线地方--class名字---结构名字----ask.for名字，这三个名字是一致的

比如 
```java

public class Top
{  
    public Top(){};   

    public void accept(TopImplements ask){
        ask.forTop();
    }
}
```

P61 归纳了data part to understand what things is. action part to understand
how things work
P58开始提及data part 和action part
数据的抽象是为了进行分层架构，逻辑划分
行为的抽象是为了简化代码编写，实现多接口编程

P87 首次引入了this，表明行为接口对象，至此使用this，简化行为接口对象。
P89 在函数式编程 a visitor with fields is called as a closure(带属性的行为叫做closure)
通过定义closure的技术手段，结合构造函数，提取行为基类中的仅首次创建对象发生改变的fields
P92 首次引入interface的概念，直接引入，替换掉abstract，使用implements实现interface,由此首次
规约rem和subst等为accept（最大的基函数, 包含所有的rem，substv，occurs，has等)
P93 首次把ask当做VisitorI的形参名字，ask for service,所以使用改名字代表PieVistor的参数名字
至此完成了几乎全部工作
P112 首次采用Object类统一所有int,boolean,Tree等类型规约返回值（可能涉及装箱拆箱的过程),比如P114
P118 开始封装数字和集合四则运算
P150 拓展了接口UnionVisitor<-------------------可以多学习该思想， P157给出拓展图
P167 引入了that，在行为接口的对应函数引入Top that和Bot that，指代初始原基和非初始原基P168
很有意思，仔细看看，ask.forTop(this) 这么神奇？缩减形参列表统一为初始原基或非初始原基，用结构字段
来代替形参（事先已在...引入结构属性, 比如不断递归的循环体-一般是原基字段，即原基类的对象名)。

1. 首先进行行列转置
2. 归类为选行为数据基类(所有数据对象extends 行为数据基类, 问题是没有区分开action part和data part
目的是为了understand what actions these methods perform
3. 把行为V类引入到基类属性 P58
4. 把行为V类从属性引入到函数参数中（函数参数一般使用consume和produce进行描述，而在类属性一般使用field进行描述 P74 P86
行为V类引入了数据基类的形参，当然在一开始得功能函数中混合行为和数据，则是不需要形参的P58
这点为什么需要注意，因为构造函数有两个作用
4.1 natural recursion : 基类生成的自定义类，通过构造函数，传递剩余的数据r或者s，行为V类的实例对象函数实参负责接收
4.2 行为V类中充当closure(带属性，一般是用于构造函数的consume中）
5. 引入this函数 P87, this函数一般在行为V类中使用(得有创建行为对象值得能力)
6. 在行为基类中显示定义构造函数（默认有构造函数、不能叫引入），提取行为属性的不同，构造一个closure，
得到函数式编程的closure。？？
7. 引入interface P92 很有意思

注意: 当一个类实现一个接口，需增加"Public" ,把他添加实现方法的最前面.
P112 boolean,int,TreeD都属于Object，为了统一定义为Object返回类型即可(produce)
接口间可以相互extends！！一次继承，多个实现是java的语言特性。


成就点: java8的lambda编程，实现参数的行为化(名词动词话)


``` Perl
KebabD: [
{behaviors:[isVeggie(),whatHolder()]},
{objects:[Holder,Shallot,Shrimp,Radish,Pepper]}
];
RodD: [
{behaviors:[]},
{objects:[Dagger,Sabre,Sword]}
];

PlateD: [
{behaviors:[]},
{objects:[Gold,Silver,Braw,Copper,Wood]}
];
PointD: [
{behaviors:[distanceTo0(),closeTo0()]},
{objects:[CartesianPt(),ManhattenPt()]}
];
PizzaD: [
{behaviors:[remA(),topAwc(),subAbc()]},
{objects:[Crust,Cheese,Olive,Anchocy,Sansage,Spanish]}
];
ShishD: [
{behaviors:[onlyOnions(),isVegeterian()]},
{objects:[ShishD,Skew,Onion,Lamb,Tomato]}
];
SeasoningD: [
{behaviors:[]},
{objects:[Sage,Peper,Salt,Thyme]}
];

NumD: [
{behaviors:[]},
{objects:[Zero, OneMoreThan]}
];
PieD: [
{behaviors:[remA,remFish,remInt]},
{objects:[Bot,Top]}
];

FishD: [
{behaviors:[]},
{objects:[Anchovy,Salmon,Tuna]}
];

FruitD: [
{behaviors:[]},
{objects:[Peach,Apple,Pear,Lemon,Fig]}
];

TreeD: [
{behaviors:[accept(TreeVistorI)]},
{objects:[Bud,Flat,split}
];

SeasoningD: [
{behaviors:[]},
{objects:[]}
];
```

## Recall or Backcall

通过定义一个Callback接口，让Wang和Stranger具有callback特性，并且该类构造函数都知道
要找Ye问问题，通过线程的方式不断问问，执行Ye的executeMessage方法。

Ye也不是随便回答问题，针对不同的Instance有不同的解决方案，最后回调给对应的callback实现类。

---------------------------------------------------------------------------------

## Restaurant

很早之前写的关于反射的知识点。

1. 通过一个属性表*.property(名字=类名)
2. 通过Property函数读取该表，并通过class.newInstance得到对应类实例
3. 最后显示所有菜名

---------------------------------------------------------------------------------

## CIM

[cim(Cross IM)][5]适用于开发者的即时通讯系统, [ 策略模式的引入简化if-else ][8]


## 总结

### 逻辑1

我想要编写所有鸭子类的生态系统，因为这样方便我研究鸭子的生活习性
以便养农户能够更好地喂养鸭子，促进整个饲养届的发展

于是我把每一个鸭子的属性行为一一建立了一个类，记录起来，
写了10多种发现许多重复行为，于是单独把常见行为放到一个抽象类中。

### 逻辑2

我想要基于新的抽象类继续研究鸭子的生活习性……

但是发现每个鸭子对象类依然需要实现对应的函数有点麻烦，想了一个方法抽取飞或者吃等行为函数V
在行为函数V中添加对应鸭子类的具体飞或者吃等行为(for), 因为如果我这样做，我就可以进一步
观察到所有的函数都具有相似的样子，比如flyA和eatA其实只是字符不一样，形式一样，这是要第一步
我们可以统一所有行为为accept(对象接受删除、修改、添加等)
另外， 行为类也可以进一步抽象，因为他们也只是字符不一样，可以统一为DuckVistor ask
这样相当于行为调用函数accept和行为体(FlyV EatV)本身达到一致。

``` java

public abstract class Duck { //比萨饼
	
	//定义两个访问者
	//FlyV flyFn = new FlyV();
	//EatV eatFn = new EatV();
	abstract Duck flyA(FlyV flyFn);
	abstract Duck eatA(EatV eatFn);
}

```

###  逻辑3

我想要继续编写基于accept和行为接口抽象的方法，来实现整个鸭子生态系统，因为我可以比较轻松
记录鸭子生活习性，以便我可以整理出来相关结论，方便农场主进行科学合理的饲养，从而有利于
整个肉食行业的发展。

于是我在行为接口DuckVisitor中建立了很多抽象函数

``` java

 interface  DuckVisitorI{
	  Object forDuck(); //初始原基
	  Object forBlackDuck(Duck d); //非初始原基
	  Object forWhiteDuck(Duck d); //非初始原基
	  Object forBlueDuck(Duck d); //非初始原基
	  Object forRedDuck(Duck d); //非初始原基
      .....

  }
```

  然后我又定义了具体的飞类

  class FlyV implements DuckVistorI{

  ```java
  
	  Object forDuck()
      {
             printf("feifei");
      }//初始原基
      Object forBlackDuck(Duck d,...){
             printf("lala");
      } //非初始原基
      Object forWhiteDuck(Duck d,...){
            printf("dudu");
      } //非初始原基
      Object forBlueDuck(Duck d,...){
            printf("tutu");
      } //非初始原基
      Object forRedDuck(Duck d,...){
            printf("dodo");
      } //非初始原基
    .....
  }
  ```

  类似方法定义其他吃类等

  然后我生成鸭子类只需要实现基类的accept接口即可

  ``` java

   abstract class DuckD {
	   abstract Object accept(DuckVisitorI ask);
	  
   } // 鸭子原基(初始原基对象意味着循环的终止，非初始原基迭代继续，初始原基和非初始原基均基于原基)
   //初始原基构造函数一般为空(比如Bot)，非初始原基构造函数一般为初始原基(比如Top)
   
  ```
 
 我研究的第一个黑鸭子

 ```java
 
   abstract class BlackDuck {
   Object accept(DuckVisitorI ask){
      ask.forBalckDuck(...); //我只要在forBlackDuck写上行为即可
   }
	  
   } 
 ```

 以此类推，现在定义鸭子很简单

### 逻辑4

我发现forBlackDuck的参数其实就是BlackDuck的属性值，于是统一用Bot that或者Top That, BlackDuck That等初始和非初始原基类代替即可
这样可以简化代码

而在行为类比如飞类可能有具体的属性值(带有构造函数和属性的行为类叫做closure)

比如
```java

class FlyV implements DuckVistor1{
	Object n;
	Object o;
	public FlyV(Object _n, Object _o) {
		// TODO Auto-generated constructor stub
		this.n = _n;
		this.o = _o;
	}
	public Object forBlackDuck(BlackDuck that)
	{
		return new Duck();
	}
	//public Object forRedDuck(Object t,PieD r){
	public Object forRedDuck(RedDuck that){
		if(o.equals(that.t)){
			return new RedDuck(n,(PieD)that.r.accept(this));
		}else{
			return new RedDuck(that.t,(PieD)r.accept(this));
		}
	}
}

class EatV implements DuckVistor1{
    Object o;
    public EatV(Object _o) {
        // TODO Auto-generated constructor stub
        this.o = _o;
    }
    //为什么要改为Public???
    public Duck forBlackDuck(BlackDuck that){
        return new Bot();
    }
    //改用Object即可
    //public Duck forTop(Object t, Duck r){ //不能用int
     public Duck forRedDuck(Redduck that){ //不能用int
        if(o.equals(that.t)){
            return that.r.accept(this); //this指代Remv对象
        }else{
            return new RedDuck(that.t,that.r.accept(this));
        }
    }
}
```

这样我定义鸭子又会有点不一样

```java
class RedDuck extends Duck {

    Object t;
    Duck r;
    public Top(Object t, Duck r) {
        // TODO Auto-generated constructor stub
        this.t = t;
        this.r = r;
    }
    @Override
    PieDUpdate accept(PieVistor1 ask) {
        // TODO Auto-generated method stub
        return ask.forRedDuck(this); ////////////////// Interesting , 代表RedDuck对象，因为只是为了访问t和r而已
    }
    public String toString() {
        return "new " + getClass().getName() + "(" + this.t + ", " + this.r + ")";
    }
}


```

### 逻辑5

在此基础上，其实forRedDuck和forBlackDuck等都可以统一为for(Duck ...) 因为可以通过Duck类型来判断
哪种for，比如for(BlackDuck t, ...)
for(RedDuck t, ...)
也就是行为接口函数不需要写上一堆的for哪个哪个对象，直接for(...)根据参数类型重载(一个类里面，方法名字相同，而参数不同)所有的for方法。

但是这样不好，因为BlueDuck有可能具有全新的属性，但是Duck没有，这会导致属性值存在问题，具体可以参考[设计模式学习][9]

所以暂时放弃！可以通过代理方法等，进一步简化调用过程。

### 逻辑6

后来发现DuckVisitor ask 变成ThingVisitor prepare 
那么以后你就可以定义很多thingObject, 比如审查对象(CheckThing)，提交对象(SubmitThing), 

prepare.ForCheck(Thing..)
prepare.ForSubmit(Thing..)
prepare.ForUpdate(Thing..)
prepare.ForUpgrade(Thing..)
prepare.ForChildRen(Thing..)
prepare.ForWedding(Thing..)
prepare.ForTourist(Thing..)
prepare.ForExamination(Thing..)
prepare.ForPractice(Thing..)


---------------------------------------------------------------------------------

[1]: https://a-little-java-a-few-patterns.readthedocs.io/zh_CN/latest/
[2]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/eval-apply.png
[3]: https://www.researchgate.net/publication/221598672_How_Do_Procurement_Networks_Become_Social_Design_Principles_Evaluation_in_a_Heterogeneous_Environment_of_Structured_and_Unstructured_Interactions
[4]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/design.jpg
[5]:https://github.com/crossoverJie/cim 
[6]:http://jueqingsizhe66.github.io/blog/2017/08/11/from-little-scheme-to-season-scheme/ 
[7]:http://jueqingsizhe66.github.io/blog/2015/05/17/cong-lambdadao-simple-plus-complexjie-shi-qi-zai-dao-shu-xing-chou-xiang/ 
[8]: https://mp.weixin.qq.com/s/N4jJLG6EP55OJmyYv5lcFg 
[9]:https://github.com/jueqingsizhe66/DesignPattern 
