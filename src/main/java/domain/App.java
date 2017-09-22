package domain;

import java.util.Scanner;

import models.Client;
import models.ClientType;
import services.ClienteService;

public class App {

	private static Scanner scanner = new Scanner(System.in);

	static int menuNumber = 0;

	public static void main(String[] args) {

		while (menuNumber != Menu.Number.SIX.getNumber()) {
			Menu.presentFirstMenu();
		}

        Menu.displayEndMessage();

	}
}
