package object_oriented;

public class Course {
    String name;
    int attendanceScore;

    Course(String name, int score) {
        this.name = name;
        this.attendanceScore = score;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getAttendanceScore() {
        return attendanceScore;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAttendanceScore(int attendanceScore) {
        this.attendanceScore = attendanceScore;
    }
}
