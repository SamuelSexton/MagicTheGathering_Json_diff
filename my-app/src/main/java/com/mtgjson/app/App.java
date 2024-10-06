package com.mtgjson.app;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card cardOne = new Card();
		Card cardTwo = new Card();
		Card cardThre = new Card();
		
		cardOne.setDefense("6");
		cardOne.setName("First Card");
		cardOne.setText("This is a longer string in the first");
		
		cardTwo.setDefense("6");
		cardTwo.setName("Second Card");
		cardTwo.setText("This is a longer string in the first");
		
		cardThre.setDefense("6");
		cardThre.setName("First Card");
		cardThre.setText("This is a longer string in the third");
		
		System.out.println("First card to second card: " + cardOne.equals(cardTwo));
		System.out.println("Second card to Third card: " + cardTwo.equals(cardThre));
		System.out.println("First card to Third card: " + cardOne.equals(cardThre));
	}

}
