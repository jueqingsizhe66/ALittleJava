package ch02;

public class TestTYangRouChuan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Onion(new Onion(new Skewer())));
		System.out.println(new Onion(new Onion(new Skewer())).onlyOnions());
		System.out.println(new Onion(new Lamb(new Skewer())).onlyOnions());
		//System.out.println(new Onion(new Onion(new Onion())).onlyOnions());
		System.out.println(new Onion(new Tomato(new Onion(new Skewer()))).isVegetarian());
		System.out.println(new Tomato(new Onion(new Onion(new Skewer()))).isVegetarian());
		System.out.println(new Tomato(new Onion(new Onion(new Skewer()))));
		System.out.println(new Tomato(new Onion(new Onion(new Skewer()))).toString());


	}

}
