package Program;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
	private Scanner scan = new Scanner(System.in);
	public int inputNum() {
		//scanner�� ���� 
		//��ȣ �ڿ� ���ڿ��� �Է¹��� �� �Է��� �ȵǴ� ����
		String str = scan.nextLine();//�Է��� ���ڿ���..
		int num = -1;

		//���ڸ� �Է����� �ʰ� ���͸� ���� ���� ���ܻ��� ����.
		if(!str.equals("")) {
			num = Integer.parseInt(str);
		}

		return num;
	}//���� �Է� �޼ҵ� ��
	
	public void printProduct(ArrayList<stockReadymade> pList, int c) {
	int cnt = 0;//ī�װ��� ��� �� ��ǰ ���� ī��Ʈ

		for(stockReadymade p : pList) {
			switch(c) {
				case 0:
					System.out.println(p);
					break;
			}//switch ��
		}
	}
	public void searchResult(stockReadymade p) {
		//���޹��� ��ǰ �ν��Ͻ� ���
		System.out.println("Search result");
		System.out.println(p);
	}
	
	public int updateNum() {
		System.out.print("update nember: ");
		
		int uNum = inputNum();
		
		return uNum;
	}

}
