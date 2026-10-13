package pojo;

public class Student {
   
    private String ClassName;
    // 班级名称
    private Double StudentScore;
    // 学生成绩
    private String StudentName;
    // 学生姓名
   

    public Student(String ClassName, String StudentName, Double StudentScore ) {
        this.ClassName = ClassName;
        this.StudentName = StudentName;
        this.StudentScore = StudentScore;
    }
    
    /**
     * 获取班级名称。
     *
     * return 班级名称
     */
     public String getClassName() {
        return ClassName;
    }
     /**
     * 获取学生成绩。
     *
     * return 学生成绩
     */
    public Double getStudentScore() {
        return StudentScore;
    }
    /**
     * 获取学生姓名。
     *
     * @return 学生姓名
     */
    public String getStudentName() {
        return StudentName;
    }
}
