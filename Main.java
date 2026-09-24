import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 인스턴스 생성 (본인의 정보로 수정하여 초기화할 것)
        StudentInfoOutput student = new StudentInfoOutput("문상우", "11600686@iscu.ac.kr", "1989-08-26"); 
        
        // 조회 이력을 저장할 ArrayList 생성
        ArrayList<String> history = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n===== 개인정보 조회 시스템 =====");
            System.out.println("1. 이름/이메일 조회");
            System.out.println("2. 나이 조회");
            System.out.println("3. 조회 이력 보기");
            System.out.println("0. 종료");
            System.out.print("메뉴를 선택하세요: ");
            
            try {
                int menu = sc.nextInt();
                sc.nextLine(); // 엔터 버퍼 비우기
                
                if (menu == 1) {
                    student.printNameAndEmail();
                    history.add("이름/이메일 조회"); // 이력 저장
                } else if (menu == 2) {
                    student.printAge();
                    history.add("나이 조회"); // 이력 저장
                } else if (menu == 3) {
                    System.out.println("\n=== 조회 이력 ===");
                    if (history.isEmpty()) {
                        System.out.println("조회 이력이 없습니다.");
                    } else {
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println((i + 1) + ". " + history.get(i));
                        }
                    }
                } else if (menu == 0) {
                    System.out.println("\n=== 전체 조회 이력 ===");
                    if (history.isEmpty()) {
                        System.out.println("조회 이력이 없습니다.");
                    } else {
                        for (int i = 0; i < history.size(); i++) {
                            System.out.println((i + 1) + ". " + history.get(i));
                        }
                    }
                    System.out.println("프로그램을 종료합니다.");
                    break; // 무한루프 탈출 및 프로그램 종료
                } else {
                    // 0, 1, 2, 3 이외의 숫자 입력 시
                    System.out.println("잘못된 입력입니다. 0~3 사이의 숫자를 입력해주세요.");
                }
            } catch (InputMismatchException e) {
                // 숫자가 아닌 값(문자 등) 입력 시 예외 처리
                System.out.println("숫자가 아닌 값이 입력되었습니다. 다시 입력해주세요.");
                sc.nextLine(); // 잘못 입력된 값의 버퍼를 비워서 무한 반복 방지
            }
        }
        sc.close();
 }
}