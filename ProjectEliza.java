package Project2;

import java.util.Scanner;

public class ProjectEliza {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		PromptBank promptObject = new PromptBank();

		while (true) {// this loop begins the introduction process for the loop of the eliza project
			System.out.println("Hello my name is Eliza, What is your name?");

			String name = scnr.nextLine();

			System.out.println("Hello," + name + ". Tell me what is on your mind today in 1 sentence.");

			String userSentence = "";
			
			while (!userSentence.equalsIgnoreCase("EXIT")) {
				userSentence = scnr.nextLine();
	 			userSentence += scnr.nextLine();

				if (!userSentence.equalsIgnoreCase("EXIT")) {
					String[] words = userSentence.split("\\s+");

					String word1 = "";
					String word2 = "";

					if (words.length == 1) {// if a sentence is only word or if user inputs one word
						word1 = words[0];
						word2 = words[0];
					} else {// when the input is longer than one word
						word1 = words[0];
						word2 = words[words.length - 1];
					}

					if (userSentence.charAt(userSentence.length() - 1) == '?') { // indicating that the sentence ends with ?
																					 
						String randQuestion = promptObject.getRandomQuestionTrunk();

						randQuestion = randQuestion.replace("BLANK1", word1);
						randQuestion = randQuestion.replace("BLANK2", word2.replace("?", ""));

						System.out.println(randQuestion);
					}

					else if (userSentence.charAt(userSentence.length() - 1) == '!') {// for sentence ending in a !
						String randStatement = promptObject.getRandomStatementTrunk();

						randStatement = randStatement.replace("BLANK1", word1);
						randStatement = randStatement.replace("BLANK2", word2.replace("!", ""));

						System.out.println("WOW!Dramatic!"+randStatement);
					
					} else {// ending with any special characters
						String randStatement = promptObject.getRandomStatementTrunk();

						randStatement = randStatement.replace("BLANK1", word1);
						randStatement = randStatement.replace("BLANK2", word2);

						System.out.println(randStatement);
					}
				}
				else {
				
					System.out.println("Do you want to run the session again?");
				String userAnswer = scnr.nextLine();
				
				if (userAnswer.equalsIgnoreCase("NO")) {
					System.out.println("Goodbye, until next time");
					System.exit(0);
				}
				
				
				if (userAnswer.equalsIgnoreCase("YES")) {
				}
				}
		}

} // ending of entire loop
}// ending of main agrs
}// ending of class body
