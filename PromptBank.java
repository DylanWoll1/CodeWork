package Project2;

public class PromptBank {
    
	private String [] questions;
	private String [] statements;
	
	public  PromptBank(){
		
		questions = new String[3]; 
        statements = new String[3]; 
        
        populateQuestionsArray();
        populateStatementsArray();
		
	}
public void populateQuestionsArray(){
		questions[0] = "Is there anything else about BLANK1 and BLANK2?";
		questions[1] = "Does BLANK1 bother you? How about BLANK2?";
		questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
      }
	
	public void populateStatementsArray(){
		statements[0] = "Tell me more about BLANK1 and BLANK2";
		statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
		statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
	}
	
	
	  
	public String getRandomStatementTrunk() {
		
		
		int randStatements = (int) (Math.random()*statements.length-1);
		
		return statements[randStatements]; 
		
	}

	public String getRandomQuestionTrunk(){
		
		int randQuestions = (int) (Math.random()*questions.length-1);
		
		
		return questions[randQuestions];
	}

	
	
}