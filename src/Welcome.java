import java.util.Scanner;

public class Welcome {
	static final int NUM_BOOK =3;
	static final int NUM_ITEM =7;
//	static CartItem[] mCartItem = new CartItem[NUM_BOOK];
//	static int mCartCount = 0;
	static Cart mCart = new Cart();
	static User mUser;


	public static void main(String[] args) {
//		String[][] mBook = new String[NUM_BOOK][NUM_ITEM];
		Book[] mBookList = new Book[NUM_BOOK];
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("당신의 이름을 입력하세요: ");
		String name = input.next();

		System.out.print("연락처를 입력하세요: ");
		int phone = input.nextInt(); // 숫자만 입력 
		
		mUser = new User(name, phone);
	
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
			
			if (choice < 1 || choice > 9) {
				System.out.println("1부터 9까지의 숫자를 입력하세요");
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
//					menuCartAddItem(mBook);
					menuCartAddItem(mBookList);
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
				case 9:
					menuAdminLogin();
					break;
				} // switch 끝
			} // if-else 끝
		} // while 끝
	} // main 함수 끝 
	
	public static void menuIntro() {
		System.out.println(" 1. 고객 정보 확인하기 \t5. 장바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기 \t6. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t\t7. 장바구니의 항목 삭제하기");
		System.out.println(" 4. 영수증 표시하기 \t\t8. 종료");
		System.out.println(" 9. 관리자 로그인");
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
		// System.out.println("이름 " + name + "\n연락처: " + phone);
//		Person person = new Person(name, phone);
//		System.out.println("이름: " + person.getName() + "연락처: " + person.getPhone());
		System.out.println("이름 " + mUser.getName() + " 연락처 " + mUser.getPhone());
	}
	
	/**
	 * 설명: 2번 장바구니 상품 목록 보기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartItemList() {
//		System.out.println("2. 장바구니 상품 목록 보기: ");
//		System.out.println("*********************************************");
//		System.out.println("       도서ID \t|       수량\t|       합계");
//		for (int i = 0; i < mCartCount; i++) {
//			System.out.print("   " + mCartItem[i].getBookID() + "\t| ");
//			System.out.print("   " + mCartItem[i].getQuantity() + "\t| ");
//			System.out.print("   " + mCartItem[i].getTotalPrice());
//			System.out.println("   ");
//		}
//		System.out.println("*********************************************");
		if (mCart.mCartCount >= 0) {
			mCart.printCart();
		}
}
	
	/**
	 * 설명: 3번 장바구니 비우기
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartClear() { 
//		System.out.println("3. 장바구니 비우기: ");
		if (mCart.mCartCount == 0)
			System.out.println("장바구니에항목이 없습니다");
		else {
			System.out.println("장바구니의 모든 항목을 삭제하겠습니까? Y | N ");
			Scanner input = new Scanner (System.in);
			String str = input.nextLine();
			
			if (str.toUpperCase().equals("Y")) {
				System.out.println("장바구니의 모든 항목을 삭제했습니다");
				// mCart.mCartItem = new CartItemBook[NUM_B00K];
				mCart.deleteBook();
			}
		}
}

	/**
	 * 설명: 4번 영수증 표시하기 
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
	public static void menuCartAddItem(Book[] booklist) { 
		// System.out.println("5. 장바구니에 항목 수량 추가하기: ");
		BookList(booklist);
//		for (int i =0; i< NUM_BOOK; i++) {
//			for (int j = 0; j < NUM_ITEM; j++)
//				System.out.print(book[i][j] + " | ");
//			System.out.println("");
//		}
		mCart.printBookList(booklist);
		boolean quit = false;
		
		while (!quit) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요");
			
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			boolean flag = false;
			int numId = -1;
			
			for (int i = 0; i < NUM_BOOK; i++) {
				if (str.equals(booklist[i].getBookId())) {
					numId = i;
					flag = true;
					break;
				}
			}
			
			if (flag) {
				System.out.println("장바구니에 추가하겠습니까? Y | N ");
				str = input.nextLine();
				
				if (str.toUpperCase().equals("Y")) {
					System.out.println(booklist[numId].getBookId() + " 도서가 장바구니에 추가되었습니다.");
					// 장바구니에 넣기
					if (!isCartInBook(booklist[numId].getBookId())) {
//						mCartItem[mCartCount++] = new CartItem(book[numId]);
						mCart.insertBook(booklist[numId]);
				}
				quit = true;
			} else
				System.out.println("다시 입력해 주세요");
			}
		} // while문 끝 
}
	
	public static boolean isCartInBook(String bookId) {
//		boolean flag = false;
//		for (int i = 0; i < mCartCount; i++) {
//			if (bookId.equals(mCartItem[i].getBookID())) {
//				mCartItem[i].setQuantity(mCartItem[i].getQuantity()+1);
//				flag = true;
//			}
//		}
//		return flag;
		return mCart.isCartInBook(bookId);
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
//		System.out.println("7. 장바구니의 항목 삭제하기: ");
		if (mCart.mCartCount == 0)
			System.out.println("장바구니에 항목이 없습니다");
		else {
			menuCartItemList();
			boolean quit = false;
			while (!quit) {
				System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numId = -1;
				for (int i = 0; i < mCart.mCartCount; i++) {
					if (str.equals(mCart.mCartItem[i].getBookID())) {
						numId = i;
						flag = true;
						break;
					}
				}
				
				if (flag) {
					System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N ");
					str = input.nextLine();
					if (str.toUpperCase().equals("y")) {
						System.out.println(mCart.mCartItem[numId].getBookID() + "장바구니에서 도서가 삭제되었습니다.");
						// 배열 이동
						/* CartItemBook[] cartItem = new CartItemBook[NUM_B00K);
						int num = 0;
						for (int i = 0; i < mCartCount; i++)
						if (numId! = i) cartItem[num++] = mCart.mCartItem(i);
						mCartCount = num;
						mCart.mCartCount = num;
						mCart.mCartItem = cartItem;
						*/
						mCart.removeCart(numId);
						}
						quit = true;
					}
					else System.out.println("다시 입력해 주세요");
				}
			}
		}

	
	/**
	 * 설명: 8번 종료
	 * 매개변수: 
	 * 반환값: 
	 */
	public static void menuCartExit() {
		System.out.println("8. 종료");
 }
	
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");
		
		Scanner input = new Scanner(System.in);
		System.out.print("아이디: ");
		String adminId = input.next();
		
		System.out.print("비밀번호: ");
		String adminPW = input.next();
		
		Admin admin = new Admin(mUser.getName(), mUser.getPhone());
		if (adminId.equals(admin.getId()) && adminPW.equals(admin.getPassword())) {
			System.out.println("이름: " + admin.getName() + "  연락처" + admin.getPhone());
			System.out.println("아이디: " + admin.getId() + "  비밀번호" + admin.getPassword());
		} else
			System.out.println("관리자 정보가 일치하지 않습니다.");


	}
	
	public static void BookList(Book[] booklist) {
		booklist[0] = new Book("ISEN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000);
		booklist[0].setAuthor("송미영");
		booklist[0].setDescription("단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍");
		booklist[0].setCategory("IT전문서");
		booklist[0].setReleaseDate ("2018/10/08*);");
		
		booklist[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000);
		booklist[1].setAuthor("우재남");
		booklist[1].setDescription("실습 단계별 명쾌한 멘토링!");
		booklist[1].setCategory("IT 전문서");
		booklist[1].setReleaseDate ("2022/01/22");
		
		booklist[2] = new Book("ISEN1236", "스크래치", 22000);
		booklist[2].setAuthor("고광일");
		booklist[2].setDescription("컴퓨팅 사고력을 키우는 블록 코딩");
		booklist[2].setCategory("컴퓨터입문");
		booklist[2].setReleaseDate("2019/06/10");
	}
	
	public static void BookList(String[][] book) {
		
		book[0][0] = "ISBN1234";
		book[0][1] = "쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2] = "27000";
		book[0][3] = "송미영";
		book[0][4] = "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
		book[0][5] = "IT전문서";
		book[0][6] = "2018/10/08";
		
		book[1][0] = "ISBN1235";
		book[1][1] = "안드로이드 프로그래밍";
		book[1][2] = "33000";
		book[1][3] = "우재남";
		book[1][4] = "실습 단계별 명쾌한 멘토링!";
		book[1][5] = "IT전문서";
		book[1][6] = "2022/01/22";
		
		book[2][0] = "ISBN1236";		
		book[2][1] = "스크래치";
		book[2][2] = "22000";
		book[2][3] = "고광일";
		book[2][4] = "컴퓨팅 사고력을 키우는 블록 코딩";
		book[2][5] = "컴퓨터입문";
		book[2][6] = "2019/06/10";
	}

} // Welcome 클래스 끝
 