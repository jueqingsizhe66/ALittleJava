package ch02;

public class Test {

	public static void main(String[] args) {
		ManHattanPt mhpt = new ManHattanPt(80, 10);
		System.out.println(mhpt.distanceTo0());
		
		ManHattanPt1 m2 = new ManHattanPt1(10, 20);
		ManHattanPt1 m3 = new ManHattanPt1(30, 20);
		System.out.println(m2.closerTo0(m3));
	}
}
