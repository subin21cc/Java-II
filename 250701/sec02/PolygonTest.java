package sec02;
import java.util.Scanner;

public class PolygonTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Polygon polygon = new Polygon();

        for(;;){
            System.out.print("menu select 1) 삼각형 2) 직사각형 3) 정사각형:");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    double triangleArea = polygon.getTriangleArea();
                    System.out.println(triangleArea);
                    break;
                case 2:
                    double rectangleArea = polygon.getRectangleArea();
                    System.out.println(rectangleArea);
                    break;
                case 3:
                    double squareArea = polygon.getSquareArea();
                    System.out.println(squareArea);
                    break;
            }
        }
    }
}
