package models;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data
//@AllArgsConstructor
//@Builder
public class Client {
	
	private UUID indentifier;
	private String name;
	private String internalNumber;
	private String email;
	private ClientType typeClient;
	private List<Account> accounts;
	private List<Card> cards;
	
	public Client(){

	}

	public Client(String name, ClientType typeClient) {
		this.name = name;
		this.typeClient = typeClient;
	}
	
	public ClientType getTypeClient() {
		return typeClient;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public UUID getIndentifier() {
		return indentifier;
	}
	public void setIndentifier(UUID indentifier) {
		this.indentifier = indentifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInternalNumber() {
		return internalNumber;
	}
	public void setInternalNumber(String internalNumber) {
		this.internalNumber = internalNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
