package domain;

import java.util.Scanner;

import models.Client;
import services.ClienteService;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	static int chooseNumber = 0;

	public static void main(String[] args) {

		while (chooseNumber != 6) {
			chooseNumber = presenFirstMenu();
			presentSecondMenu(chooseNumber);

		}

		System.out.println("Obrigado por ter acessado o nosso banco...");

	}

	public static int presenFirstMenu() {
		System.out.println("1 -  CRIAR UM CLIENTE");
		System.out.println("2 -  LISTAR OS CLIENTES");
		System.out.println("3 -  OPCOES DO CLIENTE");
		System.out.println("4 -  SELECIONAR UM CARTAO");
		System.out.println("5 -  AVANÇAR UM PERIODO");
		System.out.println("6 -  SAIR\n\n");
		System.out.println("Por favor, selecione uma opcao: ");

		int number = Integer.valueOf(scanner.nextLine());
		return number;
	}

	public static void presentSecondMenu(int choice) {
		switch (choice) {
		case 1:
			createClient();
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		default:

			presenFirstMenu();
			break;
		}
	}
	
	
private static void createClient() {
		
		System.out.println("Indique o seu nome: ");
		String nome = scanner.nextLine();
		System.out.println("Tipo de cliente : NORMAL(1) OR VIP(2) : ");
		int typeClient = Integer.valueOf(scanner.nextLine());
		//Client client = new Client(nome, typeClient);
		ClienteService clienteService = new ClienteService();
		//clienteService.register(client);
		
		System.out.println("(1) MENU INICIAL  (2) SAIR");
		int number = Integer.valueOf(scanner.nextLine());
		if(number == 2) chooseNumber = 6; 
		
	}
	
	
	

}
