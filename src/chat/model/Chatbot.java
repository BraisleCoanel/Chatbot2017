package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private List<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>();
		this.cuteAnimalMemes = new ArrayList<String>();
		this.questions = new String [10];
		this.username = username;
		this.content = null;
		this.intro = null;
		this.currentTime = null;
		this.topics = new String [7];
		this.verbs = new String [4];
		this.followUps = new String [5];
	}

	private void buildMovieList()
	{
		
	}
	
	private void buildShoppingList()
	{
		
	}
	
	private void buildCuteAnimals()
	{
		
	}
	
	private void buildQuestions()
	{
		questions[0] = "What is your name?";
		questions[1] = "What is your favorite color?";
		questions[2] = "How has your day been?";
		questions[3] = "What is your favorite food?";
		questions[4] = "Are you dating anyone ;)?";
		questions[5] = "How old are you?";
		questions[6] = "What are your hobbies or interests?";
		questions[7] = "Are you a normie?";
		questions[8] = "Have you done your Bible studies today?";
		questions[9] = "What kind of music do you listen to?";
	}
	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "You said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse(); 
		
		return chatbotResponse;
	}
	
	private String buildChatbotResponse()
	{
		String response = "I ";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs[random];
		
		random = (int) (Math.random() * topics.length);
		response += " " + topics[random] + "\n";
		
		random = (int) (Math.random() * questions.length);
		response += " " + questions[random] + "\n";
		
		random = (int) (Math.random() * 2);
		
		if(random % 2 == 0)
		{
			random = (int) (Math.random() * movieList.size());
			response += "\n" + movieList.get(random).getTitle() + " is a great movie!";
		}
		
		int followup = (int) (Math.random() * 5);
		
		switch (followup)
		{
		case 0:
			response += followUps[0] + "\n";
			break;
		case 3:
			response += followUps[1] + "\n";
		case 1:
			response += followUps[2] + "\n";
			break;
		default:
			response += followUps[4] + "\n";
			response += followUps[3] + "\n";
			break;
		}
		
		
		return response;
	}
	
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "am ambivalent about";
		verbs[3] = "am thinking about";
	}
	
	private void buildTopics()
	{
		topics[0] = "movies";
		topics[1] = "shopping";
		topics[2] = "cute animal memes";
		topics[3] = "programming";
		topics[4] = "animals";
		topics[5] = "rubber ducks";
		topics[6] = "bread";
	}
	
	
	public boolean lengthChecker(String input)
	{
		return false;
	}
	
	public boolean inputHTMLChecker(String input)
	{
		boolean containsHTML = false;
		if(input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">", firstOpen);
		int secondOpen = -9;
		int secondClose = -9;
		String tagText = "";
		
		//Check bad tags
		if (input.contains("<>") || input.indexOf("< >") > -1)
		{
			containsHTML = false;
		}
		//Check singleton
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br"))
		{
			containsHTML = true;
		}
		//Check others
		else if(firstClose > firstOpen)
		{
			//Others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" = tagText, firstClose);
		}
		
	}
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		return questions;
	}
	
	public String[] getVerbs()
	{
		return verbs;
	}

	public String[] getTopics()
	{
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return null;
	}
	
	public LocalTime getCurrentTime()
	{
		return null;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
