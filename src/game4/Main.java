package game4;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		Menu1 m1 = new Menu1();
		Menu2 m2 = new Menu2();
		Menu3 m3 = new Menu3();
		Menu4 m4 = new Menu4();
		Menu6 m6 = new Menu6();
		User user = new User();

		
		user.Intro();
		user.start();
		m2.start();
		user.Name();
		user.VisitCustomer();
		Thread.sleep(300);
		int num = 0;
		while(num != 7) {
			user.Menu();
			num = sc.nextInt();
			ChooseMenu cm = new ChooseMenu(m1, m2, m3, m4, m6);
			Thread.sleep(300);
			cm.ShowInfo(num, user, m1, m2, m3, m4, m6);
		}
		

	}

}
