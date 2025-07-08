package sec01;

public class Student {
    
    private String id;
    private String name;
    private int korean;
    private int english;
    
    public Student( String id, String name ) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getKorean() {
        return korean;
    }
    
    public int getEnglish() {
        return english;
    }
}
