package game4;

public class Menu1 {

	public Menu1() {

	}

	boolean increase = true;
	int result = (int)(Math.random() * 2);//0,1
	int fnum = (int)((Math.random()) * 12);//0~11

	public void activity(User user, Menu2 m2) {
		Menu1 m1 = new Menu1();
		if(user.steminer < 2) {
			System.out.println("스테미너가 부족합니다.");
			System.out.println("상점에서 스테미너를 구입하거나 스테미너가 회복되기를 기다리십시오.");
		}
		else {
			user.steminer = user.steminer - 2;
			System.out.println("> 낚시대를 던집니다.");
			System.out.println("> 남은 스테미나 : " + user.steminer);
			System.out.println("> 물고기를 기다립니다.");
			System.out.println("> 낚시대에 무언가 걸렸습니다.");
			System.out.println("> 끌어올리는 중...");
			System.out.print("> ");
			m1.success(m1, m2);

		}

	}

	public void success(Menu1 m1, Menu2 m2) {
		if(result == 0) {
			System.out.println("아쉽게도 아무것도 낚지 못했네요. 다시 도전해보세요.");
		}
		else {
			System.out.print(m2.fishtype[fnum]);
			System.out.println("를 낚았습니다.");
			if(m2.fishnum[0] == m2.fishnum[1]) {
				System.out.println("수족관에 더이상 물고기를 넣을 자리가 없습니다.");
			}
			else {
				if(fnum + 2 != 13) {
					m2.fishnum[1]++;
					m2.fishnum[fnum + 2]++;
				}
				else {
					System.out.println("쓰레기를 처리해주세요.");
					m2.fishnum[fnum + 2]++;
				}
				
			}
		}
	}
}
