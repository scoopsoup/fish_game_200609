package game4;

import java.util.Scanner;

public class Menu3{

	public Menu3() {

	}

	int pricearr[] = {2000, 5000, 10000, 10000, 20000, 40000, 1000};
	String itemarr[] = {"대나무낚시대", "유리낚시대", "카본낚시대", "돚단배", "요트", "원양어선", "박카스"};
	int attactarr[] = {10, 20, 30, 30, 35, 40, 10};

	public void ShowItem() {
		System.out.println("구매하실 아이템을 선택해주세요.");
		System.out.println("낚시대(당기는 힘 증가)----------------");
		System.out.println("0 : 대나무낚시대                    (2000원)");
		System.out.println("1 : 유리낚시대                       (5000원)");
		System.out.println("2 : 카본낚시대                       (10000원)");
		System.out.println("배(물고기잡을 확률 증가)--------------");
		System.out.println("3 : 돚단배                            (10000원)");
		System.out.println("4 : 요트                               (20000원)");
		System.out.println("5 : 원양어선                         (40000원)");
		System.out.println("회복아이템(스테미나 회복)-------------");
		System.out.println("6 : 박카스                            (1000원)");
	}

	public String Item(int item, User user) {
		Menu3 m3 = new Menu3();
		if(item < 3) {
			return "이름 : " + itemarr[item] + "\n가격 : " + pricearr[item] + "\n공격력 : " + attactarr[item] + "\n구매여부 : " + m3.Buying(item, user) +  "\n구매하시겠습니까?";
		}
		else if(3 <= item && item < 6) {
			return "이름 : " + itemarr[item] + "\n가격 : " + pricearr[item] + "\n낚시성공률 : +" + attactarr[item] + "\n구매여부 : " + m3.Buying(item, user) +  "\n구매하시겠습니까?";
		}
		else {
			return "이름 : " + itemarr[item] + "\n가격 : " + pricearr[item] + "\n스테미나 : +" + attactarr[item] + "\n구매하시겠습니까?";
		}
	}

	public void ChooseItem(int item, User user) {
		System.out.println("1. 구매하기");
		System.out.println("2. 나가기");
		Scanner sc = new Scanner(System.in);
		int answer = Integer.parseInt(sc.nextLine());
		if(answer == 1) {
			if(itemarr[item] == user.fishbar || itemarr[item] == user.ship) {
				System.out.println("구매하신 제품입니다.");
			}
			else if(user.money < pricearr[item]) {
				System.out.println("소지금이 부족합니다.");
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
					System.out.println("몇개의 박카스를 구매하시겠습니까?");
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
			return "구매함";
		}
		else {
			return "구매하지 않음";
		}
	}

}
