import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      System.out.println("=== Меню заданий ===");
      System.out.println("1. Задание 1 - Точка координат");
      System.out.println("2. Задание 2 - Прямая");
      System.out.println("3. Задание 3 - Студент");
      System.out.println("4. Задание 4 - Создаем Точку и Линию");
      System.out.println("5. Задание 5 - Пистолет стреляет");
      System.out.println("0. Выход");
      System.out.print("Выберите задание: ");

      int choice = readInt(scanner);

      switch (choice) {
        case 1:
          task1(scanner);
          break;
        case 2:
          task2();
          break;
        case 3:
          task3();
          break;
        case 4:
          task4();
          break;
        case 5:
          task5();
          break;
        case 0:
          exit = true;
          System.out.println("Выход из программы.");
          break;
        default:
          System.out.println("Неверный выбор. Попробуйте снова.");
      }
    }
    scanner.close();
  }

  //Метод для безопасного ввода числа с клавиатуры

  private static int readInt(Scanner scanner) {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.print("Пожалуйста, введите число: ");
      }
    }
  }

  //Задание 1: создание точек с вводом координат

  private static void task1(Scanner scanner) {
    System.out.println("--- Задание 1 ---");
    System.out.println("Создайте три точки с координатами X и Y:");

    // Ввод координат для точки 1
    System.out.print("Введите X1: ");
    double x1 = readDouble(scanner);
    System.out.print("Введите Y1: ");
    double y1 = readDouble(scanner);
    Point p1 = new Point(x1, y1);

    // Ввод координат для точки 2
    System.out.print("Введите X2: ");
    double x2 = readDouble(scanner);
    System.out.print("Введите Y2: ");
    double y2 = readDouble(scanner);
    Point p2 = new Point(x2, y2);

    // Ввод координат для точки 3
    System.out.print("Введите X3: ");
    double x3 = readDouble(scanner);
    System.out.print("Введите Y3: ");
    double y3 = readDouble(scanner);
    Point p3 = new Point(x3, y3);

    System.out.println(p1);
    System.out.println(p2);
    System.out.println(p3);
  }

  // Метод для безопасного ввода числа с плавающей точкой
  private static double readDouble(Scanner scanner) {
    while (true) {
      try {
        return Double.parseDouble(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.print("Некорректный ввод. Пожалуйста, введите число: ");
      }
    }
  }

  //Задание 2: работа с линиями и изменение точек

  private static void task2() {
    System.out.println("\n--- Задание 2 ---");
    Point start1 = new Point(1, 3);
    Point end1 = new Point(23, 8);
    Line line1 = new Line(start1, end1);

    Point start2 = new Point(5, 10);
    Point end2 = new Point(25, 10);
    Line line2 = new Line(start2, end2);

    // Линия 3 — зависит от начала линии 1 и конца линии 2
    Line line3 = new Line(start1, end2);

    System.out.println(line1);
    System.out.println(line2);
    System.out.println(line3);

    // Изменяем координаты — линия 3 должна отразить изменения
    start1.setX(2);
    start1.setY(4);
    end2.setX(30);
    end2.setY(12);

    System.out.println("После изменения координат:");
    System.out.println(line1);
    System.out.println(line2);
    System.out.println(line3);

    Point newStart1 = new Point(10, 10);
    line1.setStart(newStart1);
    System.out.println("После изменения начала линии 1:");
    System.out.println(line1);
    System.out.println(line3);
  }

  // Задание 3: работа с массивами оценок студентов.

  private static void task3() {
    System.out.println("--- Задание 3 ---");

    // Создаём студента Васю с оценками 3, 4, 5
    int[] vasyaGrades = {3, 4, 5};
    Student vasya = new Student("Вася", vasyaGrades);

    // Создаём студента Петю, скопировав оценки Васи
    Student petya = new Student("Петя", vasya.getGrades());
    // Заменяем первую оценку Пети на 5
    // Не изменяем сам массив Пети, а получаем копию и изменяем её
    int[] petyaGradesCopy = petya.getGrades();
    petyaGradesCopy[0] = 5;
    // Чтобы изменения вступили в силу, нужно создать нового Петю с новыми оценками
    petya = new Student("Петя", petyaGradesCopy);

    // Создаём студента Андрея, скопировав оценки Васи
    Student andrey = new Student("Андрей", vasya.getGrades());

    // Выводим всех студентов
    System.out.println(vasya);
    System.out.println(petya);
    System.out.println(andrey);

    System.out.println("Изменение оценок Пети не повлияло на Васю и Андрея, потому что использовалась копия массива.");
  }

  //Задание 4: создание точек и линий по новым требованиям
  private static void task4() {
    System.out.println("--- Задание 4 ---");
    Point p1 = new Point(3, 5);
    Point p2 = new Point(25, 6);
    Point p3 = new Point(7, 8);

    System.out.print("Точка 1:");
    System.out.println(p1);
    System.out.print("Точка 2:");
    System.out.println(p2);
    System.out.print("Точка 3:");
    System.out.println(p3);

    Line l1 = new Line(new Point(1, 3), new Point(23, 8));
    Line l2 = new Line(new Point(5, 10), new Point(25, 10));
    Line l3 = new Line(l1.getStart(), l2.getEnd());

    System.out.println(l1);
    System.out.println(l2);
    System.out.println(l3);
  }

  // Задание 5: стрельба из пистолета
  private static void task5() {
    System.out.println("--- Задание 5 ---");
    Gun gun = new Gun(3); // пистолет с 3 патронами
    for (int i = 0; i < 5; i++) {
      gun.shoot(); // стреляем 5 раз
    }
  }
}