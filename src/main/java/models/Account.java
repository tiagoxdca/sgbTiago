package models;

import java.util.UUID;

public class Account {
	
	private UUID identifier;
	private Card card;
	private double balance;
	private Client client;

	
	
	public Account(Client client) {
		this.client = client;
	}

	public UUID getIdentifier() {
		return identifier;
	}

	public void setIdentifier(UUID identifier) {
		this.identifier = identifier;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

}
