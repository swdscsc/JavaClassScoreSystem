package handler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pojo.Student;
import java.util.HashMap;



public class DirectoryHandler {

    public Double directoryHandler(String directory) {
        File dir = new File(directory);
        // 获取目录
        List<File> allFileList = new ArrayList<>();
        // 存放所有文件
        getAllFile(dir, allFileList);
        // 获取目录下所有class.txt文件
        HashMap<String, Double> MasterMap = new HashMap<>();
        // 主表记录——班级名+平均分
        HashMap<String, Double> SubMap = new HashMap<>();
        // 次表记录——班级名+人数
        FileHandler fileHandler = new FileHandler();
        DatabaseHandler database = new DatabaseHandler();

        // 以文件个数为循环次数
        for (File file : allFileList) {
            List<Student> students = fileHandler.fileHandler(directory + File.separator + file.getName());
            // 补全文件名+通过<FileHandler>处理后返回学生链表
            for (Student student : students) {
                String ClassName = student.getStudentName();
                // 获取班级名
                double StudentGrades = student.getStudentScore();
                // 获取学生成绩
                MasterMap.putIfAbsent(ClassName, 0.0);
                SubMap.putIfAbsent(ClassName, 0.00);
                MasterMap.put(ClassName, MasterMap.get(ClassName) + StudentGrades);
                SubMap.put(ClassName, SubMap.get(ClassName) + 1);
            }
        }

        for (Map.Entry<String, Double> entry : MasterMap.entrySet()) {
            Double numStudents = SubMap.get(entry.getKey());
            if (numStudents > 0) {
                MasterMap.put(entry.getKey(), entry.getValue() / numStudents);
                // 存入每个班级对应平均分
            }
        }
 try {
	database.databaseHandler(MasterMap);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        double Grade_Score = 0;
        // 总分
        double Number = 0;
        // 总人数
        for (Map.Entry<String, Double> entry : MasterMap.entrySet()) {
            Grade_Score += entry.getValue() * SubMap.get(entry.getKey());
            // 计算总分
            Number += SubMap.get(entry.getKey());
            // 计算总人数
        }

      
        return Grade_Score / Number;
        // 返回总平均分
    }

    // 递归获取所有文件
    public static void getAllFile(File dir, List<File> allFileList) {
        // 获取文件列表
        File[] fileList = dir.listFiles();
        // 返回该目录中的文件和目录
        assert fileList != null;
        for (File file : fileList) {
            if (file.isDirectory()) {
                getAllFile(file, allFileList);
                // 如果是文件夹则继续打开
            } else {
                allFileList.add(file);
                // 如果是文件则添加到列表中
            }
        }
    }
}
