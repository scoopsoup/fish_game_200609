package game4;

import java.util.Scanner;

public class ChooseMenu {

	Scanner sc = new Scanner(System.in);
	
	public ChooseMenu(Menu1 m1, Menu2 m2, Menu3 m3, Menu4 m4, Menu6 m6) {
		
	}

	public static void Pules() throws Exception {
		System.out.println("====================================");
		System.out.println("������ �����Ϸ��� Enter�� ��������.");
		System.in.read();
	}

	public void ShowInfo(int num, User user, Menu1 m1, Menu2 m2, Menu3 m3, Menu4 m4, Menu6 m6) throws Exception {
		if(num == 0) {
			user.UserInfo();
			Pules();
		}
		else if(num == 1) {
			m1.activity(user, m2);
			Pules();
		}
		else if(num == 2) {
			m2.showMenu();
			int chnum = Integer.parseInt(sc.nextLine());
			m2.Choose(chnum, user, m1, m2);
			Pules();
		}
		else if(num == 3) {
			m3.ShowItem();
			System.out.println("�������� ������.");
			int item = Integer.parseInt(sc.nextLine());
			System.out.println(m3.Item(item, user));
			m3.ChooseItem(item, user);
			Pules();
		}
		else if(num == 4) {
			m4.ShowMenu();
			int chnum = Integer.parseInt(sc.nextLine());
			m4.Choose(chnum, m2, m4);
			Pules();
		}
		else if(num == 5) {
			if (user.isLoop == true) {
				user.m5.close();
				user.isLoop = false;
				user.m5 = new Menu5("intro.mp3", true);//Music���Ͽ� intro.mp3������ �־�����Ѵ�.
				//���۱ǹ����� GitHub���� ���ε����� ����.
			}
			else {
				user.m5.start();
				user.isLoop = true;
			}
			Pules();
		}
		else if(num == 6) {
			m6.ShowMenu();
			Pules();
		}
		else if(num == 7) {
			user.isLoop = false;
			user.m5.close();
			user.stop = false;
			user.close(user.stop);
			//m4.stop = false;
			m4.close(false);
			user.close(false);
			m2.close(false);
			System.out.println("������ �����մϴ�.");
		}
		else {
			System.out.println("�߸��� �޴� �����Դϴ�.");
		}
	}

}
