import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class MSW0686 {
    protected String name;
    protected String email;
    protected LocalDate birthDate;
    protected String birthDayOfWeek;

    // 기본 생성자
    public MSW0686() {
    }

    // 전체 필드를 받는 생성자 (요일은 자동 계산)
    public MSW0686(String name, String email, String birthDateStr) {
        this.name = name;
        this.email = email;
        // 문자열("YYYY-MM-DD")을 LocalDate로 변환
        this.birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        // 생년월일로부터 태어난 요일 자동 계산
        DayOfWeek dayOfWeek = this.birthDate.getDayOfWeek();
        this.birthDayOfWeek = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
    }
}

