package object_oriented;

public class PassFailCourse extends Course{
    String studentType;
    int reportScore;
    int quizScore;
    int presentationScore;

    PassFailCourse(String name, int attendanceScore, String studentType, int reportScore, int quizScore, int presentationScore) {
        super(name, attendanceScore);
        this.studentType = studentType;
        this.reportScore = reportScore;
        this.quizScore = quizScore;
        this.presentationScore = presentationScore;
    }
}
