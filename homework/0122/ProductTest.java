package hwjava05_광주_3반_김수혁;

import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgr pm = ProductMgr.getInstance();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. 상품저장");
			System.out.println("2. 상품출력");
			System.out.println("3. 상품검색");
			System.out.println("4. 상품삭제");
			System.out.println("5. 상품검색(가격)");
			System.out.println("0. 종료");
			int sel = sc.nextInt();
			if(sel == 1) {
				System.out.print("추가할 상품 번호 : ");
				int id = sc.nextInt();
				System.out.print("추가할 상품 이름 : ");
				String name = sc.next();
				System.out.print("추가할 상품 가격 : ");
				int price = sc.nextInt();
				System.out.print("추가할 상품 수량 : ");
				int cnt = sc.nextInt();
				Product tmp = new Product(id,name,price,cnt);
				pm.add(tmp);
				tmp = null;
			}
			else if(sel == 2) {
				for(Product pr : pm.list()) {
					System.out.println(pr.toString());
				}
				
			}
			else if(sel == 3) {
				System.out.print("번호를 입력해주세요 : ");
				int num = sc.nextInt();
				System.out.println(pm.list(num).toString());
			}
			else if(sel == 4) {
				System.out.println("삭제할 번호를 입력해주세요 : ");
				int num = sc.nextInt();
				pm.delete(num);
			}
			else if(sel == 5) {
				System.out.println("검색할 가격(이하)를 입력해주세요 : ");
				int price = sc.nextInt();
				for(Product p : pm.priceList(price)) {
					System.out.println(p.toString());
				}
			}
			else if(sel == 0) {
				break;
			}
			
		}
	}

}
