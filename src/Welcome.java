import java.util.Scanner;

public class Welcome {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력하세요: ");
		String name = input.next();

		System.out.print("연락처를 입력하세요: ");
		int phone = input.nextInt(); // 숫자만 입력 
	
		// System.out.println("Welcome to Shopping Mall");
		// System.out.println("Welcome to Book Market!");
		
		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to BookMarket!!";
		
		boolean quit = false;
		
		while(!quit) {
			
			System.out.println("*********************************************");
			System.out.println("\t"+greeting);
			System.out.println("\t"+tagline);
			System.out.println("*********************************************");
			
			/*
			System.out.println("1. 고객 정보 확인하기 \t5. 장바구니에 항목 추가하기");
			System.out.println("2. 장바구니 상품 목록 보기 \t6. 장바구니의 항목 수량 줄이기");
			System.out.println("3. 장바구니 비우기 \t\t7. 장바구니의 항목 삭제하기");
			System.out.println("4. 영수증 표시하기 \t\t8. 종료");
			System.out.println("*********************************************"); */
			
			menuIntro();
			
			System.out.println("메뉴 번호를 선택해주세요.");
			int choice = input.nextInt(); // 숫자만 입력
			
			if (choice < 1 || choice > 8) {
				System.out.println("1부터 8까지의 숫자를 입력하세요");
			} else {
				switch(choice) {
				case 1:
//					System.out.println("1. 현재 고객 정보: ");
//					System.out.println("이름 " + name + "\n연락처: " + phone);
					menuGuestInfo(name, phone);
					break;
				case 2:
					menuCartItemList();
					break;
				case 3:
					menuCartClear();
					break;
				case 4:
					menuCartBill();
					break;
				case 5:
					menuCartAddItem();
					break;
				case 6:
					menuCartRemoveItemCount();
					break;
				case 7:
					menuCartRemoveItem();
					break;
				case 8:
					menuCartExit();
					quit = true;
					break;
				} // switch 끝
			} // if-else 끝
		} // while 끝
	} // main 함수 끝 
	
	public static void menuIntro() {
		System.out.println("1. 고객 정보 확인하기 \t5. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기 \t6. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기 \t\t7. 장바구니의 항목 삭제하기");
		System.out.println("4. 영수증 표시하기 \t\t8. 종료");
		System.out.println("*********************************************");
	}
	
	
	/**
	 * 설명: 1번 고객 정보 출력 
	 * 매개변수: 
	 * String name
	 * int phone
	 */
	public static void menuGuestInfo(String name, int phone) {
		System.out.println("1. 현재 고객 정보: ");
		System.out.println("이름 " + name + "\n연락처: " + phone);
	}
	
	/**
	 * 설명: 2번 장바구니 상품 목록 보기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartItemList() {
		System.out.println("2. 장바구니 상품 목록 보기: ");
}
	
	/**
	 * 설명: 3번 장바구니 비우기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartClear() { 
		System.out.println("3. 장바구니 비우기: ");
}

	/**
	 * 설명: 4번 영수증 표시하
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartBill() { 
		System.out.println("4. 영수증 표시하기: ");
}
	
	/**
	 * 설명: 5번 장바구니에 항목 수량 추가하기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartAddItem() { 
		System.out.println("5. 장바구니에 항목 수량 추가하기: ");
}
	
	/**
	 * 설명: 6번 장바구니의 항목 수량 줄이기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartRemoveItemCount() { 
		System.out.println("6. 장바구니의 항목 수량 줄이기: ");
}
	
	/**
	 * 설명: 7번 장바구니의 항목 삭제하기 
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartRemoveItem() { 
		System.out.println("7. 장바구니의 항목 삭제하기: ");
}
	
	/**
	 * 설명: 8번 종료
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartExit() {
		System.out.println("8. 종료");
 }

} // Welcome 클래스 끝
 