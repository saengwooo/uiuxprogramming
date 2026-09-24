import java.time.LocalDate;
import java.time.Period;

// 개인정보 클래스 상속 및 Printable 인터페이스 구현
public class StudentInfoOutput extends MSW0686 implements Printable {

    public StudentInfoOutput() {
        super();
    }

    public StudentInfoOutput(String name, String email, String birthDateStr) {
        super(name, email, birthDateStr);
    }

    @Override
    public void printNameAndEmail() {
        String domain = "";
        // 이메일에서 @ 뒷부분(도메인) 추출
        if (email != null && email.contains("@")) {
            domain = email.substring(email.indexOf("@") + 1);
        }
        System.out.println("개발자의 이름은 " + name + "입니다.");
        System.out.println("개발자는 " + domain + " 메일을 사용합니다.");
    }

    @Override
    public void printAge() {
        LocalDate today = LocalDate.now();
        // 오늘 날짜와 생년월일을 비교하여 만 나이 계산
        int age = Period.between(this.birthDate, today).getYears();
        
        System.out.println("나이는 만 " + age + "세이며, 태어난 요일은 " + birthDayOfWeek + "입니다.");
    }
}