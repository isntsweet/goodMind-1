package com.example.demo.entity;

public class ChatBot {
	private String category;
	private String user;
	private String chatbot;

	public ChatBot() {
	}

	public ChatBot(String category, String user, String chatbot) {
		this.category = category;
		this.user = user;
		this.chatbot = chatbot;
	}

	@Override
	public String toString() {
		return "ChatBot [category=" + category + ", user=" + user + ", chatbot=" + chatbot + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getChatbot() {
		return chatbot;
	}

	public void setChatbot(String chatbot) {
		this.chatbot = chatbot;
	}

}
