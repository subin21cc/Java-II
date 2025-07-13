import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 단어장 애플리케이션의 메인 GUI 클래스
 * 단어 관리와 퀴즈 기능을 제공하는 탭 형태의 인터페이스를 구현합니다.
 */
public class VocabularyApp extends JFrame {
    private VocabularyManager<Word> vocabularyManager;
    private JTabbedPane tabbedPane;

    // 단어 관리 탭 컴포넌트
    private JTextField englishField, koreanField;
    private JTable wordTable;
    private DefaultTableModel tableModel;

    // 퀴즈 탭 컴포넌트
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitButton, nextButton, resetQuizButton;
    private JLabel resultLabel;
    private JLabel progressLabel;
    private Word currentQuizWord;

    /**
     * VocabularyApp 생성자
     * 단어장 관리자를 초기화하고 GUI를 설정합니다.
     */
    public VocabularyApp() {
        vocabularyManager = new VocabularyManager<>("vocabulary.dat");
        initializeGUI();
        refreshWordTable();
    }

    /**
     * GUI를 초기화합니다.
     * 메인 프레임과 탭 패널을 설정합니다.
     */
    private void initializeGUI() {
        setTitle("나만의 단어장");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // 단어 관리 탭 추가
        tabbedPane.addTab("단어 관리", createWordManagementPanel());

        // 랜덤 퀴즈 탭 추가
        tabbedPane.addTab("랜덤 퀴즈", createQuizPanel());

        add(tabbedPane);
        setVisible(true);
    }

    /**
     * 단어 관리 탭 패널을 생성합니다.
     * @return 단어 관리 패널
     */
    private JPanel createWordManagementPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 입력 패널 생성
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // 영단어 입력 필드
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("영단어:"), gbc);
        gbc.gridx = 1;
        englishField = new JTextField(15);
        inputPanel.add(englishField, gbc);

        // 한국어 뜻 입력 필드
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("한국어 뜻:"), gbc);
        gbc.gridx = 1;
        koreanField = new JTextField(15);
        inputPanel.add(koreanField, gbc);

        // 버튼 패널 생성
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("추가");
        JButton updateButton = new JButton("수정");
        JButton deleteButton = new JButton("삭제");
        JButton clearButton = new JButton("초기화");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        inputPanel.add(buttonPanel, gbc);

        panel.add(inputPanel, BorderLayout.NORTH);

        // 단어 목록 테이블 생성
        String[] columns = {"영단어", "한국어 뜻", "정답 수", "오답 수", "정답률(%)"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 테이블 셀 편집 불가
            }
        };
        wordTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(wordTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // 이벤트 리스너 설정
        addButton.addActionListener(e -> addWord());
        updateButton.addActionListener(e -> updateWord());
        deleteButton.addActionListener(e -> deleteWord());
        clearButton.addActionListener(e -> clearVocabulary());

        // 테이블 행 선택 시 입력 필드에 데이터 표시
        wordTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = wordTable.getSelectedRow();
                if (selectedRow != -1) {
                    englishField.setText((String) tableModel.getValueAt(selectedRow, 0));
                    koreanField.setText((String) tableModel.getValueAt(selectedRow, 1));
                }
            }
        });

        return panel;
    }

    /**
     * 퀴즈 탭 패널을 생성합니다.
     * @return 퀴즈 패널
     */
    private JPanel createQuizPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 퀴즈 영역 생성
        JPanel quizPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // 진행률 표시 라벨
        gbc.gridx = 0; gbc.gridy = 0;
        progressLabel = new JLabel("진행률: 0/0");
        progressLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        quizPanel.add(progressLabel, gbc);

        // 문제 라벨
        gbc.gridx = 0; gbc.gridy = 1;
        quizPanel.add(new JLabel("문제:"), gbc);

        // 문제 내용 라벨
        gbc.gridy = 2;
        questionLabel = new JLabel("문제를 시작하려면 '다음 문제' 버튼을 클릭하세요.");
        questionLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        quizPanel.add(questionLabel, gbc);

        // 답 입력 라벨
        gbc.gridy = 3;
        quizPanel.add(new JLabel("답:"), gbc);

        // 답 입력 필드
        gbc.gridy = 4;
        answerField = new JTextField(20);
        quizPanel.add(answerField, gbc);

        // 버튼 패널
        gbc.gridy = 5;
        JPanel buttonPanel = new JPanel(new FlowLayout());
        submitButton = new JButton("정답 확인");
        nextButton = new JButton("다음 문제");
        resetQuizButton = new JButton("퀴즈 초기화");
        buttonPanel.add(submitButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(resetQuizButton);
        quizPanel.add(buttonPanel, gbc);

        // 결과 표시 라벨
        gbc.gridy = 6;
        resultLabel = new JLabel(" ");
        resultLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        quizPanel.add(resultLabel, gbc);

        panel.add(quizPanel, BorderLayout.CENTER);

        // 이벤트 리스너 설정
        submitButton.addActionListener(e -> checkAnswer());
        nextButton.addActionListener(e -> nextQuestion());
        resetQuizButton.addActionListener(e -> resetQuiz());

        // 답 입력 필드에서 Enter 키 입력 시 정답 확인
        answerField.addActionListener(e -> checkAnswer());

        return panel;
    }

    /**
     * 새로운 단어를 추가합니다.
     */
    private void addWord() {
        String english = englishField.getText().trim();
        String korean = koreanField.getText().trim();

        if (english.isEmpty() || korean.isEmpty()) {
            JOptionPane.showMessageDialog(this, "영단어와 한국어 뜻을 모두 입력하세요.");
            return;
        }

        Word word = new Word(english, korean);
        vocabularyManager.addWord(word);
        refreshWordTable();
        updateQuizProgress();

        // 입력 필드 초기화
        englishField.setText("");
        koreanField.setText("");

        JOptionPane.showMessageDialog(this, "단어가 추가되었습니다.");
    }

    /**
     * 선택된 단어를 수정합니다.
     */
    private void updateWord() {
        int selectedRow = wordTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "수정할 단어를 선택하세요.");
            return;
        }

        String originalEnglish = (String) tableModel.getValueAt(selectedRow, 0);
        String newEnglish = englishField.getText().trim();
        String newKorean = koreanField.getText().trim();

        if (newEnglish.isEmpty() || newKorean.isEmpty()) {
            JOptionPane.showMessageDialog(this, "영단어와 한국어 뜻을 모두 입력하세요.");
            return;
        }

        if (vocabularyManager.updateWord(originalEnglish, newEnglish, newKorean)) {
            refreshWordTable();
            englishField.setText("");
            koreanField.setText("");
            JOptionPane.showMessageDialog(this, "단어가 수정되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "단어 수정에 실패했습니다.");
        }
    }

    /**
     * 선택된 단어를 삭제합니다.
     */
    private void deleteWord() {
        int selectedRow = wordTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "삭제할 단어를 선택하세요.");
            return;
        }

        String english = (String) tableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (vocabularyManager.removeWord(english)) {
                refreshWordTable();
                updateQuizProgress();
                englishField.setText("");
                koreanField.setText("");
                JOptionPane.showMessageDialog(this, "단어가 삭제되었습니다.");
            } else {
                JOptionPane.showMessageDialog(this, "단어 삭제에 실패했습니다.");
            }
        }
    }

    /**
     * 단어장을 완전히 초기화합니다.
     */
    private void clearVocabulary() {
        int confirm = JOptionPane.showConfirmDialog(this, "모든 단어를 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            vocabularyManager.resetVocabulary();
            refreshWordTable();
            updateQuizProgress();
            resetQuizUI();
            JOptionPane.showMessageDialog(this, "단어장이 초기화되었습니다.");
        }
    }

    /**
     * 다음 퀴즈 문제를 가져옵니다.
     */
    private void nextQuestion() {
        Word word = vocabularyManager.getRandomWord();
        if (word != null) {
            currentQuizWord = word;
            questionLabel.setText("다음 단어의 뜻은? " + word.getEnglish());
            answerField.setText("");
            answerField.setEnabled(true);
            submitButton.setEnabled(true);
            resultLabel.setText(" ");
            updateQuizProgress();
        } else {
            // 퀴즈 완료 처리
            if (vocabularyManager.isQuizCompleted()) {
                questionLabel.setText("🎉 퀴즈가 완료되었습니다! 🎉");
                answerField.setText("");
                answerField.setEnabled(false);
                submitButton.setEnabled(false);
                resultLabel.setText("모든 단어를 완료했습니다!");
                resultLabel.setForeground(Color.BLUE);
                updateQuizProgress();
            } else {
                questionLabel.setText("단어장이 비어있습니다!");
                answerField.setText("");
                answerField.setEnabled(false);
                submitButton.setEnabled(false);
                resultLabel.setText(" ");
                updateQuizProgress();
            }
        }
    }

    /**
     * 사용자의 답을 확인합니다.
     */
    private void checkAnswer() {
        if (currentQuizWord == null) {
            JOptionPane.showMessageDialog(this, "먼저 문제를 시작하세요.");
            return;
        }

        String userAnswer = answerField.getText().trim();
        if (userAnswer.equalsIgnoreCase(currentQuizWord.getKorean())) {
            // 정답 처리
            resultLabel.setText("정답입니다! ✓");
            resultLabel.setForeground(Color.GREEN);
            currentQuizWord.addCorrectCount();
        } else {
            // 오답 처리
            resultLabel.setText("오답입니다. 정답: " + currentQuizWord.getKorean() + " ✗");
            resultLabel.setForeground(Color.RED);
            currentQuizWord.addIncorrectCount();
        }

        // 테이블 업데이트 (정답/오답 수 반영)
        refreshWordTable();
    }

    /**
     * 퀴즈를 초기화합니다.
     */
    private void resetQuiz() {
        int confirm = JOptionPane.showConfirmDialog(this, "퀴즈를 처음부터 다시 시작하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            vocabularyManager.resetQuiz();
            resetQuizUI();
            updateQuizProgress();
            JOptionPane.showMessageDialog(this, "퀴즈가 초기화되었습니다.");
        }
    }

    /**
     * 퀴즈 UI를 초기 상태로 재설정합니다.
     */
    private void resetQuizUI() {
        questionLabel.setText("문제를 시작하려면 '다음 문제' 버튼을 클릭하세요.");
        answerField.setText("");
        answerField.setEnabled(true);
        submitButton.setEnabled(true);
        resultLabel.setText(" ");
        currentQuizWord = null;
    }

    /**
     * 퀴즈 진행률을 업데이트합니다.
     */
    private void updateQuizProgress() {
        progressLabel.setText("진행률: " + vocabularyManager.getQuizProgress());
    }

    /**
     * 단어 테이블을 새로고침합니다.
     * 모든 단어의 정보를 다시 로드하여 테이블에 표시합니다.
     */
    private void refreshWordTable() {
        tableModel.setRowCount(0);
        List<Word> words = vocabularyManager.getAllWords();
        for (Word word : words) {
            Object[] row = {
                    word.getEnglish(),
                    word.getKorean(),
                    word.getCorrectCount(),
                    word.getIncorrectCount(),
                    String.format("%.1f", word.getAccuracy())
            };
            tableModel.addRow(row);
        }
    }
}