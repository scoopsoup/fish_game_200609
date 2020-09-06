package game4;

import java.util.Scanner;

public class Menu2 extends Thread{
	Scanner sc = new Scanner(System.in);
	int fishnum[] = new int[14];//������
	String fishtype[] = {"��", "��ġ", "���", "����", "��¡��", "�޲ٹ�", "�ɰ�", "����", "�׾�", "����", "�Ƕ��", "������"};
	int fishPrice[] = {10000, 9000, 8000, 7000, 6000, 5000, 4000, 3000, 2000, 1000, 500, -200};
	int fishmoney = 0;
	boolean stop;
	int disturbance = 0;

	public Menu2() {
		fishnum[0] = 5;//������ ũ��
		fishnum[1] = 1;//��ü ������
		fishnum[2] = 2;
		stop = true;
	}


	public void showMenu() {
		System.out.println("0 : ������ ���º���");
		System.out.println("1 : ������ ����� ���ݺ���");
		System.out.println("2 : ������ ������ �ø���");
		System.out.println("3 : ����� �о��ϱ�");
		System.out.println("4 : �̴ϰ���(��������)");
		System.out.println("5 : ������ �����ϱ�");
	}

	public void AquariumState(Menu2 m2) {
		System.out.println("������ ũ�� : " + fishnum[0]);
		System.out.println("���� ������ ����� �� : " + fishnum[1]);
		int a = 0;
		for (int i = 2; i < fishnum.length; i++) {
			if(fishnum[i] != 0) {
				System.out.println(fishtype[i - 2] + " : " + fishnum[i]);
				a++;
			}
		}
		if(a == 0) {
			System.out.println("�������� ����Ⱑ �����ϴ�.");
			System.out.println("���ø� �Ͽ� ����⸦ ��������!");
		}
	}

	public void ExpandAquarium(User user) {
		System.out.println("���� �������� ũ��� " + fishnum[0] + "�Դϴ�.");
		System.out.println("�������� 1�ø� �� ���� 2000���� ����� �߻��մϴ�.");
		System.out.println("�������� �����Ͻðڽ��ϱ�?[y/n]");
		String answer = sc.nextLine();
		if(answer.equals("y")) {
			System.out.println("�ø� ũ�⸦ �Է��ϼ���.");
			int size = Integer.parseInt(sc.nextLine());
			if(user.money < (size * 2000)) {
				System.out.println("�������� �����մϴ�.");
			}
			else {
				fishnum[0] += size;
				user.money -= (2000 * size);
			}

		}
		else {

		}
	}

	public void Sell(User user) {
		int b = 0;
		int j = 0;
		System.out.println("� ����⸦ �о��Ͻǰǰ���?");
		String fishname = sc.nextLine();
		for(int i = 2; i < fishnum.length; i++) {
			if(fishname.equals(fishtype[i - 2])) {
				if(fishnum[i] != 0) {
					System.out.println("����" + fishnum[i] + "������ " + fishname + "�� �ֽ��ϴ�.");
					b++;
					j = i - 2;
				}
			}
		}
		if(b == 0) {
			System.out.println("�������� " + fishname + "�� �����ϴ�.");
		}
		else {
			System.out.println("�Ǹ��Ͻðڽ��ϱ�?[y/n]");
			String answer = sc.nextLine();
			if(answer.equals("y")) {
				System.out.println("�� ������ ����⸦ �Ľðڽ��ϱ�?");
				int sellnum = Integer.parseInt(sc.nextLine());
				fishmoney -= (fishPrice[j] * sellnum);
				user.money += (fishPrice[j] * sellnum);
				fishnum[j + 2] -= sellnum;
				fishnum[1] -= sellnum;
			}

		}
	}

	public void FishPrice() {
		for (int i = 2; i < fishnum.length; i++) {
			if(fishnum[i] != 0) {
				System.out.println(fishtype[i - 2] + " ����� ����(x" + fishnum[i] + ") : " + fishPrice[i - 2] + "x" + fishnum[i] + "(" + (fishPrice[i - 2] * fishnum[i]) + ") ��");
				fishmoney += (fishPrice[i - 2] * fishnum[i]);
			}
		}
		System.out.println("�����ϰ� �ִ� ����� �� ���� : " + fishmoney + "��");
	}

	public void MiniGame(User user) {
		System.out.println("����� ���� ����!");
		System.out.println("����⸦ ��������.(����� B, ����� F)");
		System.out.println("��(w) ��(s) ��(a) ��(d)");
		System.out.println("�� �� ������ ������ 1000���� ����� �߻��մϴ�.");
		int aqua[][] = new int[8][8];
		int r = 0;
		int c = 0;
		int a = (int)(Math.random() * 8);
		int b = (int)(Math.random() * 8);
		int k;

		for (k = 0; k < 8; k++) {
			for (int i = 0; i < aqua.length; i++) {
				for (int j = 0; j < aqua[i].length; j++) {
					if(i == r && j == c) {
						System.out.print("B ");
					}
					else if(i == a && j == b) {
						System.out.print("F ");
					}
					else {
						System.out.print("* ");
					}
				}
				System.out.println();
			}
			System.out.println("Ű�� �Է��Ͻÿ�");
			String key = sc.nextLine();
			if(key.equals("w") || key.equals("W")) {
				r--;
			}
			else if(key.equals("s") || key.equals("S")) {
				r++;
			}
			else if(key.equals("a") || key.equals("A")) {
				c--;
			}
			else {
				c++;
			}

			if(r == a && c == b){
				System.out.println("you win!");
				disturbance = 1;
				break;
			}
		}
		if(k == 8) {
			disturbance = 0;
			System.out.println("game over");
		}

		user.money -= 1000;
	}

	public void Advertisement(User user) {
		String means[] = {"���̱���", "TV����", "SNS����", "�����Ǳ���"};
		int adver[] = {1000, 5000, 3000, 10000};
		System.out.println("���� ������ �����ϼ���.");
		System.out.println("1. ���̱��� || 2. TV���� || 3. SNS���� || 4. �����Ǳ���");
		int choose = Integer.parseInt(sc.nextLine());
		System.out.println(means[choose - 1] + "�� ����� " + adver[choose - 1] + "�Դϴ�.");
		System.out.println(means[choose - 1] + "�� �̿��� ���� �Ͻðڽ��ϱ�?[y/n]");
		String answer = sc.nextLine();
		if(answer.equals("y")) {
			if(user.money < adver[choose - 1]) {
				System.out.println("�������� �����մϴ�.");
			}
			else {
				user.money -= adver[choose - 1];
			}

		}
	}

	public int random(int num) {
		num = (int)((Math.random()) * 11);//0-10
		while(true) {
			if(fishnum[num + 2] == 0) {
				num = (int)((Math.random()) * 11);
			}
			else {
				break;
			}
		}
		return num;
	}

	public void close(boolean stop) {
		this.stop = stop;
	}

	public void run() {

		try {
			
			while(stop) {
				Thread.sleep(30000);
				//Menu2 m2 = new Menu2();
				int num = 0;
				//������
				if(fishnum[13] > 0) {
					if(fishnum[1] > 0) {
						System.out.println("������ ó���ʿ�!");
						Thread.sleep(30000);
						
						if(fishnum[13] > 0) {
							num = (int)((Math.random()) * 11);//0-10
							
							while(true) {
								if(fishnum[num + 2] == 0) {
									num = (int)((Math.random()) * 11);
								}
								else {
									break;
								}
							}
							
							fishnum[1]--;
							fishnum[num + 2]--;
						}
						
						else {
							fishnum[1] = fishnum[1] + 0;
							fishnum[num + 2] = fishnum[num + 2] + 0;
						}
						
					}
					else {
						fishnum[1] = fishnum[1] + 0;
						fishnum[num + 2] = fishnum[num + 2] + 0;
					}
				}
				else {
					fishnum[1] = fishnum[1] + 0;
					fishnum[num + 2] = fishnum[num + 2] + 0;
				}

				//����
				if(disturbance == 0){
					if(fishnum[1] > 1) {
						System.out.println("����� ���� �߻�!");
						Thread.sleep(30000);
						if(disturbance == 0) {
							
							num = (int)((Math.random()) * 11);//0-10
							
							while(true) {
								if(fishnum[num + 2] == 0) {
									num = (int)((Math.random()) * 11);
								}
								else {
									break;
								}
							}

							fishnum[1]--;
							fishnum[num + 2]--;
						}
						else {
							fishnum[1] = fishnum[1] + 0;
							fishnum[num + 2] = fishnum[num + 2] + 0;
						}

					}
					else {
						fishnum[1] = fishnum[1] + 0;
						fishnum[num + 2] = fishnum[num + 2] + 0;
					}

				}
				else {
					fishnum[1] = fishnum[1] + 0;
					fishnum[num + 2] = fishnum[num + 2] + 0;
				}
			}
		}

	 catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public void Choose(int num, User user, Menu1 m1, Menu2 m2) {
	if(num == 0) {
		m2.AquariumState(m2);
	}
	else if(num == 1) {
		m2.FishPrice();
	}
	else if(num == 2) {
		m2.ExpandAquarium(user);
	}
	else if(num == 3) {
		m2.Sell(user);
	}
	else if(num == 4) {
		m2.MiniGame(user);
	}
	else {
		m2.Advertisement(user);
	}
}

}
