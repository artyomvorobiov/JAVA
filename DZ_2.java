import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] students  = new String[4];
        int[] grades  = new int[4];
        boolean[] answer  = new boolean[4];
        boolean[] incl  = new boolean[4];
        Arrays.fill(incl, true);
        students[0] = "Абиев Марик";
        students[1] = "Антон Поклонский";
        students[2] = "Дмитрий Спиридонов";
        students[3] = "Артём Воробьев";
        grades[0] = -1;
        grades[1] = -1;
        grades[2] = -1;
        grades[3] = -1;
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        while (!"/end".equals(str)) {
            if (Objects.equals(str, "/r")) {
                int a = (int) (Math.random() * 4);
                System.out.print("Отвечает " + students[a] + "\n");
                if (!incl[a]) {
                    System.out.print("Студента нет на паре, введите /h для помощи  \n");
                } else {
                    if (!answer[a]) {
                        System.out.print("Присутсвует ли на паре? Введите y, если да \n");
                        String str1 = console.nextLine();
                        if (Objects.equals(str1, "y")) {
                            incl[a] = true;
                            int b = (int) (Math.random() * 10);
                            grades[a] = b;
                            System.out.print("Оценка за ответ " + b + "\n");
                        } else {
                            incl[a] = false;
                            System.out.print("Студента нет на паре, введите /h для помощи" + "\n");
                        }
                        answer[a] = true;
                    } else {
                        System.out.print("Студент уже отвечал, введите /h для помощи \n");
                    }
                }
            }
            else if (Objects.equals(str, "/l")){
                for (int i = 0; i < students.length; i++){
                    if (grades[i] != -1) {
                        System.out.print(students[i] + ": " + grades[i] + "\n");
                    }
                    else {
                        System.out.print(students[i] + ": " + "не отвечал" + "\n");
                    }
                }
            }
            else if (Objects.equals(str, "/h")){
                System.out.print("""
                        1. /r - choose random student\s
                        2. /l - list of student with grades
                        """);
            }
            str = console.nextLine();
        }
    }
}
