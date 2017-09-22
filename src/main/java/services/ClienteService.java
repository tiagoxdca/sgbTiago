package services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import models.Account;
import models.Card;
import models.CardType;
import models.Client;
import models.ClientType;
import persistence.Persistence;

public class ClienteService {

	public Client register(Client c) {
		c.setIndentifier(UUID.randomUUID()); // BR: client unique identifier
		createAccount(c, c.getTypeClient());
		return c;
	}

	private void createAccount(Client c, ClientType clientType) {
		Account account = new Account(c);
		account.setIdentifier(UUID.randomUUID());
		if (c.getAccounts() == null || c.getAccounts().isEmpty()) {
			List<Account> accounts = new ArrayList<>();
			c.setAccounts(accounts);
		}
		c.getAccounts().add(account);
        createCard(CardType.DEBIT, account, c);

	}

	private void createCard(CardType type, Account account, Client client) {

		Card card;
		switch (type) {
		case DEBIT:
			card = new Card(CardType.DEBIT, account, client);
			break;
		case CREDIT:
			card = new Card(CardType.CREDIT, account, client);
		default:
			card = new Card(CardType.DEBIT, account, client);
		}

		if (client.getCards() == null || client.getCards().isEmpty()) {
			List<Card> cards = new ArrayList<>();
			client.setCards(cards);
		}
		client.getCards().add(card);
        Persistence.addClient(client);
        showClientInformation(client);
		System.out.println("------------------------------------------------------");


	}

	public void showClientInformation(Client client){
        System.out.println("===========================");
        System.out.println("\n Cliente criado com sucesso.\n");
        System.out.println("Name:   " + client.getName());
        System.out.println("Identifier:   " + client.getIndentifier());
        System.out.println("Account Id:   " + client.getAccounts().get(0).getIdentifier());
        System.out.println("Card Id:   " + client.getCards().get(0).getCardIdentifier());
        System.out.println("\n =========================\n");

    }

}
