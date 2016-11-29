package bitcamp.java89.ems.server.controller;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.annotation.Component;
import bitcamp.java89.ems.server.annotation.RequestMapping;
import bitcamp.java89.ems.server.dao.StudentDao;
import bitcamp.java89.ems.server.vo.Student;

@Component // ApplicationContext가 관리하는 대상 클래스임을 태깅한다.
public class HelloController {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }
  
  @RequestMapping(value="hello2")
  public void hello2(HashMap<String, String> paramMap, PrintStream out) throws Exception {
    ArrayList<Student> list = studentDao.getList();
    for (Student s : list) {
      out.println(s.getName());
    }
  }
  
  @RequestMapping(value="hello")
  public void hello(HashMap<String, String> paramMap, PrintStream out) throws Exception {
    out.println("오호라....");
  }
}








