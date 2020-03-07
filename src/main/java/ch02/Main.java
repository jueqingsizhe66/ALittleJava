package ch02;

public class Main {
	public static void main(String[] args) {
		PointD p = new ManHattanPt(10, 20);
		PointD p1 = new CartesianPt(10, 20);
		System.out.println(p);
		System.out.println(p1);
		System.out.println(new Tomato(new Onion(new Onion(new Skewer()))));
		System.out.println(p.distanceTo0());
	}
}
