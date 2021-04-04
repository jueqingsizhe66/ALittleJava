[A little java笔记][1]

Evaluate(interpret) all the hierarchy objects, apply coresponding operators to every objects.

Introspect 和 retrospect具有类似的地方(review ,look back on, backcall)
(watch your soul inside)
经常用的In retrospect.
![eval-apply][2]

[How Do Procurement Networks Become Social? Design Principles Evaluation in a Heterogeneous Environment of Structured and Unstructured Interactions][3]

![design][4]

----------------------------------------------------------------

根据本文的学习，应该反复问自己两个问题，每个类都有0和1的概念！
- 0是什么? 0是Zero? "Zero"类可以没有field也可以有Object field(比如Holder的Object字段，Skewer没有字段)。
  0是产业链，解决技术产品快速落地问题。
- 1是什么? 1是One? "One"类的field一般都是对应datatype，比如Olive的PizzaD字段。
  1是生态链，解决的是技术的建设、优化设计，形成大规模的生态产业圈，打造上层建筑。

0 vs 1 is similar to "from vs to", which can be joined together "from 0 to 1", actually means
nodes and edges, or commits picture in the history of git push.(form 1 to 3 or more)

0和1不是小问题:
- 0解决递归终点(什么时候结束)，落地的事情。
- 1解决递归过程(怎么结束)，迭代优化的事情。

后来琢磨发现，0和1的不同其实也体现在构造器(而这个构造器在newHasPt又有点用途)，1的构造器肯定有字段，
0的构造器大部分是无参构造器

[orfu][17] 看到*handler*的作用(针对不同情况*handle*不同事情)

orfu-handle-list处理方法容器：

- orfu--handle-link
- orfu--handle-link-github
- orfu--handle-link-youtube
- orfu--handle-current-buffer
- orfu--handle-project

----------------------------------------------------------------
## 目录
<!-- markdown-toc start - Don't edit this section. Run M-x markdown-toc-refresh-toc -->
**Table of Contents**

- [-](#-)
- [对象和行为](#对象和行为)
- [abstract 、 class 、 extends 各代表什么？](#abstract--class--extends-各代表什么)
    - [The thinking of characteristics vector](#the-thinking-of-characteristics-vector)
    - [集中于行为](#集中于行为)
    - [研究出发点](#研究出发点)
    - [研究发展过程：](#研究发展过程：)
        - [第一步：](#第一步：)
        - [第二步：(开始出现访问者字眼)](#第二步：开始出现访问者字眼)
        - [第三步：（引入行为V类参数到构造函数)](#第三步：引入行为v类参数到构造函数)
        - [第四步: 行为V类变为行为接口(interface  TreeVisitor)](#第四步-行为v类变为行为接口interface--treevisitor)
            - [closure的出现](#closure的出现)
        - [第五步 统一所有的操作函数为this，非操作函数为that](#第五步-统一所有的操作函数为this非操作函数为that)
        - [PiemanM的作用](#piemanm的作用)
        - [第6步 修改实例属性，return that](#第6步-修改实例属性return-that)
    - [I am acceptor](#i-am-acceptor)
        - [递归模式](#递归模式)
        - [对象类中：](#对象类中：)
        - [接口类中(行为类):](#接口类中行为类)
    - [章节索引](#章节索引)
        - [附录代码](#附录代码)
    - [Recall or Backcall](#recall-or-backcall)
    - [Restaurant](#restaurant)
    - [CIM](#cim)
    - [总结](#总结)
        - [逻辑1](#逻辑1)
        - [逻辑2](#逻辑2)
        - [逻辑3](#逻辑3)
        - [逻辑4](#逻辑4)
        - [逻辑5](#逻辑5)
        - [逻辑6](#逻辑6)
        - [python装饰器模型](#python装饰器模型)
            - [最简单装饰器](#最简单装饰器)
            - [较复杂装饰器](#较复杂装饰器)
    - [Macro lisp](#macro-lisp)
    - [加入Maven支持](#加入maven支持)
    - [函数式编程方法(输入输出驱动)](#函数式编程方法输入输出驱动)
        - [第一条建议:](#第一条建议)
        - [第三条建议](#第三条建议)
            - [拓展延伸(lisp部分)](#拓展延伸lisp部分)
    - [<2020-09-20 09:17> 增量阅读](#2020-09-20-0917-增量阅读)
        - [newHasPt新用法?](#newhaspt新用法)
        - [Subst?](#subst)
        - [PiemanM](#piemanm)
        - [动态方法](#动态方法)
        - [什么是value?](#什么是value)
        - [what is zero?](#what-is-zero)
    - [五层架构](#五层架构)
    - [附录](#附录)
        - [PointD?](#pointd)
        - [Zero  VS OneMoreThan](#zero--vs-onemorethan)
        - [Base vs Slice](#base-vs-slice)
        - [Skewer Vs [Onion , Lamb , Tomato]](#skewer-vs-onion--lamb--tomato)
        - [Holder vs [Shallot , Shrim, Radish]](#holder-vs-shallot--shrim-radish)
        - [Rod ---> Dagger Sabre Sword](#rod-----dagger-sabre-sword)
        - [Plate--> Gold Silver Brass Copper Wood](#plate---gold-silver-brass-copper-wood)
        - [Crust vs [Cheese Olive Anchovy Sausage]](#crust-vs-cheese-olive-anchovy-sausage)
        - [ShishD的进化](#shishd的进化)
        - [Bot Vs Top](#bot-vs-top)
        - [伟大的interface出现了](#伟大的interface出现了)
        - [Bud vs [Flat Split]](#bud-vs-flat-split)
    - [两个有趣的点](#两个有趣的点)
    - [正向-反向链](#正向-反向链)

<!-- markdown-toc end -->

## 对象和行为

一个访问模式包含着一片对象和一类行为，行为中又可以根据相同和不同点划分不同的风格(style)和类别

A type is a name for a collection of values

Define-Datetype(Abstract)相当于定义了一个类型，比如KebabD,RobD

## abstract 、 class 、 extends 各代表什么？

1.    `abstract` 定义类型(基本类型)
2.    `class` 定义子类型(自定义类型)
3.    `extends` 将以上两者联系起来(连接起来),属性和行为联合起来,也就是可以使用super(x,y)进行父类构造


核心点：通过构造函数（类似于y lambda的功能）  按照natural recursion 不断递归到结尾。

技术点: 把基类的字段添加到自定义类中，通过构造函数的参数赋值，在终止类(terminal class)不添加该
基类字段，直接返回值(new),递归结束
Object是FishD,Int等所有类的父类，最原始类

原基：结构类，rem,subst等最终归并为accept，返回值boolean,int,TreeD等也归并为Object，参数均归并为访问者对象

初始原基: 一般代表递归的结束，直接返回对象
非初始原基(可吃原基):一般代表natural recursion，可以不断递归

行为V类：气动类，用于归并行为 比如早先的subst,rem等
行为接口: 气动类，比如PieVisitor， 提供forBot，forTop等服务，总结仍不到位!
行为变异接口：比如SubstV，RemV，LstSubstV,UnionV等

### The thinking of characteristics vector

1.定基(Define interfae in software interfaces; define base of ground in building engineering)

2.变基(expand the macros to let it different)

3.组基(compose the similar and useful objects into one products) 

4.升基(update your vectors to update your products) 


### 集中于行为

在定基的基础上，或者在当前的所获得的的知识结构的基础上，想要寻求做什么? 突破已经做了什么？
应该集中于行为的思考，抛开objects，而关注behaviors，也就是下图中的functions部分。
对象会call行为接口(线程开辟)，行为实现类会去实现对应类的实际行为，但是行为是否ok？

**数据或者参数序列去找函数!!!**

1. 行为是否有效？方便?(行为管理也包括两个层次，一个是为，另外一个是有所作为，有成效! 行之有效，方为管理)
2. 行为是否有益？
3. 行为是否可持续?
4. 行为是否可改善?

![behaviors][12]

### 研究出发点

- pizza-pie(注意pizza结合pie使用top和bot的方式)
- "Think first, experiment later"
- 
- 
- 出发点1: 防止overhelming的信息
  - But we don't know of a better way to organize these definitions yet. 
        Wasn't this last collection overwhelming?
        Because it becomes more and more difficult
        to understand the rationale for each of the
        methods in a variant and what the
        relationship is between methods of the same
        name in the different variants.
- 出发点2: super(x,y), 联想到他的作用
        The expressions super(_x,_y) in the constructors CartesianPt and ManhattanPt
        create a PointP with the appropriate fields, and the respective constructor guarantees
        that the point becomes a CartesianPt or a ManhattanPt.
- 出发点3: characterizing everything for the PointD?
    - Do we now have everything that characterizes PointPs in the datatype?
    - Default constructors never consume values, and, when used with new , always create objects without fields. 
    - accept接收访问者，并立即反向调取核心功能(instantly)，这也是点号和函数调用的意思
      new立即调用构造函数，并递归调用accept的相关方法
    - why do we need to know the meaning of the ...? what is the value of ...?
    - how do we determine the answer for ...?  we need to determine one more time which version of function we must use.
    - 函数versions(funct-v1.0.1)
- 出发点4：this，以及可改变的this(new LisSubst(c-1, n,t,r)),this代表所有的visitors;  that 代表所有datatypes
  this 和 that来回变换。
- 出发点5: We want all the methods in one class.  
   And that's the whole point. what point?
   Those methods that would have the same name if we placed them into the variants of a datatype in one class.
   That's what we are about to do. We are going to separate the action from the datatype.
- 出发点6: 分离行为和数据类型
- 出发点7：You never know when it might be useful, even if it does not contain any interesting information. 
   let's just consider RemV

- 出发点8: hands over!
    Simple: rem asks for the forBot service from
    remFn and hands over the Object it
    consumes; subst asks for the forBot service
    from substFn and hands over the two Objects
    it consumes
 
    ---field values and two objects 替换the object(自然递归)
    Simpler: rem asks for the for Top service
    from remFn and hands over the field values
    and the Object it consumes; subst asks for
    the for Top service from substFn and hands
    over the field values and the two Objects it
    consumes.
    ---结果： That's right. Nothing else changes in the variants. Instead of relying on fields of the datatype, 
    we use what is   consumed.
    We still have some work to do. 
    Consuming an extra value here also affects how the methods rem and subst are used.

## 研究发展过程：

### 第一步：


- 首先是把不相关的属性放入自定义类中，

- 然后是把基类和需要的属性的输入放入自定义类中，

后来是多个行为基类(也叫作行为基函数，省略掉必要的属性, 比如
- PizzaD的remA,topAwc,subAbc)
放入其中

出现的问题1: 每个自定义子类都有一堆的基类函数需要实现, 这也是我们最先想到方法，

比如鸭子会飞、会叫、会游泳会吃，

- 于是黑鸭子也都会，
- 黄鸭子也会，
- 蓝鸭子也会，
- 臭鸭子也会 很多很多)

此时，我们用笨方法实现了不同鸭子类, 并且这时候已经有了构造函数的概念(new Olive(new ..))的样子。
每一个子类都会出现父类(原基字段，一般和构造函数对应上)。

原基不断进行迭代，构成了生态链---原基生态链，比如

- PizzaD、
- ShishD、
- LayerD、
- PointD等都是原基

原基之上有不能吃的子基和能吃的子基(什么是能吃？ 什么是不能吃?)

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

初始原基，即不能吃原基,递归出口，return ture，不进行recursion
初始原基目的帮你认识什么时候程序终止。

比如Crust类
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

可以和非初始原基（natural recursion,可以吃)比较一下,比如Cheese: return newCheese, ，
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

### 第二步：(开始出现访问者字眼)

   提出一个自定义的V类，实现所有针对于各个对象的for函数，然后把V类添加到基类中，并且生成值，
自定义类通过V类值来实现抽象行为。
   然而并没有解决问题，只是把所有类的行为，抽象到一个行为V类，
在该V类，对应各个自定义类的具体实现，相当于横排竖排转置而已，

   没产生一个新自定义类，你的每一个
行为V类得重写，新的自定义类依然得对对应套餐行为进行实现。 

  这种想法也是我们能够想到的，我们知道常见的鸭子有
  
- 黑鸭子、
- 黄鸭子、
- 蓝鸭子、
- 臭鸭子， 
 
我们把他们飞的行为抽象成一个类，飞类，他们叫的行为抽象成一个类，叫类，.... 
这时候相当于把行为当做横排，而不像上面的把不同鸭子当
做一个一个记录或者叫排，然后我们针对每一类鸭子，完成飞类、叫类等的实现，

这时候针对每一个类型的鸭子，只需要引入该V类调用对应的方法即可，也就是具体的实现都移到了V类去干抽象出行为特点！！

现在是开始要展现与众不同的地方，因为你只要去V类干活就可以，
在鸭子的自定义类中只是去调用V类的对应行为，当然你也可以说上面的方法也可以，
我只要到对应鸭子类的对应行为修改就可以了

好正如上面说的，这种转置变换到此时并没有太多的进步

中间变异原基示例:(原基引入访问者)，而在原基定义的函数也叫作基函数
(基本功能、基本功能，在其他访问者接口实现具体功能)

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
### 第三步：（引入行为V类参数到构造函数)          

  把基类中的行为V类放到基函数(构造函数)的参数中，而不是放在基函数的字段field中，减少了基类函数长度。
关键的this出现了，在行为类中引入this. 

this的出现使得代码本身具有闭包的感觉(yes?)。this指代当前访问者本身（也就是说这一步的重要改进就是通过基函数和this改变了代码的显示风格代码量没有太多实质性的减少，
只不过从字段移到了参数，感觉行数少了，但是单词数也多了 
这是第二次进化在此基础上，开始进行第三次进化，把固定不变的量提到访问者V类(the occurrence of closure concept)，比如rem，删除某个东西是固定的，于是改进行为V类的构造函数，
这样可以减少核心函数的参数个数,比如subst，从什么变到什么，也是不变的，于是也提到行为V类中

在这次进化中，由于你把rem和subst的变化都提到行为V类中，于是对应的自定义类中的基函数实现很像出现重复性代码，考虑进行第四次进化

### 第四步: 行为V类变为行为接口(interface  TreeVisitor)        

把行为V自定义类的方法抽象出一个接口函数，然后行为V类都实现改接口(implements在第四次进化中出现了)

这时候你会去分析行为的异同，对行为接口基函数的实现，和基类基函数(1. 基向量  2.特征向量)的实现分开， 
你需要对基类进行修正， 行为V类已经通过行为基类结合在一起，那么对应的基类的基函数，
也得用行为基类进行expand.

行为基函数得浓缩为一个函数，accept(第四次进化很丰富，统一为accept)
(interface的出现也带来了accept函数的归并...参考P92)
基类基函数只存在一个accept函数了这时候你会看到很爽 ，很刺激的感觉。 因为代码量急剧下降了！
此时构建新的行为V类也会简单一些。

通过四次进化，得到关键概念： 

- 基类(行为基类)，
- 行为V类，
- 基函数，
- 函数参数，
- 构造函数，
- 行为基函数，
- 行为自定义V类
- abstract,
- new,
- extends, 
- super, 
- this, 
- interface,
- implements

#### closure的出现

另外由于行为追加了行为属性，把一些不变的属性纳入行为的字段，通过构造函数幅值，
不需要handle forward and back传来传去，直接用that.t 和that.r来代替,
这也叫做闭包(行为追加属性)。
可以参考第五步的SubstV

### 第五步 统一所有的操作函数为this，非操作函数为that

也就是把SubstV 和RemV的forTop等函数的参数通过增加(Top that)来代替，
因为*结构类*中已经追加了结构属性(在Top Bot等初始原基和非初始原基中增加属性)

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
    this.t = t; this.r = r;
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

### PiemanM的作用

只不过是为了测试方便，在初始原基的基础上可以不断add,rem等基本函数特性。
PieManM的作用不改变具体的事情，他只是改变了如何做事情
(他是one, 而不是zero，他是生态链而不是产业链)


### 第6步 修改实例属性，return that

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

归纳前得把所有函数具备primitive或者lambda属性得思考清楚，请参考[VIP14装饰器][17]
    lambda具有第一成员属性。
    
归纳：怎么把基类的所有行为归到一个accept函数(run，handle等函数),负责侦听服务。
公式： 
                        datatype  accept   interface (虚线连接，accept在虚线中间)
- 箭头表示extends
- 实现表示implements
- 
说明： The method accepts a visitor and asks(问本身代表行为需求) for its(their) service(本身带有功能实现)
and hands over all the objects service needed.
so we call accept as service!

we ask(行为) for services(目的)-----被问的对象都得有accept的功能,
但问的对象也有比如下文的ReCall项目的Wang and Stranger
那么区分问与被问等于没说，没说就不写了
行为都具有一定目的性。

(有一个想法： (many hierarchy objects).accept(一个函数))

evaluator会不断解析many hierarchy objects,并对解析的object都运用函数进行apply。

体现着数据和行为分离的思想:
- 数据单独在一块处理，
- 行为又在另一块处理。
 
需要写过解释器才会明白这个意思---
- 这里面也有pattern-match的思想（自身对象名和结构函数
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

## I am acceptor

我会使用new new new new new的方式创建对象?
不太会，遍历所有对象? 但是想法可以这样思考

### 递归模式

1. 递归调用的方式(new 方法  构造函数截取  r.accept(this))
2. 停止递归的出口(return true or false)

### 对象类中：

1. 引入行为类字段(fields)
2. 改为引入行为方法类形参(consume)
3. 改为行为方法形参统一为接口closure类
4. 统一所有对象函数为accept(接口父类)

### 接口类中(行为类):

1. 方法类中添加行为内容(删掉什么? 替换什么)
2. 改为方法构造类中添加行为内容(删掉什么? 替换什么?)
3. 改为行为方法形参统一为接口closure类

不断改进地过程中，体现设计模式带你不一样的感觉。

![I am acceptor][14]


## 章节索引

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

P150 拓展了接口UnionVisitor<-------------------可以多学习该思想， 

P157给出拓展图

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

java8的lambda编程，实现参数的行为化(名词动词话)

### 附录代码

``` Perl
KebabD: [
    {behaviors:
        [isVeggie(),whatHolder()]},
    {objects:
        [Holder,Shallot,Shrimp,Radish,Pepper]}
];
RodD: [
    {behaviors:
        []},
    {objects:
        [Dagger,Sabre,Sword]}
];

PlateD: [
    {behaviors:
        []},
    {objects:
        [Gold,Silver,Braw,Copper,Wood]}
];
PointD: [
    {behaviors:
        [distanceTo0(),closeTo0()]},
    {objects:
        [CartesianPt(),ManhattenPt()]}
];
PizzaD: [
    {behaviors:
        [remA(),topAwc(),subAbc()]},
    {objects:
        [Crust,Cheese,Olive,Anchocy,Sansage,Spanish]}
];
ShishD: [
    {behaviors:
        [onlyOnions(),isVegeterian()]},
    {objects:
        [ShishD,Skew,Onion,Lamb,Tomato]}
];
SeasoningD: [
    {behaviors:
        []},
    {objects:
        [Sage,Peper,Salt,Thyme]}
];

NumD: [
    {behaviors:
        []},
    {objects:
        [Zero, OneMoreThan]}
];
PieD: [
    {behaviors:
        behaviors[remA,remFish,remInt]},
    {objects:
        [Bot,Top]}
];

FishD: [
    {behaviors:
        []},
    {objects:
        [Anchovy,Salmon,Tuna]}
];

FruitD: [
    {behaviors:
        []},
    {objects:
        [Peach,Apple,Pear,Lemon,Fig]}
];

TreeD: [
    {behaviors:
        [accept(TreeVistorI)]},
    {objects:
        [Bud,Flat,split}
];

SeasoningD: [
    {behaviors:
        []},
    {objects:
        []}
];
```

## Recall or Backcall

通过定义一个Callback接口，让Wang和Stranger具有callback特性，并且该类构造函数都知道
要找Ye问问题，通过线程的方式不断发出请求，执行Ye的executeMessage方法(逐个对象处理不同对象的提问)。


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

```
    prepare.ForCheck(Thing..)
    prepare.ForSubmit(Thing..)
    prepare.ForUpdate(Thing..)
    prepare.ForUpgrade(Thing..)
    prepare.ForChildRen(Thing..)
    prepare.ForWedding(Thing..)
    prepare.ForTourist(Thing..)
    prepare.ForExamination(Thing..)
    prepare.ForPractice(Thing..)

```

### python装饰器模型

python装饰器支持[多层嵌入装饰器][10]

重新思考装饰器 2021-01-31 
装饰器涉及到函数变量再赋值的过程，隐式过程为lambda内存门牌(门牌代表变量名或者函数名，lambda活化为具备函数调用机制!)

装饰器
    定义：本质是函数（器：就是函数的意思），功能：装饰其他函数，就是为其他函数添加附加功能
    原则：
        1. 不能修改被装饰的函数的源代码
        2. 不能修改被装饰的函数的调用方式

    实现装饰器知识储备：
        1. 函数即"变量"
        2. 高阶函数
            a: 把一个函数名当做实参传给另一个函数（在不修改被装饰函数源代码的情况下为其添加功能）
            b: 返回值中包含函数名 (不修改函数的调用方式)
        3. 嵌套函数
#### 最简单装饰器

2年前跟着写了这些函数，但是并不知道怎么用！

- 什么叫高阶函数?
- 什么叫嵌套函数?
- 什么叫不改变被修饰函数的源代码？
- 什么叫不改变被修饰函数的源代码的执行方式？(得用嵌套定义装饰器，return一个函数(高阶属性))
- 
``` python
def timer(fun):
def deco():
    startime=time.time()
    fun()
    endtime=time.time()
    print("the func run time is %s" %(endtime-startime))
    pass
return deco

# deco(test1)
# deco(test2)
# test1()
#
# print("装饰器")
# test3=timer(test1)

@timer
def test3():
    time.sleep(3)
    print("in the test3")

    test3()

```
#### 较复杂装饰器

1. 加入单参数
2. 加入多参数
3. 返回return值
4. 支持切面传值(传参)

```python

user='yzl'
passwd='45'
def auth(auth_type):
    print("Authentication type is ",auth_type)
def outer_wrapper(func):
    def wrapper(*args,**kwargs):
        print("wrapper func args:",*args,**kwargs)
        if(auth_type=="local"):
            print("本地验证")
            username=input("username:").strip()
            password=input("password:").strip()
            if password==passwd and user==username:
                print("\033[32;1mUser has passed authentication\033[0m")
                res= func(*args,**kwargs)
                print("after authentication new added")
                return res
            else:
                exit("\033[32;1m Invalid username or password\033[0m")
            elif auth_type=="ldap":
            print("I don't understand ldap")
            return wrapper
    return outer_wrapper

def index():
print("welcome to index page")

@auth(auth_type="local")
def home():
    print("welcome to Home page")
    return "from Home"


@auth(auth_type="ldap")
def bbs():
    print("welcome to BBS page")

    index()
    print(home())
    bbs()
```

## Macro lisp 

[The power of lisp][11]

``` lisp
(defmacro name (parameter*)
  "Optional documentation string."
  body-form*)
```

Like a function, a macro consists of a name, a parameter list, an optional documentation string, and a body of Lisp expressions.
1 However, as I just discussed, the job of a macro isn't to do anything directly--its job is to generate code that will later do what you want.

One hole one name, One person one name(maybe many names in different occasions)


进一步观看[clojure component is enough][13]这个视频

1. locally config(Static config)
2. dynamic (Run State)
3. lifycycle
4. Constructos
5. dependencies inject


## 加入Maven支持
YeRestaurant引入hutool

## 函数式编程方法(输入输出驱动)
the functional (input-output driven) method of program
design naturally leads to the use of well-known object-oriented design patterns


1. 驱动Driver其实就是注册类,放入可调用、可追踪范围内(势力范围内，招进来)
2. 连接Connection就是调用注册类，创建实例(用起来)
3. 实际的工作过程

### 第一条建议: 

        When specifying a collection of data,
        use abstract classes for datatypes and
        extended classes for variants.

java的基本类型(并非对象，是不完整的对象)不能直接作为自定义类型来使用，而是先和自定义类型
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
                    ((insert-g seq) new old (cdr l))))))))
;;; So we can define insertL again with insert-g *****************************^-^************************************
;;; Do not pass in seqL this time.
(define insertL1
    (insert-g
        (lambda (new old l)
            (cons new (cons old l)))))

```

----------------------------------------------------------------------------------

## <2020-09-20 09:17> 增量阅读

关于the little java的增量阅读

### newHasPt新用法?
P161 为什么HasPt 或者UnionHasPt多了一个constructors? newHasPt? 
     还是有很多不明白？ 
``` java

```

### Subst?
P176 subst : no news is good news?

### PiemanM
P177 because the PiemanM manages the toppings of p, and nobody else sees p.
     管理员模式统一管理，接管接口的能力

``` java

interface PiemanI{
	
	int addTop(Object t);
	int remTop(Object t);
	int substTop(Object n, Object o);
	int occTop(Object o);
}

class PiemanM implements PiemanI{

	PieD p  = new Bot();
	public PiemanM(PieD _p) {
		// TODO Auto-generated constructor stub
		this.p = _p;
	}
	@Override
	public int addTop(Object t) {
		// TODO Auto-generated method stub
		p = new Top(t, p);
		return occTop(t);
	}

	@Override
	public int remTop(Object t) {
		// TODO Auto-generated method stub
		p = (PieD)p.accept(new RemV(t));
		return occTop(p);
	}

	@Override
	public int substTop(Object n, Object o) {
		// TODO Auto-generated method stub
		p =(PieD)p.accept(new SubstV(n,o));
		return occTop(p);
	}

	@Override
	public int occTop(Object o) {
		// TODO Auto-generated method stub
		return ((Integer)p.accept(new OccursV(o))).intValue();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

}
```


### 动态方法

java是接收者[ 动态分配 ][15], 按子类调用对应 被操作对象.accept (行为访问类)，动态分配置换掉某个方法，发生在运行期，而 针对于参数则是使用静态方式【发生在编译期】，也就是使用父类方式

``` java
With DataType_oLlnterface y = new _, create the object y with which you wish to experiment.
```

### 什么是value?

1. Type is a name for a collection of values(Type is a set!)(类型是一种值的集合，范畴类 , 也叫作datatype, 由data组成的type)
2. value can be int or boolean(basic type) and also extended class(high type)(值包含基础类型primitive type 和高级类型closure type or non-basic type，都是第一公民)
3. New uses the constructor functors to construct a instance of one type(使用构造函数创建一个类实例)
4. everything created with `new` is an `Object`, the class of all objects. but 5 is not, because 5 is primitive type,
can not be newed. 5并不是Object!!! <2020-09-20 22:16> , `new Integer(5)` is an object, which means that Integer creates an
object from an int 5. The similar is `new Boolean(false)` 


### what is zero?

0 is not the same as new Zero(), because new Zero() is NumD , but 0 is not!

``` java
new OneMoreThan(
    new OneMoreThan(
        new OneMoreThan(
            new OneMoreThan(
                new Zero()))))
```
Are there more NumDs than booleans?  lots!
Are there more NumDs than ints?  No, Java limits the number of ints to approximately 2^32

Zero相当于NumD的作用类似于Holder() 烤架、Skewer()、Crust() Bot(), Skewer()相对于ShishD 都是最基本的初级类！在此基础上，构造成整个生态类，
他处于金字塔底层，确至关重要！

```java
abstract class PointD{
}

class CartesianPt extends PointD{
    int  x;
    int  y;
    CartesianPt(int _x, int  _y){
        x= _x;
        y= _y;
    }
}

class ManhanttanPt extends PointD{
    int  x;
    int  y;
    ManhanttanPt(int _x, int  _y){
        x= _x;
        y= _y;
    }
}

```
在代码中建议到constructors结束的位置使用`\\---------------------------`



## 五层架构

1. 项目(包含很多包)
2. 包(非public类相互访问)或者模块("包"包含类、接口、抽象)
3. 类(定制类、内置类)、接口、抽象类(类直接包含函数和字段， 统一为类字段)
4. 函数(comsume参数)、类字段 ---> 统一为类字段(函数类似字段, 函数式第一公民)
5. 函数参数(类名字+字段名字)


分层架构也体现在职能公司的划分，先得有一个dataype!同类相聚！然后由此衍生出很多其他子类，
如果不站在这个高度很多情况我们只能从底面开始思考，而不能从上往下思考！

我们的思维习惯是从一堆乱七八糟的事物中理出分层架构，而为什么我们不能从空中直接思考，并逐渐落地？！
The-little-java也是想告诉你这个特点，从datatype(abstract、interface)思考整个生态链架构。 
2020-10-02 有用！



---------------------------------------------------------------------------------

## 附录

### PointD?


``` java
  abstract class PointD{
      int  x;
      int  y;
      PointD(int _x, int  _y){
          x= _x;
          y= _y;
      }
      //----------------------------------
      boolean closerToO(PointD p){
          retrun distanceToO <= p.distanceToO();
      }
      abstract int distanceToO();
  }

  class CartesianPt extends PointD{
      CartesianPt(int _x, int _y){
          super(_x, _y);
      }
      //---------------------------------
      int distanceToO(){
          return sqrt(exp(x,2)+exp(y,2));
      }
  }

  class ManhanttanPt extends PointD{
      ManhanttanPt(int _x, int  _y){
          super(_x, _y);
      }
      //---------------------------------
      int distnceToO(){
          return x+y;
      }
  }

```

### Zero  VS OneMoreThan

``` java
   abstract class NumD{}

   class Zero extends NumD{}

   class OneMoreThan extends NumD{
  NumD predeccessor;
  OneMoreThan(NumD _p){
     predeccessor = _p;
    }
  //-----------------------------------------
  }
```

### Base vs Slice


``` java
  abstract class LayerD{}

  class Base extends layerD{
      object o;
      Base(object _o){
          o = _o;
      }
  //--------------------------------
  }

  class Slice extends layerD{
      LayerD l;
      Slice(LayerD _l){
          l = _l;
      }
  //---------------------------------
  }
```

### Skewer Vs [Onion , Lamb , Tomato]

``` java
  abstract class ShishD{
      abstract boolean onlyOnions(); //-----------所有继承类都得实现了
      abstract boolean isVegetarian();

  }

  class Skewer extends ShishD{
      boolean onlyOnions(){
          return true;
      }
      boolean isVegetarian(){
          return true;
      }

  }

  class Onion extends ShishD{
      ShishD s;
      Onion(ShishD _s){
          s= _s;
      }
      //--------------------------------

      boolean onlyOnions(){
          return s.onlyOnions();
      }
      boolean isVegetarian(){
          return s.isVegetarian();
      }

  }

  class Lamb extends ShishD{
      ShishD s;
      Lamb(ShishD _s){
          s= _s;
      }
      //--------------------------------

      boolean onlyOnions(){
          return false;
      }
      boolean isVegetarian(){
          return false;
      }
  }

  class Tomato extends ShishD{
      ShishD s;
      Tomato(ShishD _s){
          s= _s;
      }
      //--------------------------------
      boolean onlyOnions(){
          return false;
      }
      boolean isVegetarian(){
          return s.isVegetarian();
      }
  }
```

### Holder vs [Shallot , Shrim, Radish]


``` java
  abstract class KebabD{
      abstract boolean isVeggie();
      abstract Object whatHolder(); // ----Object 代表是Zero的地方 可以任何事物
  }

  class Holder extends KebabD{
      Object o;
      Holder(Object _o){
          o = _o;
      }

      // -------------------------

      abstract boolean isVeggie(){
          return true;
      }
      abstract Object whatHolder(){
          return o;
      }
  }

  class Shallot extends KebabD{
      KebabD k;
      Shallot(KebabD _k){
          k = _k;
      }

      // -------------------------

      abstract boolean isVeggie(){
          return k.isVeggie();
      }
      abstract Object whatHolder(){
          return k.whatHolder();
      }
  }


  class Shrimp extends KebabD{
      KebabD k;
      Shrimp(KebabD _k){
          k = _k;
      }

      // -------------------------

      abstract boolean isVeggie(){
          return false;
      }
      abstract Object whatHolder(){
          return k.whatHolder();
      }
  }

  class Radish extends KebabD{
      KebabD k;
      Radish(KebabD _k){
          k = _k;
      }

      // -------------------------

      abstract boolean isVeggie(){
          return k.isVeggie();
      }
      abstract Object whatHolder(){
          return k.whatHolder();
      }
  }
  // Pepper  Zucchini etc!
  class Pepper extends KebabD{
      KebabD k;
      Pepper(KebabD _k){
          k = _k;
      }

      // -------------------------

      abstract boolean isVeggie(){
          return k.isVeggie();
      }
      abstract Object whatHolder(){
          return k.whatHolder();
      }
  }
```

### Rod ---> Dagger Sabre Sword


``` java
  abstract class RodD{}

  class Dagger extends RodD{}
  class Sabre extends RodD{}
  class Sword extends RodD{}
```

### Plate--> Gold Silver Brass Copper Wood


``` java
  abstract class PlateD{}

  class Gold extends PlateD{}
  class Silver extends PlateD{}
  class Brass extends PlateD{}
  class Copper extends PlateD{}
  class Woood extends PlateD{}
```

### Crust vs [Cheese Olive Anchovy Sausage]


``` java
  abstract class PizzaD{
      abstract PizzaD remA();
      abstract PizzaD topAwC();
      abstract PizzaD subAbC(); //----Anchovy使用Cheese替换
  }

  class Crust extends PizzaD{
      //------------------------
      PizzaD remA(){
          return new Crust();
      }

      PizzaD topAwC(){
          return new Crust();
      }

      PizzaD subAbC(){
          return new Crust();
      }
  }


  class Cheese extends PizzaD{
      PizzaD p;
      Cheese(PizzaD _p){
          p = _p;
      }
      //------------------------
      PizzaD remA(){
          return new Cheese(p.remA());
      }
      PizzaD topAwC(){
          return new Cheese(p.topAwC());
      }

      PizzaD subAbC(){
          return new Cheese(p.subAbC());
      }
  }


  class Olive extends PizzaD{
      PizzaD p;
      Olive(PizzaD _p){
          p = _p;
      }
      //------------------------

      PizzaD remA(){
          return new Olive(p.remA());
      }

      PizzaD topAwC(){
          return new Olive(p.topAwC());
      }

      PizzaD subAbC(){
          return new Olive(p.subAbC());
      }
  }
  class Anchovy extends PizzaD{
      PizzaD p;
      Anchovy(PizzaD _p){
          p = _p;
      }
      //------------------------

      PizzaD remA(){
          //----------the difference
          return p.remA();
      }

      PizzaD topAwC(){
          return new Sausage(
                             new Anchovy(
                                         p.topAwC()));
      }


      PizzaD subAbC(){
          return new Cheese(p.subAbC());
      }
  }

  //-----还比如Spinach 类似于Sausage
  class Sausage extends PizzaD{
      PizzaD p;
      Sausage(PizzaD _p){
          p = _p;
      }
      //------------------------
      PizzaD remA(){
          return new Sausage(p.remA());
      }
      PizzaD topAwC(){
          return new Sausage(p.topAwC());
      }

      PizzaD subAbC(){
          return new Sausage(p.subAbC());
      }
  }
```


### ShishD的进化


The protocol is always the same and boring(单调和无聊即为协议)

``` java

  abstract class ShishD{
      abstract boolean onlyOnions(); //-----------所有继承类都得实现了
      abstract boolean isVegetarian();

  }

  abstract class ShishD{
      OnlyOnionsV ooFn = new OnlyOnionsV();
      IsVegetarianV ivFn = new IsVegetarianV();
      abstract boolean onlyOnions(); //-----------所有继承类都得实现了
      // ---- ooFn.forSkewer() ooFn.forOnion(s),  ooFn.forLamb(s); ooFn.forTomato(s) 都出自OnlyOnionsV类
      abstract boolean isVegetarian();
      // ---- ivFn.forSkewer() ivFn.forOnion(s),  ivFn.forLamb(s); ivFn.forTomato(s) 都出自IsVegetarianV类
  }

  class IsVegetarianV{
      boolean forSkewer(){
          return true;
      }
      boolean forOnion(ShishD s){
          return s.isVegetarian();
      }
      boolean forLamb(ShishD s){
          return false;
      }

      boolean forTomato(ShishD s){
          return s.isVegetarian();
      }
  }
```

PizzaD的类更多，让我们从更多的无聊和重复体味接口


``` java

  abstract class PizzaD{
      RemAv remFn = new RemAv();
      TopAwCv topFn = new TopAwCv();
      SubAbCv subFn = new SubAbCv();
      abstract PizzaD remA();
      abstract PizzaD topAwC();
      abstract PizzaD subAbC(); //----Anchovy使用Cheese替换
  }

  class Crust extends PizzaD{
      //------------------------
      PizzaD remA(){
          // return new Crust();
          return remFn.forCrust();
      }

      PizzaD topAwC(){
          // return new Crust();
          return topFn.forCrust();
      }

      PizzaD subAbC(){
          // return new Crust();
          return topFn.forCrust();
      }
  }


  class Cheese extends PizzaD{
      PizzaD p;
      Cheese(PizzaD _p){
          p = _p;
      }
      //------------------------
      [PizzaD](PizzaD) remA(){
          // return new Cheese(p.remA());
          return remFn.forCheese(p);
      }
      PizzaD topAwC(){
          // return new Cheese(p.topAwC());
          return topFn.forCheese(p);
      }

      PizzaD subAbC(){
          // return new Cheese(p.subAbC());
          return subFn.forCheese(p);
      }
  }


  class Olive extends PizzaD{
      PizzaD p;
      Olive(PizzaD _p){
          p = _p;
      }
      //------------------------

      PizzaD remA(){
          // return new Olive(p.remA());
          return remFn.forOlive(p);
      }

      PizzaD topAwC(){
          // return new Olive(p.topAwC());
          return topFn.forOlive(p);
      }

      PizzaD subAbC(){
          // return new Olive(p.subAbC());
          return subFn.forOlive(p);
      }
  }
  class Anchovy extends PizzaD{
      PizzaD p;
      Anchovy(PizzaD _p){
          p = _p;
      }
      //------------------------

      PizzaD remA(){
          //----------the difference
          // return p.remA();
          return remFn.forArchovy(p);
      }

      PizzaD topAwC(){
          //////////////////////////////////////////////////
          // return new Sausage(                          //
          //                    new Anchovy(              //
          //                                p.topAwC())); //
          //////////////////////////////////////////////////
          return topFn.forArchovy(p);
      }


      PizzaD subAbC(){
          // return new Cheese(p.subAbC());
          return subFn.forAnchovy(p);
      }
  }

  //-----还比如Spinach 类似于Sausage
  class Sausage extends PizzaD{
      PizzaD p;
      Sausage(PizzaD _p){
          p = _p;
      }
      //------------------------
      PizzaD remA(){
          // return new Sausage(p.remA());
          return remFn.forSausage(p);
      }
      PizzaD topAwC(){
          // return new Sausage(p.topAwC());
          return topFn.forSausage(p);
      }

      PizzaD subAbC(){
          // return new Sausage(p.subAbC());
          return subFn.forSausage(p);
      }
  }

```

从上面可以推断，所有的类中的操作都是类似(subFn.forCrust(p))，完全可以整合成一种风格的编写，
比如Interface！！！
再来看看我们的抽象行为类


``` java
  class RemAv{
      PizzaD forCrust(){
          return new Crust();
      }

      PizzaD forCheese(PizzaD p){
          return new Cheese(p.remA());
      }

      PizzaD forOlive(PizzaD p){
          return new Olive(p.remA());
      }

      PizzaD forAnchovy(PizzaD p){
          return p.remA();
      }

      PizzaD forSausage(PizzaD p){
          return new Sausage(p.remA());
      }
  }

  class TopAwCv{

      PizzaD forCrust(){
          return new Crust();
      }

      PizzaD forCheese(PizzaD p){
          return new Cheese(p.topAwC());
      }

      PizzaD forOlive(PizzaD p){
          return new Olive(p.topAwC());
      }

      PizzaD forAnchovy(PizzaD p){
          return new Cheese(new Anchovy(p.topAwC())) ;
      }

      PizzaD forSausage(PizzaD p){
          return new Sausage(p.topAwC());
      }
  }

  class SubAbCv{

      PizzaD forCrust(){
          return new Crust();
      }

      PizzaD forCheese(PizzaD p){
          return new Cheese(p.subAbC());
      }

      PizzaD forOlive(PizzaD p){
          return new Olive(p.subAbC());
      }

      PizzaD forAnchovy(PizzaD p){
          return new Cheese(p.subAbC()) ;
      }

      PizzaD forSausage(PizzaD p){
          return new Sausage(p.subAbC());
      }
  }
```

可以看到所有行为类都是类似的，没问题可以划分同类项！


我们看到那么多的RemV remFn, SubstV subStFn, 于是可以把他们移进对应抽象函数
我们不妨用PieD做试验

### Bot Vs Top


``` java
  abstract class PieD{
      //////////////////////////////////////////////
      // RemV remFn = new RemV();                 //
      // SubstV substFn = new SubstV();           //
      // //---------------                        //
      // abstract PieD rem(Object o);             //
      // abstract PieD subst(Object n, Object o); //
      //////////////////////////////////////////////

      abstract PieD rem(RemV remFn,Object o);
      abstract PieD subst(SubstV substFn, Object n, Object o);
  }

  class Bot extends PieD{
      //----------------
      // PieD rem(Object o){
      PieD rem(RemV remFn,Object o){
          return remFn.forBot(o);
      }
      // PieD subst(Object n, Object o){
      PieD subst(SubstV substFn, Object n, Object o){
          return substFn.forBot(n, o);
      }
  }

  class Top extends PieD{
      Object t;
      PieD r;
      Top(Object _t , PieD _r){
          t = _t;
          r = _r;
      }
      //---------------------

      PieD rem(Object o){
          return remFn.forTop(t,r,o);
      }
      PieD subst(Object n, Object o){
          return substFn.forTop(t, r,n, o);
      }
  }
```

### 伟大的interface出现了



``` java
    interface PieVisitorI{
        PieD forBot();
        PieD forTop(Object t, PieD r);
    }

    class RemV implements PieVisitorI{
        Object o;
        RemV(Object _o){
            o = _o;
        }
        //----------------------------
        public PieD forBot(){
        
            return new Bot();
        }
        public PieD forTop(Object t, PieD r){
             if(o.equals(t)){
                 return r.accept(this);
             }else{
                 return new Top(t,r.accept(this));
             }
        }
    }

    class SubstV implements PieVistorI{
        Object n;
        Object o;
        //-------------Closure
        // 如果出现_o 用_n来代替
        SubstV(Object _n, Object _o){
            n = _n;
            o = _o;
        }

        //---------------------------------
        public PieD forBot(){
            return new BOt();
        }

        public PieD forTop(Object t, PieD r){
            if(o.equals(t)){
                return new Top(n, r.accept(this));
            }else{
                return new Top(t, r.accept(this));
            }
        }
    }
  //----有限次删除
    class LtdSubstV implements PieVistorI{
        int c;
        Object n;
        Object o;
        //-------------Closure
        // 如果出现_o 用_n来代替
        LtdSubstV(int _c,Object _n, Object _o){
            c = _c;
            n = _n;
            o = _o;
        }

        //---------------------------------
        public PieD forBot(){
            return new BOt();
        }

        public PieD forTop(Object t, PieD r){
            if( 0 == c){
                return new Top(t, r);
            }
            if(o.equals(t)){
                return new Top(n, r.accept(new LtdSubstV(c-1,n ,o)));
            }else{
                return new Top(t, r.accept(this)); // this保持不变， 存在this变化的情况，有趣，有趣，有趣
                    }
        }
    }
    abstract class PieD{
        //---------------伟大的accept出现了
        abstract PieD accept(PieVisitorI ask);
    }

    class Bot extends PieD{
        PieD accept(PieVisitorI ask){
            ask.forBot();
        }
    }

    class Top extends PieD{
        Object t;
        PieD r;
        Top(Object _t, PieD _r){
            t = _t;
            r = _r;
        }
        //------------------------------
        PieD accept(PieVisitorI ask){
            return ask.forTop(t,r);
        }
    }
```

注意看行为类带参数的Closure出现了，且如果行为类参数发生变化，还得慎用this，因为
this指代当前类带参数！原来LtdSubstV这么有趣, 重新构造this！

### Bud vs [Flat Split]


``` java
  interface TreeVisitorI{
      Object forBud();
      Object forFlat(FruitD f, TreeD t); //-----不需要像Abstract类需要把方法加上Abstract
      Object forSplit(TreeD l, TreeD r);
  }


  //-------------------DataType and the Bud Varient
  abstract class TreeD{
      abstract Object accept(TreeVisitorI ask);
  }

  class Bud extends TreeD{
      Object accept(TreeVisitorI ask){
          return ask.forBud();
      }
  }

  class Flat extends TreeD{
      FruitD f;
      TreeD t;
      Flat(FruitD _f, TreeD _t){
          f = _f;
          t = _t;
      }

      //-----------------------------------
      Object accept(TreeVisitorI ask){
          return askforFlat(f,t);
      }
  }

  class Split extends TreeD{
      TreeD l;
      TreeD r;
      Split(TreeD _l, TreeD _r){
          l = _l;
          r = _r;
      }
      //----------------------------------
      Object accept(TreeVisitorI ask){
          return ask.forSplit(l,r);
      }
  }

  //-------------------接口实现类
  class iHeightV implements TreeVisitorI{

      public Object forBud(){
          return 0;
      }
      public Object forFlat(FruitD f, TreeD t){
          return t.accept(this)+1;
      }
      pulic Object forSplit(TreeD l, TreeD r){
          return (l.accept(this) || r.accept(this)) +1; //----------some confusion for ||
      }
  }

  class tSubstV implements TreeVisitorI{

      FruitD n;
      FruitD o;
      tSubstV(FruitD _n , FruitD _o){
          n = _n;
          o = _o;
      }
      //-------------------------------------------------------------------------
      public Object forBud(){
          return new Bud();
      }
      public Object forFlat(FruitD f, TreeD t){
          if(o.equals(f)){
              return new Flat(n, t.accept(this));
          }else{
              return new Flat(f, t.accept(this));
          }
      }
      pulic Object forSplit(TreeD l, TreeD r){
          return new Split(l.accept(this) , r.accept(this));
      }
  }


  class iOccursV implements TreeVisitorI{

      FruitD a;
      iOccursV(FruitD _a){
          a = _a;
      }
      //-------------------------------------------------------------------------
      ///////////////////////////////////////////////
      // public Object forBud(){                   //
      //     return 0; //----有问题                //
      // }                                         //
      // public Object forFlat(FruitD f, TreeD t){ //
      //     if(a.equals(f)){                      //
      //         return t.accept(this)+ 1;         //
      //     }else{                                //
      //         return  t.accept(this);           //
      //     }                                     //
      // }                                         //
      // pulic Object forSplit(TreeD l, TreeD r){  //
      //     return l.accept(this)+r.accept(this); //
      // }                                         //
      ///////////////////////////////////////////////


      public Object forBud(){
          return new Integer(0);
      }
      public Object forFlat(FruitD f, TreeD t){
          if(a.equals(f)){
              return new Integer(((Integer)
                                  (t.accept(this)))
                                 .intValue()
                                 + 1 );
          }else{
              return  t.accept(this);
          }
      }
      pulic Object forSplit(TreeD l, TreeD r){
          return new Integer(((Integer)
                              (l.accept(this)))
                             .intValue()
                             +
                             ((Integer)
                              (r.accept(this)))
                             .intValue());
      }
  }


  class IsFlatV implements TreeVisitorI{

      public Object forBud(){
          return new Boolean(true); //---------------注意true不是对象类，而是基本类型
      }
      public Object forFlat(FruitD f, TreeD t){
          return t.accept(this);
      }
      pulic Object forSplit(TreeD l, TreeD r){
          return new Boolean(false);
      }
  }


  class IsSplitV implements TreeVisitorI{

      public Object forBud(){
          return new Boolean(true); //---------------注意true不是对象类，而是基本类型
      }
      public Object forFlat(FruitD f, TreeD t){
          return new Boolean(false);
      }
      pulic Object forSplit(TreeD l, TreeD r){
          //------because l.accept(this) produces an Object, we must first convert it to a Boolean
          //------Then we can determine the underlying boolean with the booleanValue method.
          if(((Boolean)(l.accept(this))).booleanValue()){
              return r.accept(this);
          }else
              return new Boolean(false);
      }
  }
  
```
## 两个有趣的点

1. UnionVisitorI直接继承ShapeVisitorI，体味接口多继承作用
2. newHasPt风格的Constructor-like methods,让接口拓展更加好用！


``` java
abstract class ShapeD{
    abstract boolean accept(ShapeVisitorI ask);
}

class Circle extends ShapeD{
    //----默认为原点
    int r;
    Circle(int _r){
        r = _r;
    }
    //-----------------------------------------
    boolean accept(ShapeVisitorI ask){
        ask.forCircle(r);
    }
}


class Square extends ShapeD{
    //----默认为原点
    int s;
    Circle(int _s){
        s = _s;
    }
    //-----------------------------------------
    boolean accept(ShapeVisitorI ask){
        ask.forSquare(s);
    }
}


class Trans extends ShapeD{
    //---Trans has a better name Translation平移
    PointD q;
    ShapeD s;
    Trans(PointD _q , ShapeD _s){
        q = _q;
        s = _s;
    }
    //-----------------------------------------
    boolean accept(ShapeVisitorI ask){
        ask.forTrans(q,s);
    }
}

class Union extends ShapeD{
    ShapeD s;
    ShapeD t;
    Union(ShapeD _s, ShapeD _t){
        s = _s;
        t = _t;
    }
    //----------------------------------------
    boolean accept(ShapeVisitorI ask){
        // return true;
        // 关键所在 UnionVisitorI is also a Varient of ShapeVisitorI
        // 因为我们知道ask就是UnionVisitorI ，所以做了一次强转！！
        return ((UnionVisitorI)ask).forUnion(s,t);
    }
}

interface ShapeVisitorI{
    boolean forCircle(int r);
    boolean forSquare(int s);
    boolean forTrans(PointD q, ShapeD s);
}
//---------------很有趣，我们不是直接在ShapeVisitorI直接
//---------------添加函数，而是创建一个新接口(新街口)，因为接口可以多继承
//---------------Because UnionVisitorI extends ShapeVisitorI, it is
//---------------Also a ShapeVisitorI!
//---------------看了5遍，第一次明白接口继承！
interface UnionVisitorI extends ShapeVisitorI{
    boolean forUnion(ShapeD s, ShapeD t);
}

class HasPtV implements ShapeVisitorI{
    PointD p;
    HasPtV(PointD _p){
        p = _p;
    }
    //不明白为什么需要newHasPt构造函数 以及第九条建议
    // Constructor-like methods
    // 看着没什么作用，是因为没有从全局的角度进行思考
    ShapeVisitorI newHasPt(PointD p){
        return new HasPtV(p);// 他的作用和构造函数基本上一模一样
        // 之所以写上这个新的构造函数是为了到时候基于HasPtV可以拓展
        // 且看UnionHasPtV
    }
    //所以第九条建议提到 If a dataype may have to be extended(datatype指的
    //就是HasPtV, be forward looking and use a constructor-like(Override) method
    // so that visitors can be extended too.
    //---------------------------------------
    //--public
    public boolean forCircle(int r){
        return p.distranceToO() <= r;
    }
    //--public
    public boolean forSquare(int s){
        if(p.x <= s){
            return (p.y<=s);
        }else{
            return false;
        }
    }
    //--public
    public boolean forTrans(PointD q, ShapeD s){
        // return s.accept( new HasPtV(p.minus(q)));
        return s.accept( new newHasPtV(p.minus(q)));
    }
}


//----同样我们需要定义UnionHasPtV
//----implement UnionVisitorI 也得加上去， 因为HasPtV没有 UnionVisitorI的附加forUnion函数
class UnionHasPtV extends HasPtV implement UnionVisitorI{
    UnionHasPtV(PointD _p){
        super(_p);
    }

    ShapeVisitorI newHasPt(PointD p){
        return  new UnionHasPtV(p);
    }// 其他地方都不用修改，因为HasPtV的forTrans已经使用了，只要OnUnionHasPtV调用newHasPt，那么
    // 就调用new UnionHasPtV(p), forTrans就可以拓展到所有子类了

    //-------------------------------------
    //--public
    public boolean forUnion(ShapeD s, ShapeD t){
        if(s.accept(this)){
            return true;
        }else{
            return t.accept(this);
        }
    }
}

abstract class PointD{
    int x;
    int y;
    PointD(int _x, int _y){
        x = _x;
        y = _y;
    }
    //-------------------------------------------
    boolean closerToO(PointD p){
        return distanceToO <= p.distanceToO();
    }
    PointD minus(PointD p){
        return new Cartesian(x -p.x, y - p.y);
    }

    int moveBy(int DeltaX, int DeltaY){
        x= x+ deltaX;
        y= y+ deltaY;

        return distanceToO();

    }
    abstract int distanceToO();
}

class CartesianPt extends PointD{
    CartesianPt(int _x, int _y){
        super(_x, _y);
    }

    int distanceToO(){
        return sqrt(exp(x,2)+ exp(y,2));
    }
}


class ManhanttanPt extends PointD{
    ManhanttanPt(int _x, int _y){
        super(_x, _y);
    }

    int distanceToO(){
        return x+y;
    }
}

```

## 正向-反向链

通过accept链逐渐递归所有结构体(通过的具体部分为接口，接口包含着分支结构)
接口其实就是分支结构。

![accept][16]

通过很重要！通过什么的组合设计，采用什么，运用什么都是接口的部分。

``` java
forTop(Top that)
forBob(Bob that)
    accept--->ask.forTop(this)
          --->ask.forBob(this)
                    ---> that.t
                    ---> that.r
```

每个对象都具备accept接受者或者询问者，accept(Visitor), 
计算机都有accept方法，计算机里头有附属部件，比如cpu、键盘、摄像头等都有相应aceept方法

### 函数式接口
jdk1.8后开始引入函数式编程 
我认为链式编程和函数式接口以及lambda编程说的是一回事，都是函数式编程的意思 

``` java
@FunctionalInterface
public interface Function<T,R>
```

典型消费者类函数式接口forEach(消费者类型函数式接口)

```java
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

```
java 四大函数式接口

 * 1. Function(点进去源码)
 * 2. Predicate
 * 3. Supplier
 * 4. Consumer
 * Functional接口 传入参数T 返回参数R

```java
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);


```
凡是函数式接口都可以通过lambda表示进行简化写法
```java
//        aps.forEach();
        Function function = new Function<String,String>() {
            @Override
            public String apply(String str) {
                return str;
            }
        };
        System.out.println(function.apply("ads"));

        Function<String,String> function2 = (str)->{
            return str;
        };
        System.out.println(function2.apply("ads2"));
        
        Function<String,String> function3 = (String str)->{
            return str;
        };
        System.out.println(function3.apply("ads2"));
        

```

测试谓词函数式接口
```java
    public static void testPredicate(){
        /**
         * 测试Predicate函数式接口
         *
         @FunctionalInterface
         public interface Predicate<T> {

          * Evaluates this predicate on the given argument.
          *
          * @param t the input argument
         * @return {@code true} if the input argument matches the predicate,
         * otherwise {@code false}
        boolean test(T t);

         */
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test("ad"));
        System.out.println(predicate.test(""));
    }

    
    测试Consumer函数式接口

    ``` java
    /**
     public interface Consumer<T> {

     * Performs this operation on the given argument.
     *
     * @param t the input argument
    void accept(T t);
    }
     只有一个输入类型，返回空类型
    */
    public static void testConsumer(){
        
        
        System.out.println("****************测试消费者函数式接口********************");
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("打印字符串:"+s);
            }
        };
        con.accept("hello");

        Consumer<String> con2 = (str)->{
            System.out.println("打印字符串："+str);
        };
        con2.accept("finally");

    }
    ```

    测试Supplier函数式接口
    ```java
    /**
     * 只返回 不需要输入
         public interface Supplier<T> {

         * Gets a result.
         *
         * @return a result
        T get();
        }
     */
    public static void testSupplier(){

        Supplier<Integer> sup = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 1024;
            }
        };
        System.out.println(sup.get());

        Supplier<Integer> sup2 =()->{return 1024;};
        System.out.println(sup2.get());
    }
    ```


--------------------------------------------------------------


[1]: https://a-little-java-a-few-patterns.readthedocs.io/zh_CN/latest/
[2]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/image/eval-apply.png
[3]: https://www.researchgate.net/publication/221598672_How_Do_Procurement_Networks_Become_Social_Design_Principles_Evaluation_in_a_Heterogeneous_Environment_of_Structured_and_Unstructured_Interactions
[4]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/image/design.jpg
[5]:https://github.com/crossoverJie/cim 
[6]:http://jueqingsizhe66.github.io/blog/2017/08/11/from-little-scheme-to-season-scheme/ 
[7]:http://jueqingsizhe66.github.io/blog/2015/05/17/cong-lambdadao-simple-plus-complexjie-shi-qi-zai-dao-shu-xing-chou-xiang/ 
[8]: https://mp.weixin.qq.com/s/N4jJLG6EP55OJmyYv5lcFg 
[9]:https://github.com/jueqingsizhe66/DesignPattern 
[10]:https://www.cnblogs.com/cicaday/p/python-decorator.html 
[11]:http://www.gigamonkeys.com/book/macros-defining-your-own.html 
[12]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/image/behaviors.png
[13]: https://www.youtube.com/watch?v=13cmHf_kt-Q&index=26&list=PLZdCLR02grLp__wRg5OTavVj4wefg69hM 
[14]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/image/Acceptor.png
[15]: https://github.com/jueqingsizhe66/DesignPattern
[16]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/image/acceptLinks.jpg 
[17]:https://www.bilibili.com/video/BV1Ri4y1g71L?p=51 
[18]:https://github.com/abo-abo/org-fu/blob/master/org-fu.el 
[19]:https://www.processon.com/view/600f95a3e401fd0a1f8b60b1?fromnew=1 
[20]:https://www.bilibili.com/video/BV1B7411L7tE?p=25&spm_id_from=pageDriver 
