package YeRestaurant;

import cn.hutool.setting.dialect.Props;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class RestaurantHutoolProp {

    //没有想到用list表来接数据（一定要有集合的概念）
    private List<Food> foods = new ArrayList<Food>();

    //定义一个init函数 用于在构造函数内部 调用，并初始化菜单！准备开张 开店铺
    public RestaurantHutoolProp()
    {
    }
    public void init()
    {
        try
        {
            // 减少File InputStream 和load的过程, 很方便
            Props props =new Props("Food.properties");
            Collection coll1 = props.values();
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
        RestaurantHutoolProp res =new RestaurantHutoolProp();
        System.out.println("欢饮各位宾客的到来-- 鞭炮响起");
        System.out.println("******************************");
        res.init();
        res.showFoods();
    }
}
