package YeRestaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Restaurant {
/**
 * 情景 : 有一家餐厅,时常更换菜品 , 客人进店时向客人展示所有的菜品,
 * 要求开发一个扩充性好的程序,就是更换菜品时只需要做一些简单的配置就可以
 *
 */


/**
 *  通过下面的餐厅类  很方便的通过Food接口
 *  添加更多的新菜！ 只要你有新定义一个  食物.java 然后在
 *  food.properties添加一个键值对即可
 */

/**
 * @author    叶昭良
 * @time      2015年3月3日下午4:44:15
 * @version   com.reflect.testRestaurant V1.0
 */



    /**
     * @param args
     */
    //没有想到用list表来接数据（一定要有集合的概念）
    private List<Food>  foods = new ArrayList<Food>();

    //定义一个init函数 用于在构造函数内部 调用，并初始化菜单！准备开张 开店铺
    public Restaurant()
    {
    }
    public void init()
    {
        try
        {
            //InputStream is = Restaurant.class.getClassLoader().getResourceAsStream("Food.properties");
//            InputStream is = Restaurant.class.getResourceAsStream("src/main/resources/Food.properties");
            File file = new File("src/main/resources/Food.properties");
            InputStream is = new FileInputStream(file);

            Properties prop = new Properties();
            /**
             *  要知道 food.properties 的key-value的写法
             *  Prop对象就是一个map对象
             *  先前只写上一个值是错误的！ 必须写上
             *  Apple=com.reflect.test.food.Apple
             */
            //必须加在src底下
            //prop.load(new FileInputStream("food.properties"));
            try
            {
                prop.load(is);
            } catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Collection  coll1 = prop.values();
            for(Object foodClassName:coll1)
            {
                Class temp;

                temp = Class.forName((String)(foodClassName));

                Food food = (Food)temp.newInstance();
                foods.add(food);
            }
        }catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            System.out.println("未找到对应的类");
        }catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            System.out.println("产生实例的异常");
        } catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void showFoods()
    {
        for(Food temp:foods)
        {
            //Food接口创建的一个唯一接口方法
            System.out.println(temp.getFoodName());
        }
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        //开了一家店
        Restaurant res = new Restaurant();
        System.out.println("欢饮各位宾客的到来-- 鞭炮响起");
        System.out.println("******************************");
        res.init();
        res.showFoods();
    }

}


