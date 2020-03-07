package ch0801That;

public class TestThat {
    public static void main(String[] args) {
        System.out.println(new Top(3,new Top(5,new Top(10,new Bot()))).accept(new RemV(3)));
        System.out.println(new Top(3,new Top(5,new Top(10,new Bot()))).accept(new SubstV(300,3)));
        System.out.println(new Top(3,new Top(5,new Top(10,new Top(3,new Top(13,new Top(3, new Bot())))))).accept(
                new LtSubstV(1,300,3)));

        System.out.println(new Top(3,new Top(5,new Top(10,new Top(3,new Top(13,new Top(3, new Bot())))))).accept(
                new LtSubstV(2,300,3)));

        System.out.println(new Top(3,new Top(5,new Top(10,new Top(3,new Top(13,new Top(3, new Bot())))))).accept(
                new LtSubstV(3,300,3)));
    }
}
