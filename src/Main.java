import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix A = new Matrix();
        int n;
        Scanner scanner=new Scanner(System.in);
        do {
            System.out.println("Виберіть пунк з меню:\n1.Створити нову матрицю\n2.Заповнити матрицю\n3.Отримати заданий елемент\n" +
                    "4.Отримати рядок\n5.Отримати стовпчик\n6.Розмірність матриці\n7.Діагональна матриця\n8.Верхня трикутна матриця" +
                    "\n9.Нижня трикутна матриця\n10.Копія та порівняння з оригіналом\n0.Вихід");
            n=scanner.nextInt();
            switch (n) {
                case (1):
                    A.create();
                    break;
                case (2):
                    A.fill();
                    break;
                case (3):
                    A.get_numb();
                    break;
                case (4):
                    A.get_line();
                    break;
                case (5):
                    A.get_col();
                    break;
                case (6):
                    A.dim();
                    break;
                case (7):
                    A.diag_mat();
                    break;
                case (8):
                    A.up_mat();
                    break;
                case (9):
                    A.down_mat();
                    break;
                case (10):
                    System.out.println(A.equals(A.copy(A.matrix)));
                    break;
                case(0):
                    System.exit(0);
                    break;
                default:
                    System.out.println("Виберіть пунк що існує в меню");
            }
        }while(true);
    }
}