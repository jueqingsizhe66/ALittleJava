# 丰富多彩的餐厅


  情景 : 有一家餐厅,时常更换菜品 , 客人进店时向客人展示所有的菜品,
  要求开发一个扩充性好的程序,就是更换菜品时只需要做一些简单的配置就可以
  
## 解决方案:
  
    1. 通过下面的餐厅类  很方便的通过Food接口
    2. 添加更多的新菜！ 只要你有新定义一个  食物.java 然后在
    3. food.properties添加一个键值对即可
   
## 具体编写步骤:   

    1. Food.properties映射对
    2. Food.java提供接口
    3. Restaurant通过Food接口，访问所有properties 映射出所有菜单
    4. 定制具体的HongShaoRou.java 等Food实现类

![Restaurant][1]

[1]: https://github.com/jueqingsizhe66/ALittleJava/blob/master/src/YeRestaurant/Restaurant.png