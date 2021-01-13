package application;

import java.sql.Connection;
import java.util.Scanner;

import db.DB;
import domain.FindUser;

public class Program {

	public static void main(String[] args) {
		int opt = 0;

		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Escolha uma opção: 1- Listar, 2-Criar, 3-Atualizar, " + "4-Deletar, 5-Close");

			opt = sc.nextInt();

			switch (opt) {
				case 1:
					FindUser.handle();
				break;
			}

		} while (opt != 5);
		
		sc.close();
		
	}

}
