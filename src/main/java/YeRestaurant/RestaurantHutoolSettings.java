package YeRestaurant;

import cn.hutool.setting.Setting;
import cn.hutool.setting.dialect.Props;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestaurantHutoolSettings {

    //没有想到用list表来接数据（一定要有集合的概念）
    private List<Food> foods = new ArrayList<Food>();

    //定义一个init函数 用于在构造函数内部 调用，并初始化菜单！准备开张 开店铺
    public RestaurantHutoolSettings()
    {
    }
    public void init()
    {
        try
        {
            // 减少File InputStream 和load的过程, 很方便
/**
 *读取classpath下的XXX.setting，不使用变量
                * Setting setting = new Setting("XXX.setting");
 *
 * //读取classpath下的config目录下的XXX.setting，不使用变量
 *setting = new Setting("config/XXX.setting");
 *
 * //读取绝对路径文件/home/looly/XXX.setting（没有就创建，关于touc请查阅FileUtil）
 * //第二个参数为自定义的编码，请保持与Setting文件的编码一致
 * //第三个参数为是否使用变量，如果为true，则配置文件中的每个key都以被之后的条目中的value引用形式为 ${key}
 *setting = new Setting(FileUtil.touc("/home/looly/XXX.setting"), CharsetUtil.CHARSET_UTF_8, true);
 *
 * //读取与SettingDemo.class文件同包下的XXX.setting
 *setting = new Setting("XXX.setting", SettingDemo.class, CharsetUtil.CHARSET_UTF_8, true);
 *
 *
 */
            Setting setting = new Setting("Food.settings");
            // 先获得分组 ，然后再获得所有值
            Collection coll1 = setting.getSetting("demo").values();
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
        RestaurantHutoolSettings res =new RestaurantHutoolSettings();
        System.out.println("欢饮各位宾客的到来-- 鞭炮响起");
        System.out.println("******************************");
        res.init();
        res.showFoods();
    }
}
