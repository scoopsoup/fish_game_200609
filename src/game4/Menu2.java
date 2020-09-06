package game4;

import java.util.Scanner;

public class Menu2 extends Thread{
	Scanner sc = new Scanner(System.in);
	int fishnum[] = new int[14];//수족관
	String fishtype[] = {"고래", "참치", "상어", "문어", "오징어", "쭈꾸미", "꽃개", "새우", "잉어", "가재", "피라미", "쓰레기"};
	int fishPrice[] = {10000, 9000, 8000, 7000, 6000, 5000, 4000, 3000, 2000, 1000, 500, -200};
	int fishmoney = 0;
	boolean stop;
	int disturbance = 0;

	public Menu2() {
		fishnum[0] = 5;//수족관 크기
		fishnum[1] = 1;//전체 물고기수
		fishnum[2] = 2;
		stop = true;
	}


	public void showMenu() {
		System.out.println("0 : 수족관 상태보기");
		System.out.println("1 : 수족관 물고기 가격보기");
		System.out.println("2 : 수족관 사이즈 늘리기");
		System.out.println("3 : 물고기 분양하기");
		System.out.println("4 : 미니게임(난동진압)");
		System.out.println("5 : 수족관 광고하기");
	}

	public void AquariumState(Menu2 m2) {
		System.out.println("수족관 크기 : " + fishnum[0]);
		System.out.println("현재 수족관 물고기 수 : " + fishnum[1]);
		int a = 0;
		for (int i = 2; i < fishnum.length; i++) {
			if(fishnum[i] != 0) {
				System.out.println(fishtype[i - 2] + " : " + fishnum[i]);
				a++;
			}
		}
		if(a == 0) {
			System.out.println("수족관에 물고기가 없습니다.");
			System.out.println("낚시를 하여 물고기를 잡으세요!");
		}
	}

	public void ExpandAquarium(User user) {
		System.out.println("현재 수족관의 크기는 " + fishnum[0] + "입니다.");
		System.out.println("수족관을 1늘릴 때 마다 2000원의 비용이 발생합니다.");
		System.out.println("수족관을 공사하시겠습니까?[y/n]");
		String answer = sc.nextLine();
		if(answer.equals("y")) {
			System.out.println("늘릴 크기를 입력하세요.");
			int size = Integer.parseInt(sc.nextLine());
			if(user.money < (size * 2000)) {
				System.out.println("소지금이 부족합니다.");
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
		System.out.println("어떤 물고기를 분양하실건가요?");
		String fishname = sc.nextLine();
		for(int i = 2; i < fishnum.length; i++) {
			if(fishname.equals(fishtype[i - 2])) {
				if(fishnum[i] != 0) {
					System.out.println("현재" + fishnum[i] + "마리의 " + fishname + "가 있습니다.");
					b++;
					j = i - 2;
				}
			}
		}
		if(b == 0) {
			System.out.println("수족관에 " + fishname + "가 없습니다.");
		}
		else {
			System.out.println("판매하시겠습니까?[y/n]");
			String answer = sc.nextLine();
			if(answer.equals("y")) {
				System.out.println("몇 마리의 물고기를 파시겠습니까?");
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
				System.out.println(fishtype[i - 2] + " 물고기 가격(x" + fishnum[i] + ") : " + fishPrice[i - 2] + "x" + fishnum[i] + "(" + (fishPrice[i - 2] * fishnum[i]) + ") 원");
				fishmoney += (fishPrice[i - 2] * fishnum[i]);
			}
		}
		System.out.println("보유하고 있는 물고기 총 가격 : " + fishmoney + "원");
	}

	public void MiniGame(User user) {
		System.out.println("물고기 난동 진압!");
		System.out.println("물고기를 잡으세요.(사용자 B, 물고기 F)");
		System.out.println("상(w) 하(s) 좌(a) 우(d)");
		System.out.println("한 번 진압할 때마다 1000원의 비용이 발생합니다.");
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
			System.out.println("키를 입력하시오");
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
		String means[] = {"종이광고", "TV광고", "SNS광고", "전광판광고"};
		int adver[] = {1000, 5000, 3000, 10000};
		System.out.println("광고 수단을 선택하세요.");
		System.out.println("1. 종이광고 || 2. TV광고 || 3. SNS광고 || 4. 전광판광고");
		int choose = Integer.parseInt(sc.nextLine());
		System.out.println(means[choose - 1] + "의 비용은 " + adver[choose - 1] + "입니다.");
		System.out.println(means[choose - 1] + "을 이용해 광고를 하시겠습니까?[y/n]");
		String answer = sc.nextLine();
		if(answer.equals("y")) {
			if(user.money < adver[choose - 1]) {
				System.out.println("소지금이 부족합니다.");
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
				//쓰레기
				if(fishnum[13] > 0) {
					if(fishnum[1] > 0) {
						System.out.println("쓰레기 처리필요!");
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

				//난동
				if(disturbance == 0){
					if(fishnum[1] > 1) {
						System.out.println("물고기 난동 발생!");
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
