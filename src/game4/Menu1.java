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
			System.out.println("���׹̳ʰ� �����մϴ�.");
			System.out.println("�������� ���׹̳ʸ� �����ϰų� ���׹̳ʰ� ȸ���Ǳ⸦ ��ٸ��ʽÿ�.");
		}
		else {
			user.steminer = user.steminer - 2;
			System.out.println("> ���ô븦 �����ϴ�.");
			System.out.println("> ���� ���׹̳� : " + user.steminer);
			System.out.println("> ����⸦ ��ٸ��ϴ�.");
			System.out.println("> ���ô뿡 ���� �ɷȽ��ϴ�.");
			System.out.println("> ����ø��� ��...");
			System.out.print("> ");
			m1.success(m1, m2);

		}

	}

	public void success(Menu1 m1, Menu2 m2) {
		if(result == 0) {
			System.out.println("�ƽ��Ե� �ƹ��͵� ���� ���߳׿�. �ٽ� �����غ�����.");
		}
		else {
			System.out.print(m2.fishtype[fnum]);
			System.out.println("�� ���ҽ��ϴ�.");
			if(m2.fishnum[0] == m2.fishnum[1]) {
				System.out.println("�������� ���̻� ����⸦ ���� �ڸ��� �����ϴ�.");
			}
			else {
				if(fnum + 2 != 13) {
					m2.fishnum[1]++;
					m2.fishnum[fnum + 2]++;
				}
				else {
					System.out.println("�����⸦ ó�����ּ���.");
					m2.fishnum[fnum + 2]++;
				}
				
			}
		}
	}
}
