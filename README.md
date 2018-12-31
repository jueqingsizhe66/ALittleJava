[A little java笔记][1]

Evaluate(interpret) all the hierarchy objects, apply coresponding operators to every objects.

![eval-apply][2]

[How Do Procurement Networks Become Social? Design Principles Evaluation in a Heterogeneous Environment of Structured and Unstructured Interactions][3]


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
       对应的构造函数类似于-,/,car or cdr的作用, 而terminal element 相当于 0, 1,null?的作用

核心点：通过构造函数（类似于y lambda的功能）  按照natural recursion 不断递归到结尾。

技术点: 把基类的字段添加到自定义类中，通过构造函数的参数赋值，在终止类(terminal class)不添加该
        基类字段，直接返回值(new),递归结束
       Object是FishD,Int等所有类的父类，最原始类

发展过程： 首先是把不相关的属性放入自定义类中，然后是把基类和需要的属性的输入放入自定义类中，
          后来是多个行为基类(省略掉必要的属性, 比如PizzaD的remA,topAwc,subAbc)放入其中(出现的问题1: 
          每个自定义子类都有一堆的基类函数需要实现, 这也是我们最先想到方法，比如鸭子会飞、会叫、会游泳
          会吃，于是黑鸭子也都会，黄鸭子也会，蓝鸭子也会，臭鸭子也会^-^ 很多很多)
          提出一个自定义的V类，实现所有针对于各个对象的for函数，然后把V类添加到基类中，并且生成值，
          自定义类通过V类值来实现抽象行为。(并没有解决问题，只是把所有类的行为，抽象到一个行为V类，
          在该V类，对应各个自定义类的具体实现，相当于横排竖排转置而已，没产生一个新自定义类，你的每一个
          行为V类得重写，新的自定义类依然得对对应套餐行为进行实现。 这种想法也是我们能够想到的，
          我们知道常见的鸭子有黑鸭子、黄鸭子、蓝鸭子、臭鸭子， 我们把他们飞的行为抽象成一个类，飞类，
          他们叫的行为抽象成一个类，叫类，.... 这时候相当于把行为当做横排，而不像上面的把不同鸭子当做一个一个
          记录或者叫排，然后我们针对每一类鸭子，完成飞类、叫类等的实现，这时候针对每一个类型的鸭子，只需要
          引入该V类调用对应的方法即可，也就是具体的实现都移到了V类去干！抽象出行为特点！！这是他开始要
          展现与众不同的地方，因为你只要去V类干活就可以，在鸭子的自定义类中只是去调用V类的对应行为，
          当然你也可以说上面的方法也可以，我只要到对应鸭子类的对应行为修改就可以了，好正如上面说的，这种
          变换到此时并没有太多的进步)
          把基类中的行为V类放到基函数的参数中，而不是放在基函数的字段中，减少了基类函数长度看看。关键的this出现了，
          在行为类中引入this，this指代当前访问者本身（也就是说这一步的重要改进就是通过基函数和this改变了代码的显示风格
          代码量没有太多实质性的减少，只不过从字段移到了参数，感觉行数少了，但是单词数也多了 这是第二次进化
           
          开始进行第三次进化，把固定不变的量提到访问者V类，比如rem，删除某个东西是固定的，于是改进行为V类的
          构造函数，这样可以减少核心函数的参数个数。比如subst，从什么变到什么，也是不变的，于是也提到行为V类中
          (在这次进化中，由于你把rem和subst的变化都提到行为V类中，于是对应的自定义类中的基函数实现很像
            出现重复性代码，于是考虑进行第四次进化)
          于是把行为V自定义类的方法抽象出一个接口函数，然后行为V类都实现改接口(implements在第四次进化中出现了)
            这时候你会去分析行为的异同，对行为接口基函数的实现，和基类基函数的实现分开， 你需要对对应的基类进行
          修正， 因为此时行为V类，已经通过行为基类结合在一起，那么对应的基类的基函数，也得用行为基类进行了
           且行为基函数得浓缩为一个函数，accept（第四次进化很丰富，统一为accept） 基类基函数只存在一个accept函数了
           这时候你会看到很爽 ，很刺激的感觉。 因为代码量急剧下降了！此时构建新的行为V类也会简单一些。
           
           通过四次进化，得到关键概念： 基类，基函数，行为V类，基函数参数，构造函数，行为基函数，行为自定义V类
                      abstract,new,extends, super, this, interface,implements都在其中有所体现。（感悟！感谢！
                      感恩！)

归纳：怎么把基类的所有行为归到一个accept函数(run，handle等函数),负责侦听服务。
  公式： datatype  accept   interface (虚线连接，accept在虚线中间)
        箭头表示extends
        实现表示implements
  说明： The method accepts a visitor and asks(问本身代表行为需求) for its(their) service(本身带有功能实现)
      so we call accept as service!
      we ask(行为) for services(目的)
      行为都具有一定目的性。

    P61 归纳了data part to understand what things is. action part to understand how things work
    P58开始提及data part 和action part
    数据的抽象是为了进行分层架构，逻辑划分
    行为的抽象是为了简化代码编写

    P89 在函数式编程 a visitor with fields is called as a closure(带属性的行为叫做closure)
        通过定义closure的技术手段，结合构造函数，提取行为基类中的仅首次创建对象发生改变的fields

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
     6. 在行为基类中引入构造函数，提取行为属性的不同，构造一个closure，得到函数式编程的closure。
     7. 引入interface P92 很有意思
     
    注意: 当一个类实现一个借口，需增加"Public" ,把他添加实现方法的最前面.
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


[1]: https://a-little-java-a-few-patterns.readthedocs.io/zh_CN/latest/
[2]: https://github.com/jueqingsizhe66/ALittleJava/eval-apply.png
[3]: https://www.researchgate.net/publication/221598672_How_Do_Procurement_Networks_Become_Social_Design_Principles_Evaluation_in_a_Heterogeneous_Environment_of_Structured_and_Unstructured_Interactions
[4]: https://github.com/jueqingsizhe66/ALittleJava/design.png
