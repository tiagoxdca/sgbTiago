package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Card {
	
	
	private UUID cardIdentifier;
	private CardType cardType;
	
	private Account account;
	private Client client;
	private List<String> movements = new ArrayList<>();
	
	public Card(CardType type, Account account, Client client){
		this.account = account;
		this.cardIdentifier = UUID.randomUUID();
		this.cardType = type;
		this.client = client;
	}

	public UUID getCardIdentifier() {
		return cardIdentifier;
	}

	public void transferTo(Account account, double value){}
	
	public void deposit(double value){}
	
	public void raise(double value){}
	
	protected double checkAccountBalance(){
		return this.account.getBalance();
	}
	
	protected String printClientInformation(){
		return this.client.toString();
	}
	
	

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public List<String> getMovements() {
		return movements;
	}

	public void setMovements(List<String> movements) {
		this.movements = movements;
	}

	@Override
	public String toString() {
		return "Cartao do cliente " + client.getName() + "com numero " + cardIdentifier;
	}
	

}
