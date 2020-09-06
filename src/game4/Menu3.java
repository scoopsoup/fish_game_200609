package game4;

import java.util.Scanner;

public class Menu3{

	public Menu3() {

	}

	int pricearr[] = {2000, 5000, 10000, 10000, 20000, 40000, 1000};
	String itemarr[] = {"�볪�����ô�", "�������ô�", "ī�����ô�", "���ܹ�", "��Ʈ", "����", "��ī��"};
	int attactarr[] = {10, 20, 30, 30, 35, 40, 10};

	public void ShowItem() {
		System.out.println("�����Ͻ� �������� �������ּ���.");
		System.out.println("���ô�(���� �� ����)----------------");
		System.out.println("0 : �볪�����ô�                    (2000��)");
		System.out.println("1 : �������ô�                       (5000��)");
		System.out.println("2 : ī�����ô�                       (10000��)");
		System.out.println("��(��������� Ȯ�� ����)--------------");
		System.out.println("3 : ���ܹ�                            (10000��)");
		System.out.println("4 : ��Ʈ                               (20000��)");
		System.out.println("5 : ����                         (40000��)");
		System.out.println("ȸ��������(���׹̳� ȸ��)-------------");
		System.out.println("6 : ��ī��                            (1000��)");
	}

	public String Item(int item, User user) {
		Menu3 m3 = new Menu3();
		if(item < 3) {
			return "�̸� : " + itemarr[item] + "\n���� : " + pricearr[item] + "\n���ݷ� : " + attactarr[item] + "\n���ſ��� : " + m3.Buying(item, user) +  "\n�����Ͻðڽ��ϱ�?";
		}
		else if(3 <= item && item < 6) {
			return "�̸� : " + itemarr[item] + "\n���� : " + pricearr[item] + "\n���ü����� : +" + attactarr[item] + "\n���ſ��� : " + m3.Buying(item, user) +  "\n�����Ͻðڽ��ϱ�?";
		}
		else {
			return "�̸� : " + itemarr[item] + "\n���� : " + pricearr[item] + "\n���׹̳� : +" + attactarr[item] + "\n�����Ͻðڽ��ϱ�?";
		}
	}

	public void ChooseItem(int item, User user) {
		System.out.println("1. �����ϱ�");
		System.out.println("2. ������");
		Scanner sc = new Scanner(System.in);
		int answer = Integer.parseInt(sc.nextLine());
		if(answer == 1) {
			if(itemarr[item] == user.fishbar || itemarr[item] == user.ship) {
				System.out.println("�����Ͻ� ��ǰ�Դϴ�.");
			}
			else if(user.money < pricearr[item]) {
				System.out.println("�������� �����մϴ�.");
			}
			else {
				user.money = user.money - pricearr[item];

				if(item < 3) {
					user.fishbar = itemarr[item];
					user.attact = user.attact + attactarr[item];
				}
				else if(3 <= item && item < 6) {
					user.ship = itemarr[item];
					user.fishing = user.fishing + attactarr[item];
				}
				else {
					System.out.println("��� ��ī���� �����Ͻðڽ��ϱ�?");
					int num = Integer.parseInt(sc.nextLine());
					user.steminer = user.steminer + (attactarr[item] * num);
					user.money = user.money - (pricearr[item] * (num - 1));
				}
			}

		}
		else {

		}
	}

	public String Buying(int item, User user) {
		if(itemarr[item] == user.fishbar) {
			return "������";
		}
		else {
			return "�������� ����";
		}
	}

}
