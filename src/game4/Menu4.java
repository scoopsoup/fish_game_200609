package game4;

import java.util.Scanner;

public class Menu4 extends Thread{
	Scanner sc = new Scanner(System.in);

	boolean stop;
	int k = 0 ;
	int breedfish[] = new int[14];//������
	int restart;

	
	public Menu4() {
		breedfish[0] = 5;
		breedfish[1] = 2;
		breedfish[2] = 2;
		restart = 0;
		stop = true;
	}

	public void ShowMenu() {
		System.out.println("0. ���������� ����� ��������");
		System.out.println("1. ���������� ����� ������");
		System.out.println("2. ������ ���º���");
		System.out.println("3. ����� ���Ľ�Ű��");
	}

	public void GetFish(Menu2 m2) {
		System.out.println("� ����⸦ �������ڽ��ϱ�?");
		String fish = sc.nextLine();
		int a = 0;
		int j = 0;
		for (int i = 2; i < m2.fishnum.length; i++) {
			if(fish.equals(m2.fishtype[i - 2])) {
				if(m2.fishnum[i] != 0) {
					System.out.println("�������� " + fish + "�� " + m2.fishnum[i] + "���� �ֽ��ϴ�.");
					a++;
					j = i;
				}
			}
		}
		if(a != 0) {
			System.out.println(j);
			System.out.println(fish + "�� �������ðڽ��ϱ�?[y/n]");
			String answer = sc.nextLine();
			if(answer.equals("y")) {
				System.out.println("�� ������ ����⸦ �������ðڽ��ϱ�?");
				int getnum = Integer.parseInt(sc.nextLine());
				if(getnum <= m2.fishnum[j]) {
					System.out.println(m2.fishnum[j]);
					m2.fishnum[1] -= getnum;
					m2.fishnum[j] -= getnum;
					breedfish[1] += getnum;
					breedfish[j] += getnum;
					System.out.println(breedfish[1]);
					System.out.println("ok");
				}

			}
		}
		else {
			System.out.println("�������� " + fish + "�� �����ϴ�.");
		}


	}

	public void SendFish(Menu2 m2, Menu4 m4) {
		int a = 0;
		int j = 0;
		System.out.println("� ����⸦ �����ڽ��ϱ�?");
		String fish = sc.nextLine();
		for (int i = 2; i < breedfish.length; i++) {
			if(fish.equals(m2.fishtype[i - 2])) {
				if(breedfish[i] != 0) {
					System.out.println("�����忡 " + fish + "�� " + breedfish[i] + "���� �ֽ��ϴ�.");
					a++;
					j = i - 2;
				}
			}
		}
		if(a == 0) {
			System.out.println("�����忡 " + fish + "�� �����ϴ�.");
		}
		else {
			System.out.println(fish + "�� ���������� �ű�ڽ��ϱ�?[y/n]");
			String answer = sc.nextLine();
			if(answer.equals("y")) {
				System.out.println("�� ������ �ű�ڽ��ϱ�?");
				int sendnum = Integer.parseInt(sc.nextLine());
				breedfish[j + 2] -= sendnum;
				m4.BreedingStop(m2, m4);
				breedfish[1] -= sendnum;
				m2.fishnum[1] += sendnum;
				m2.fishnum[j + 2] += sendnum;
				System.out.println(breedfish[1]);
			}
		}
	}

	public void showBreeding(Menu2 m2, Menu4 m4){
		int a = 0;
		System.out.println("������ ũ�� : " + breedfish[0]);
		System.out.println("���� ������ ����� �� : " + breedfish[1]);
		for (int i = 2; i < breedfish.length; i++) {
			if(breedfish[i] != 0) {
				System.out.println(m2.fishtype[i - 2] +": " + breedfish[i]);
				a++;
			}
		}
		if(a == 0) {
			System.out.println("�����忡 ����Ⱑ �����ϴ�.");
			System.out.println("���������� ����⸦ �ű⼼��.");
		}
	}

	public void Breeding(Menu2 m2, Menu4 m4) {
		System.out.println("���Ľ�ų ����⸦ �Է��ϼ���.");
		String fish = sc.nextLine();
		for (int i = 0; i < m2.fishtype.length; i++) {
			if(fish.equals(m2.fishtype[i])) {
				if(breedfish[i + 2] > 1 && restart == 0) {
					k = i;
					restart = 1;
					stop = true;
					m4.start();
					System.out.println("ww");
				}
				else if(breedfish[i + 2] > 1 && (restart == 1 || restart == 2)) {
					//System.out.println(breedfish[i + 2]);
					restart = 1;//3���� �߾���
					stop = true;
					System.out.println("cc");
				}
			}
		}
	}

	public void BreedingStop(Menu2 m2, Menu4 m4) {
		if(breedfish[k + 2] < 2 && (restart == 1)) {//restart == 1 || restart == 3
			restart = 2;
			stop = true;
			System.out.println("oo");
		}
	}

	public void close(boolean stop) {
		this.stop = stop;
	}


	public void run() {
		try {
			while(stop) {
				if(restart == 1) {
					breedfish[k + 2]++;
					breedfish[1]++;
					Thread.sleep(10000);
				}
				else if(restart == 2){
					breedfish[k + 2] = breedfish[k + 2];
					breedfish[1] = breedfish[1] + 0;
					Thread.sleep(100);
				}

			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Choose(int chnum, Menu2 m2, Menu4 m4) throws Exception {
		if(chnum == 0) {
			m4.GetFish(m2);
		}
		else if(chnum == 1){
			m4.SendFish(m2, m4);
		}
		else if(chnum == 2) {
			m4.showBreeding(m2, m4);
		}
		else {
			m4.Breeding(m2, m4);
		}
	}

}
