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
		fishbar = "플라스틱낚시대";
		ship = "나룻배";
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
		System.out.println("나는야 낚시왕");
		Thread.sleep(300);
		System.out.println("게임을 시작합니다.");
		Thread.sleep(300);
	}
	
	public void VisitCustomer() {
		System.out.println("현재 방문한 손님은 " + customer + "명 입니다.");
	}

	public void Name() {
		System.out.println("당신의 이름을 알려주세요.");
		String name = sc.nextLine();
		username = name;
	}

	public void Menu() {
		System.out.println("====================================");
		System.out.println("메뉴를 선택하여주세요.");
		System.out.println("0 : 상태보기");
		System.out.println("1 : 낚시하기");
		System.out.println("2 : 수족관 관리");
		System.out.println("3 : 아이템구매");
		System.out.println("4 : 번식장 관리");
		System.out.println("5 : 배경음악 on/off");
		System.out.println("6 : 게임설명");
		System.out.println("7 : 게임종료");
		System.out.println("====================================");
	}

	public void UserInfo() {
		System.out.println("이름 : " + username);
		System.out.println("소지금 : " + money);
		System.out.println("낚시대 : " + fishbar);
		System.out.println("배 : " + ship);
		System.out.println("공격력(당기는 힘) : " + attact);
		System.out.println("낚시성공률 : " + fishing);
		System.out.println("스테미나 : " + steminer);
		System.out.println("방문손님 : " + customer);
	}

	public void close(boolean stop) {
		this.stop = stop;
	}


	public void run() {
		try {
			while(stop) {
				Thread.sleep(10000);//60000로 바꾸기
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

