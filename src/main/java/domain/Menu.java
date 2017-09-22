package domain;

import models.Client;
import models.ClientType;
import persistence.Persistence;
import services.ClienteService;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private static void createClient() {

        System.out.println("Indique o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Tipo de cliente : NORMAL(1) OR VIP(2) : ");
        int typeClient = Integer.valueOf(scanner.nextLine().trim());
        Client client = null;
        if(typeClient == 1) client = new Client(nome, ClientType.NORMAL);
        if(typeClient == 2) client = new Client(nome, ClientType.VIP);
        ClienteService clienteService = new ClienteService();
        clienteService.register(client);

        presentMenuOrExit();

    }

    private static void presentMenuOrExit() {
        System.out.println("(1) MENU INICIAL  (2) SAIR");

        int number = Integer.valueOf(scanner.nextLine().trim());
        if(number == Number.ONE.getNumber()){
            presentFirstMenu();
            return;
        } else if (number == Number.TWO.getNumber()){
            displayEndMessage();
            return;
        }

    }

    private static void listAllClients(){

        List<Client> clients = Persistence.getClientBag();
        if(clients.isEmpty()){
            System.out.println("Este banco não tem clientes.\n");
            presentMenuOrExit();
            return;
        }

        System.out.println("\n============ CLIENT LIST =============");
        for (Client client : clients) {
            System.out.println(client.getName() + "  " + client.getIndentifier() + "\n");
        }
        System.out.println("=========================");

        presentMenuOrExit();

    }

    public static void presentFirstMenu() throws NumberFormatException {
        System.out.println("==================================");
        System.out.println("||  1 -  CRIAR UM CLIENTE       ||");
        System.out.println("||  2 -  LISTAR OS CLIENTES     ||");
        System.out.println("||  3 -  OPCOES DO CLIENTE      ||");
        System.out.println("||  4 -  SELECIONAR UM CARTAO   ||");
        System.out.println("||  5 -  AVANÇAR UM PERIODO     ||");
        System.out.println("||  6 -  SAIR                   ||\n");
        System.out.println("Por favor, selecione uma opcao: ");
        System.out.println("==================================");


        int number = 0;
        try {
            number = Integer.valueOf(scanner.nextLine().trim());
            if(number >= 1 && number <= 5) presentSecondMenu(number);
            if(number == 6){
                displayEndMessage();
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Só pode digitar numeros entre 1 e 6");
            presentFirstMenu();

        }

    }

    private static void presentSecondMenu(int choice) {
        switch (choice) {
            case 1:
                Menu.createClient();
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

                //displayEndMessage();
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

    private static void displayEndMessage(){
        System.out.println("Thank you for acessing our bank...");

    }

}
