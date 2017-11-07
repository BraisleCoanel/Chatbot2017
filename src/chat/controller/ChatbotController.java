package chat.controller;

import java.util.List;
import java.util.ArrayList;
import chat.view.PopupDisplay;
import chat.model.Chatbot;

public class ChatbotController
{
	
	private PopupDisplay display;
	private Chatbot chatbot;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("Branton Martinson");
		display = new PopupDisplay();
	}
	
	public void start()
	{
		
		
		String response = display.collectResponse("What do you want to talk about?");
		
		while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response));
		{
			response = popupChat(response);
			response = display.collectResponse(response);
		}
	}
	
	public String interactWithChatbot(String input)
	{
		return null;
	}
	
	private String popupChat(String chat)
	{
		String chatbotSays = "";
		
		chatbotSays += chatbot.processConversation(chat);
		
		return chatbotSays;
				
	}
	
	public Chatbot getChatbot() 
	{
		return chatbot;
	}
	
	public PopupDisplay getDisplay()
	{
		return display;
	}
	
}
