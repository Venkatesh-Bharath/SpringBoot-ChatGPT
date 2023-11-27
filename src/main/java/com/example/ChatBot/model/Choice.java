package com.example.ChatBot.model;

public class Choice {
  private int index;
  private Message message;
public int getIndex() {
	return index;
}
public void setIndex(int index) {
	this.index = index;
}
public Message getMessage() {
	return message;
}
public void setMessage(Message message) {
	this.message = message;
}
public Choice(int index, Message message) {
	super();
	this.index = index;
	this.message = message;
}
public Choice() {
	// TODO Auto-generated constructor stub
}
}
