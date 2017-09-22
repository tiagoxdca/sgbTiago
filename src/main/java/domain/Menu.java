package domain;

import models.Client;
import models.ClientType;
import persistence.Persistence;
import services.ClienteService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void createClient(Scanner scanner, int chooseNumber) {

        System.out.println("Indique o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Tipo de cliente : NORMAL(1) OR VIP(2) : ");
        int typeClient = Integer.valueOf(scanner.nextLine());
        Client client = null;
        if(typeClient == 1) client = new Client(nome, ClientType.NORMAL);
        if(typeClient == 2) client = new Client(nome, ClientType.VIP);
        ClienteService clienteService = new ClienteService();
        clienteService.register(client);

        System.out.println("(1) MENU INICIAL  (2) SAIR");
        int number = Integer.valueOf(scanner.nextLine());
        if(number == 2) chooseNumber = 6;

    }

    public static void listAllClients(){
        List<Client> clients = Persistence.getClientBag();
        for (Client client : clients) {
            System.out.println(client.getName() + "  " + client.getIndentifier());

        }
    }

    public static void presentFirstMenu() {
        System.out.println("===========================");
        System.out.println("1 -  CRIAR UM CLIENTE");
        System.out.println("2 -  LISTAR OS CLIENTES");
        System.out.println("3 -  OPCOES DO CLIENTE");
        System.out.println("4 -  SELECIONAR UM CARTAO");
        System.out.println("5 -  AVANÇAR UM PERIODO");
        System.out.println("6 -  SAIR\n\n");
        System.out.println("Por favor, selecione uma opcao: ");
        System.out.println("===========================");


        int number = Integer.valueOf(scanner.nextLine());
        presentSecondMenu(number);
    }

    public static void presentSecondMenu(int choice) {
        switch (choice) {
            case 1:
                Menu.createClient(scanner, choice);
                break;
            case 2:
                Menu.listAllClients();
                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            default:

                System.out.println("Obrigado por acessar o nosso banco...");
                break;
        }
    }

    public enum Number{
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
        private int number;
        Number(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void displayEndMessage(){
        System.out.println("Thank you for acessing our bank...");
    }

}
