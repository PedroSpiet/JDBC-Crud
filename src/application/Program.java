package application;

import java.util.Scanner;

import domain.CreateUser;
import domain.FindOneUser;
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
				
				case 2: 
					String name = sc.next();
					CreateUser.handle(name);
				break;
				
				case 3: 
					int id = sc.nextInt();
					FindOneUser.handle(id);
				break;
			}

		} while (opt != 5);
		
		sc.close();
		
	}

}
