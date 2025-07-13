import java.io.*;
import java.util.*;

/**
 * 단어장 관리 클래스
 * 단어의 추가, 수정, 삭제, 파일 저장/로드, 퀴즈 기능을 제공합니다.
 * 제네릭을 사용하여 Word 클래스를 확장한 클래스도 사용할 수 있습니다.
 */
public class VocabularyManager<T extends Word> {
    private List<T> words;          // 단어 목록
    private String filename;        // 저장 파일명
    private Set<T> usedWords;       // 퀴즈에서 사용된 단어들을 추적

    /**
     * VocabularyManager 생성자
     * @param filename 단어장을 저장할 파일명
     */
    public VocabularyManager(String filename) {
        this.filename = filename;
        this.words = new ArrayList<>();
        this.usedWords = new HashSet<>();
        loadFromFile(); // 파일에서 기존 단어장 로드
    }

    /**
     * 단어를 추가합니다.
     * 이미 존재하는 단어는 추가하지 않습니다.
     * @param word 추가할 단어
     */
    public void addWord(T word) {
        if (!words.contains(word)) {
            words.add(word);
            saveToFile();
        }
    }

    /**
     * 기존 단어를 수정합니다.
     * @param originalEnglish 수정할 단어의 원래 영어 단어
     * @param newEnglish 새로운 영어 단어
     * @param newKorean 새로운 한국어 뜻
     * @return 수정 성공 여부
     */
    public boolean updateWord(String originalEnglish, String newEnglish, String newKorean) {
        for (T word : words) {
            if (word.getEnglish().equals(originalEnglish)) {
                word.setEnglish(newEnglish);
                word.setKorean(newKorean);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    /**
     * 단어를 삭제합니다.
     * @param english 삭제할 단어의 영어 단어
     * @return 삭제 성공 여부
     */
    public boolean removeWord(String english) {
        Iterator<T> iterator = words.iterator();
        while (iterator.hasNext()) {
            T word = iterator.next();
            if (word.getEnglish().equals(english)) {
                iterator.remove();
                saveToFile();
                return true;
            }
        }
        return false;
    }

    /**
     * 모든 단어 목록을 반환합니다.
     * @return 단어 목록의 복사본
     */
    public List<T> getAllWords() {
        return new ArrayList<>(words);
    }

    /**
     * 랜덤 단어를 가져옵니다.
     * 아직 퀴즈에서 사용되지 않은 단어 중에서 랜덤으로 선택합니다.
     * @return 랜덤 단어 (모든 단어를 사용했거나 단어장이 비어있으면 null)
     */
    public T getRandomWord() {
        if (words.isEmpty()) return null;

        // 사용되지 않은 단어들 찾기
        List<T> unusedWords = new ArrayList<>();
        for (T word : words) {
            if (!usedWords.contains(word)) {
                unusedWords.add(word);
            }
        }

        // 모든 단어를 사용했다면 null 반환 (퀴즈 완료)
        if (unusedWords.isEmpty()) {
            return null;
        }

        // 랜덤으로 선택하여 사용된 단어 목록에 추가
        Random random = new Random();
        T selectedWord = unusedWords.get(random.nextInt(unusedWords.size()));
        usedWords.add(selectedWord);
        return selectedWord;
    }

    /**
     * 퀴즈를 초기화합니다.
     * 사용된 단어 목록을 클리어하여 모든 단어를 다시 사용할 수 있게 합니다.
     */
    public void resetQuiz() {
        usedWords.clear();
    }

    /**
     * 퀴즈 완료 여부를 확인합니다.
     * @return 모든 단어를 사용했으면 true, 아니면 false
     */
    public boolean isQuizCompleted() {
        return !words.isEmpty() && usedWords.size() >= words.size();
    }

    /**
     * 퀴즈 진행률을 문자열로 반환합니다.
     * @return "사용된 단어 수/전체 단어 수" 형태의 문자열
     */
    public String getQuizProgress() {
        if (words.isEmpty()) return "0/0";
        return usedWords.size() + "/" + words.size();
    }

    /**
     * 단어장을 파일에 저장합니다.
     */
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(words);
        } catch (IOException e) {
            System.err.println("파일 저장 오류: " + e.getMessage());
        }
    }

    /**
     * 파일에서 단어장을 불러옵니다.
     */
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            words = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 파일이 없으면 새로운 단어장 생성
            words = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("파일 로드 오류: " + e.getMessage());
            words = new ArrayList<>();
        }
    }

    /**
     * 단어장을 완전히 초기화합니다.
     * 모든 단어를 삭제하고 퀴즈 진행 상태도 초기화합니다.
     */
    public void resetVocabulary() {
        words.clear();
        usedWords.clear();
        saveToFile();
    }
}