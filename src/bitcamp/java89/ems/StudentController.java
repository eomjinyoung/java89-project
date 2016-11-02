package bitcamp.java89.ems;

import java.util.Scanner;

public class StudentController {
  private LinkedList list;
  private Scanner keyScan;

  public StudentController(Scanner keyScan) {
    list = new LinkedList();
    this.keyScan = keyScan;
  }

  public void service() {
    loop:
    while (true) {
      System.out.print("학생관리> ");
      String command = keyScan.nextLine().toLowerCase();

      switch (command) {
      case "add": this.doAdd(); break;
      case "list": this.doList(); break;
      case "view": this.doView(); break;
      case "delete": this.doDelete(); break;
      case "update": this.doUpdate(); break;
      case "main":
        break loop;
      default:
        System.out.println("지원하지 않는 명령어입니다.");
      }
    }
  }

  private void doList() {
    for (int i = 0; i < list.size(); i++) {
      Student student = (Student)list.get(i);
      System.out.printf("%s,%s,%s,%s,%s,%s,%d,%s\n",
        student.userId,
        student.password,
        student.name,
        student.tel,
        student.email,
        ((student.working)?"yes":"no"),
        student.birthYear,
        student.school);
    }
  }

  private void doUpdate() {
    System.out.print("변경할 학생의 인덱스? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    // 유효한 인덱스인지 검사
    if (index < 0 || index >= list.size()) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    Student oldStudent = (Student)list.get(index);

    // 새 학생 정보를 입력 받는다.
    Student student = new Student();
    System.out.print("암호(예:1111)? ");
    student.password = this.keyScan.nextLine();

    System.out.printf("이름(%s)? ", oldStudent.name);
    student.name = this.keyScan.nextLine();

    System.out.printf("전화(%s)? ", oldStudent.tel);
    student.tel = this.keyScan.nextLine();

    System.out.printf("이메일(%s)? ", oldStudent.email);
    student.email = this.keyScan.nextLine();

    System.out.print("재직중(y/n)? ");
    student.working = (this.keyScan.nextLine().equals("y")) ? true : false;

    System.out.printf("태어난해(%d)? ", oldStudent.birthYear);
    student.birthYear = Integer.parseInt(this.keyScan.nextLine());

    System.out.printf("최종학교(%s)? ", oldStudent.school);
    student.school = this.keyScan.nextLine();

    System.out.print("저장하시겠습니까(y/n)? ");
    if (keyScan.nextLine().toLowerCase().equals("y")) {
      student.userId = oldStudent.userId;
      list.set(index, student);
      System.out.println("저장하였습니다.");
    } else {
      System.out.println("변경을 취소하였습니다.");
    }
  }

  private void doAdd() {
    while (true) {
      Student student = new Student();
      System.out.print("아이디(:hong)? ");
      student.userId = this.keyScan.nextLine();

      System.out.print("암호(예:1111)? ");
      student.password = this.keyScan.nextLine();

      System.out.print("이름(예:홍길동)? ");
      student.name = this.keyScan.nextLine();

      System.out.print("전화(예:010-1111-2222)? ");
      student.tel = this.keyScan.nextLine();

      System.out.print("이메일(예:hong@test.com)? ");
      student.email = this.keyScan.nextLine();

      System.out.print("재직중(y/n)? ");
      student.working = (this.keyScan.nextLine().equals("y")) ? true : false;

      System.out.print("태어난해(예:1980)? ");
      student.birthYear = Integer.parseInt(this.keyScan.nextLine());

      System.out.print("최종학교(예:비트고등학교)? ");
      student.school = this.keyScan.nextLine();

      list.add(student);

      System.out.print("계속 입력하시겠습니까(y/n)? ");
      if (!this.keyScan.nextLine().equals("y"))
        break;
    }
  }

  private void doView() {
    System.out.print("학생의 인덱스? ");
    int index = Integer.parseInt(this.keyScan.nextLine());

    if (index < 0 || index >= list.size()) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    Student student = (Student)list.get(index);

    System.out.printf("아이디: %s\n", student.userId);
    System.out.printf("암호: (***)\n");
    System.out.printf("이름: %s\n", student.name);
    System.out.printf("전화: %s\n", student.tel);
    System.out.printf("이메일: %s\n", student.email);
    System.out.printf("재직중: %s\n", (student.working) ? "Yes" : "No");
    System.out.printf("태어난 해: %d\n", student.birthYear);
    System.out.printf("학교: %s\n", student.school);
  }

  private void doDelete() {
    System.out.print("삭제할 학생의 인덱스? ");
    int index = Integer.parseInt(keyScan.nextLine());

    if (index < 0 || index >= list.size()) {
      System.out.println("인덱스가 유효하지 않습니다.");
      return;
    }

    Student deletedStudent = (Student)list.remove(index);

    System.out.printf("%s 학생 정보를 삭제하였습니다.\n", deletedStudent.userId);
  }
}
