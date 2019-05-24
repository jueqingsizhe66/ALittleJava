package Ch0801ThatOverload;

public class TestThat {
    public static void main(String[] args) {
        System.out.println(new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(5,new Ch0801ThatOverload.Top(10,new Ch0801ThatOverload.Bot()))).accept(new Ch0801ThatOverload.RemV(3)));
        System.out.println(new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(5,new Ch0801ThatOverload.Top(10,new Ch0801ThatOverload.Bot()))).accept(new Ch0801ThatOverload.SubstV(300,3)));
        System.out.println(new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(5,new Ch0801ThatOverload.Top(10,new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(13,new Ch0801ThatOverload.Top(3, new Ch0801ThatOverload.Bot())))))).accept(
                new Ch0801ThatOverload.LtSubstV(1,300,3)));

        System.out.println(new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(5,new Ch0801ThatOverload.Top(10,new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(13,new Ch0801ThatOverload.Top(3, new Ch0801ThatOverload.Bot())))))).accept(
                new Ch0801ThatOverload.LtSubstV(2,300,3)));

        System.out.println(new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(5,new Ch0801ThatOverload.Top(10,new Ch0801ThatOverload.Top(3,new Ch0801ThatOverload.Top(13,new Ch0801ThatOverload.Top(3, new Ch0801ThatOverload.Bot())))))).accept(
                new Ch0801ThatOverload.LtSubstV(3,300,3)));
    }
}
