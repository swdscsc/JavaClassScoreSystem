package handler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import pojo.Student;

public class FileHandler {
    /**
 * 读取文件内容，将其中的学生信息解析并转换为Student对象列表。
 *
 * @param fileName 包含学生信息的文件名
 * @return 解析后的Student对象列表
 */
    public List<Student> fileHandler(String fileName) {
        try (InputStreamReader read = new InputStreamReader(new FileInputStream(fileName)); // 解决中文乱码问题，“GB2312”为简体中文编码
                BufferedReader reader = new BufferedReader(read)) {
                 // 读取文件

             List<Student> students = new ArrayList<>();
            // 创建学生来链表
            String line = null;
            while ((line = reader.readLine()) != null) {
                // 一次读取一行
                String[] arr = line.split(" ");
                // 正则表达式分割字符串
                Student student = new Student(arr[0], arr[1], Double.parseDouble(arr[2]));// 以班级，姓名，成绩创建学生对象
                students.add(student);
                // 添加到学生链表
            }
            return students;
            // 返回学生链表
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}