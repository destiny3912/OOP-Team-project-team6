package Program;
import java.util.ArrayList;
import java.util.Scanner;

public class updateFood {
	public static void main(String[] args) {

		View pv = new View();
		stockReadyMadeService ps = new stockReadyMadeService();
		ArrayList<stockReadymade> pList = ps.getStockList();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter food product ");
		String name = keyboard.nextLine();
		
		stockReadymade prod = ps.searchProd(name);
		int updateNum = pv.updateNum(); 
		if(prod != null) {
			if(updateNum != -1) {
				//�������� ���� ���� �ԷµǾ��� ���
				//���� Ŭ������ ���� ���� �޼ҵ� ���
				boolean result = ps.updateProd(name, updateNum);
				if(result) {
					System.out.println("Update success ");
				}
				else {
					//���� ���� �޽��� ���
					System.out.println("Update failed ");
				}
			}
			else {
				//���Ͱ� �ԷµǾ��� ���. �޽��� ���
				System.out.println("wrong ");
			}
		}
		else {
			System.out.println("none data");
		}
	}
}

