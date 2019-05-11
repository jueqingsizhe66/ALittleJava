package ch081;

public class TestPieD {
    public static void main(String[] args) {
        System.out.println(new ch081.Top(3,new ch081.Top(5,new ch081.Top(10,new ch081.Bot()))).accept(new ch081.RemV(3)));
    }
}
