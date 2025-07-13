import javax.swing.*;

/**
 * 단어장 애플리케이션의 메인 클래스
 * 프로그램의 시작점이며, UI 테마를 설정하고 메인 애플리케이션을 실행합니다.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                // 시스템 Look and Feel 설정 (운영체제에 맞는 UI 테마 적용)
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 단어장 애플리케이션 실행
            new VocabularyApp();
        });
    }
}