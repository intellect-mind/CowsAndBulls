package coreJava;
import java.util.Dictionary;
import java.util.Scanner;
import coreJava.CowsAndBullsWords;


public class CowsAndBullsGame {

	public static int returnInt(){
		int index=1;
		index = (int)((Math.random())*10);
		
		return index;
	}
	public static void main(String[] args) {
		
		int numOfGuesses = 0;
		int cows;
		int bulls;
		String guessWord;
		System.out.println("######################################################################");
		System.out.println("                       Welcome To The Game");
		System.out.println("                         COWS AND BULLS");
		System.out.println("######################################################################");
		
		
		CowsAndBullsWords cw = new CowsAndBullsWords();
		Dictionary<Integer, String> gameDict = cw.addWords();
		int index=returnInt();
		String gameWord = gameDict.get(index);
		System.out.println("\n\n\n");
		System.out.println("Word is selected. You can start guessing");
		
		Scanner s = new Scanner(System.in);
		
		do{
			cows = 0;
			bulls = 0;
			System.out.println("Make your guess");
			guessWord = s.nextLine();
			char[] letters = guessWord.toCharArray(); 
			for(int i=0;i<gameWord.length();i++){
				for(int j=0;j<letters.length;j++){
					if(gameWord.charAt(i)==letters[j]){
						cows+=1;
						if(i==j){
							bulls+=1;
						}
					}
				}
			}
			System.out.println("Cows:"+cows+"  Bulls:"+bulls);
			numOfGuesses+=1;
			
		}while(bulls!=4);
		
		System.out.println("You have guessed correctly in "+numOfGuesses+" guesses. \n The word is "+guessWord);
		s.close();

	}

}
