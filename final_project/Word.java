import java.io.Serializable;

/**
 * 단어 클래스
 * 영어 단어와 한국어 뜻, 정답/오답 카운트를 관리하는 클래스입니다.
 * Serializable을 구현하여 파일 저장이 가능합니다.
 */
public class Word implements Serializable {
    private static final long serialVersionUID = 1L;

    private String english;      // 영어 단어
    private String korean;       // 한국어 뜻
    private int correctCount;    // 정답 횟수
    private int incorrectCount;  // 오답 횟수

    /**
     * Word 생성자
     * @param english 영어 단어
     * @param korean 한국어 뜻
     */
    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
        this.correctCount = 0;
        this.incorrectCount = 0;
    }

    // Getters and Setters
    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    /**
     * 정답 횟수를 1 증가시킵니다.
     */
    public void addCorrectCount() {
        this.correctCount++;
    }

    public int getIncorrectCount() {
        return incorrectCount;
    }

    /**
     * 오답 횟수를 1 증가시킵니다.
     */
    public void addIncorrectCount() {
        this.incorrectCount++;
    }

    /**
     * 정답률을 계산합니다.
     * @return 정답률 (0.0 ~ 100.0)
     */
    public double getAccuracy() {
        int total = correctCount + incorrectCount;
        return total == 0 ? 0.0 : (double) correctCount / total * 100;
    }

    @Override
    public String toString() {
        return english + " - " + korean;
    }

    /**
     * 영어 단어를 기준으로 같은 단어인지 비교합니다.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word word = (Word) obj;
        return english.equals(word.english);
    }

    @Override
    public int hashCode() {
        return english.hashCode();
    }
}