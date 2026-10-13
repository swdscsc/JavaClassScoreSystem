package handler;

import java.sql.Connection;
import java.util.HashMap;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseHandler {
   
   
 /**
 * 将HashMap中的数据插入到数据库的方法。
 *
 * 该方法接受一个包含班级名称和对应成绩的HashMap对象，将其中的数据逐条插入到指定的数据库表中。
 *
 * @param dataMap 一个包含班级名称和对应成绩的HashMap对象，其中键为班级名称（String类型），值为成绩（Integer类型）。
 * @throws SQLException 当数据库连接出现问题或者SQL操作失败时抛出此异常。
 */
   

    public void databaseHandler(HashMap<String, Double> hm) throws Exception {
    	
        String url = "jdbc:mysql://127.0.0.1:3306/demo01?useSSL=false&serverTimezone=UTC";
        // 链接数据库demo
        String username = "root";
        String password = "123456";
        
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        String sql = null;

 /**
 * 遍历HashMap，生成并执行插入SQL语句。
 */
        String driver="com.mysql.jdbc.Driver";
        
        		Class.forName(driver);
        		sql = "INSERT INTO classscore (ClassName, AverageScore) VALUES (?,?)";
  PreparedStatement st =conn.prepareStatement(sql);
        for (Map.Entry<String, Double> entry : hm.entrySet()) {
            
            
        
            // 获取班级名称
            String className=entry.getKey();
            // 获取班级对应的平均分数
            Double score=entry.getValue();
            // 为预编译的 SQL 语句设置参数值
            st.setString(1, className);
            st.setDouble(2, score);
            // 执行 SQL 语句进行数据插入
            st.executeUpdate();
            
            
                    // 保留两位小数插入数据
         
        }
        conn.close();
    }
}