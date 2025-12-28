package ch10;

public class Main {
  public static void main(String args[]) {
    // PiemanI y = new PiemanM(null);
    PiemanI y = new PiemanM(new Bot());
    System.out.println(
        y.addTop(new AnchovyFish()) + "\n" +
            y.addTop(new AnchovyFish()) + "\n" +
            y.substTop(new TunaFish(), new AnchovyFish()));
  }
}
