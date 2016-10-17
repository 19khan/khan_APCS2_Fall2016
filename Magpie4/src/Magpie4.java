public class Magpie4 {
	
	//Get a default greeting and return a greeting
	public String getGreeting() {
		return "Hello, let's talk.";
	}


	/*
	 * 1) Copy and paste the code you wrote in Magpie 3 into the getResponse method. There is new code within the method 
	 * but below where you will paste your code.  Figure out what it does.
	 * 
	 * 2) Copy and paste Part 3's getRandomResponse() code into the method below.
	 * 
	 * 3) Alter the class as described in the handout.
	 * 
	 */
	
	
	/**
	 * Gives a response to a user statement
	 * takes in user statement
	 * response based on the rules given
	 */
	public String getResponse(String statement) {
		
		// Paste Part 3 code here.  The method has new pieces that continue below and should flow from your previous code.
		String response = "";
		if (findKeyword(statement, "no", 0) >=0){
			response = "Don't be so negative.";
		} else if (findKeyword(statement, "mother", 0) >= 0
			|| findKeyword(statement, "father", 0) >= 0
			|| findKeyword(statement, "sister", 0) >= 0){
			response = "Tell me more about your family.";
		} else if (findKeyword(statement, "brother", 0) >= 0) {
			response = "How old is he";
		} else if (findKeyword(statement, "Mr.Lamont", 0) >= 0
				|| findKeyword(statement, "Mr.deHeer", 0) >= 0){
			response = "He sounds like a good teacher.";
		} else if (findKeyword(statement, "Ms.Dreyer", 0) >= 0){
			response = "She sounds like a great teacher.";
		} else if (findKeyword(statement, "How", 0) >= 0
				&& findKeyword(statement, "are", 0) >= 0){
			response = "I'm doing fine.";
		} else if (findKeyword(statement, "Where", 0) >= 0
				&& findKeyword(statement, "are", 0) >= 0
				&& findKeyword(statement, "from", 0) >= 0){
			response = "I'm from California.";
		} else if (statement.trim().length() <= 0){
			response = "Say something, please.";
		} else if (findKeyword(statement, "Hello", 0) >= 0){
			response = "Greetings.";

		// Responses which require transformations
		} else if (findKeyword(statement, "I want to", 0) >= 0) {
			response = transformIWantToStatement(statement);
		} else if (findKeyword(statement, "I want", 0) >= 0) {
			response = trasformIWantStatement(statement);
		}

		else {
			// Look for a two word (you <something> me & I <something> you)
			int youPsn = findKeyword(statement, "you", 0);
			int iPsn = findKeyword(statement, "I", 0);
			
			if (youPsn >= 0 && findKeyword(statement, "me", youPsn) >= 0) {
				response = transformYouMeStatement(statement);
			} else if (iPsn >= 0 && findKeyword(statement, "you", iPsn) >= 0){
				response = transformIYouStatement(statement);
			}
			else {
				response = getRandomResponse();
			}
		}
		return response;
	}

	/**
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?")) {
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}
	
	private String trasformIWantStatement (String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() -1);
		if (lastChar.equals(".") || lastChar.equals("!")) {
			statement = statement.substring(0, statement.length() -1);
		}
		
		int psn = findKeyword(statement, "I want", 0);
		
		String restOfStatement = statement.substring(psn + 6).trim();
		return "Would you really be happy if you had " + restOfStatement + "?";
	}
	
	private String transformIYouStatement (String statement) {
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".") || lastChar.equals("!")){
			statement = statement.substring(0, statement.length() - 1);
		}
		
		int psnOfI = findKeyword (statement, "I", 0);
		int psnOfYou = findKeyword (statement, "you", psnOfI + 1);
		
		String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
		return "Why do you " + restOfStatement + " me?";
	}

	/**
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * 
	 * @param statement
	 *            the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement) {
		// Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".") || lastChar.equals("?")) {
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword(statement, "you", 0);
		int psnOfMe = findKeyword(statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}

	/**
	 * Search for one word in phrase. The search is not case sensitive. This
	 * method will check that the given goal is not a substring of a longer
	 * string (so, for example, "I know" does not contain "no").
	 * 
	 * parameter: statement
	 *            the string to search
	 * parameter: goal
	 *            the string to search for
	 * parameter: startPos
	 *            the character of the string to begin the search at
	 * return the index of the first occurrence of goal in statement or -1 if
	 *         it's not found
	 */
	private int findKeyword(String statement, String goal, int startPos) {
		String phrase = statement.trim();
		// The only change to incorporate the startPos is in the line below
		int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

		// Refinement--make sure the goal isn't part of a word
		while (psn >= 0) {
			// Find the string of length 1 before and after the word
			String before = " ", after = " ";
			if (psn > 0) {
				before = phrase.substring(psn - 1, psn).toLowerCase();
			}
			if (psn + goal.length() < phrase.length()) {
				after = phrase.substring(psn + goal.length(),
						psn + goal.length() + 1).toLowerCase();
			}

			// If before and after aren't letters, we've found the word
			if (before.equals(" ") && after.equals(" ")) {
				return psn;
			}
			// The last position didn't work, so let's find the next, if there
			// is one.
			psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

		}

		return -1;
	}


	/**
	 * Pick a default response to use if nothing else fits.
	 * 
	 * @return a non-committal string
	 */
	private String getRandomResponse() {
		
		// Paste part 3 code here
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1){
			response = "Hmmm.";
		} else if (whichResponse == 2){
			response = "Do you really think so?";
		} else if (whichResponse == 3){
			response = "You don't say.";
		}
		
		return response;
	}

}
