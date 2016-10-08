package ch07;

   abstract class FruitD {} // 水果

   class Peach extends FruitD {  //桃
       public boolean equals(Object o) {
           return (o instanceof Peach);
       }
   }

   class Apple extends FruitD { //苹果
       public boolean equals(Object o) {
           return (o instanceof Apple);
       }
   }

   class Pear extends FruitD { //梨
       public boolean equals(Object o) {
           return (o instanceof Pear);
       }
   }

   class Lemon extends FruitD { //柠檬
       public boolean equals(Object o) {
           return (o instanceof Lemon);
       }
   }

   class Fig extends FruitD { //无花果
	     public boolean equals(Object o) {
	           return (o instanceof Fig);
	       }
	   }
   
