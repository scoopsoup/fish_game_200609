package game4;

import java.util.Scanner;

public class User extends Thread{

	Scanner sc = new Scanner(System.in);

	static String username;
	int money;
	String fishbar;
	String ship;
	int attact;
	int fishing;
	int steminer;
	int customer;
	boolean isLoop;
	boolean stop;
	Menu5 m5;

	public User() {
		money = 10000;
		fishbar = "�ö�ƽ���ô�";
		ship = "�����";
		attact = 10;
		fishing = 0;
		steminer = 20;
		customer = 0;
		isLoop = true;
		stop = true;
		m5 = new Menu5("intro.mp3", isLoop);

	}

	public void Intro() throws Exception {
		m5.start();
		System.out.println("���¾� ���ÿ�");
		Thread.sleep(300);
		System.out.println("������ �����մϴ�.");
		Thread.sleep(300);
	}
	
	public void VisitCustomer() {
		System.out.println("���� �湮�� �մ��� " + customer + "�� �Դϴ�.");
	}

	public void Name() {
		System.out.println("����� �̸��� �˷��ּ���.");
		String name = sc.nextLine();
		username = name;
	}

	public void Menu() {
		System.out.println("====================================");
		System.out.println("�޴��� �����Ͽ��ּ���.");
		System.out.println("0 : ���º���");
		System.out.println("1 : �����ϱ�");
		System.out.println("2 : ������ ����");
		System.out.println("3 : �����۱���");
		System.out.println("4 : ������ ����");
		System.out.println("5 : ������� on/off");
		System.out.println("6 : ���Ӽ���");
		System.out.println("7 : ��������");
		System.out.println("====================================");
	}

	public void UserInfo() {
		System.out.println("�̸� : " + username);
		System.out.println("������ : " + money);
		System.out.println("���ô� : " + fishbar);
		System.out.println("�� : " + ship);
		System.out.println("���ݷ�(���� ��) : " + attact);
		System.out.println("���ü����� : " + fishing);
		System.out.println("���׹̳� : " + steminer);
		System.out.println("�湮�մ� : " + customer);
	}

	public void close(boolean stop) {
		this.stop = stop;
	}


	public void run() {
		try {
			while(stop) {
				Thread.sleep(10000);//60000�� �ٲٱ�
				steminer++;
				customer ++;
				money += 1000;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}

