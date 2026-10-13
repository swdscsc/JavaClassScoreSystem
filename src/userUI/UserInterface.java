package userUI;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import handler.DirectoryHandler;
import java.net.URL;


 //UserInterface 类用于创建和管理用户界面。
 

public class UserInterface {
    
    // 声明用户界面组件
    private JFrame Window;         
    // 主窗口
   
    private JLabel LabelPath;      
    // 路径标签
    
    private JTextField JavaTestPath; 
    // 路径输入框
    
    private JLabel LabelResults;   
    // 结果标签
   
    private JLabel LabelAverage;   
    // 平均分标签
    
    private JButton Button;         
    // 确定按钮
    
    
 //创建并显示用户界面。
    
   public void UserUI() {
        
        // 初始化JFrame并设置基本属性
        Window = new JFrame();
        Window.setSize(340, 300);
        Window.setLocationRelativeTo(null);
        Window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Window.setLayout(null);

        
        // 初始化并设置路径标签的位置和内容
        LabelPath = new JLabel("请输入你要解析的文件所在的路径：");
        LabelPath.setFont(new java.awt.Font("宋体", java.awt.Font.BOLD, 13));
        LabelPath.setForeground(Color.BLUE);
        LabelPath.setBounds(15, 15, 290, 30);
        
       
        // 初始化并设置结果标签的位置和内容
        LabelResults = new JLabel("统计结果为：");
        LabelResults.setFont(new java.awt.Font("宋体", java.awt.Font.BOLD, 13));
        LabelResults.setForeground(Color.BLUE);
        LabelResults.setBounds(15, 130, 100, 20);

        
        // 初始化并设置路径输入框的位置和大小
        JavaTestPath = new JTextField();
        JavaTestPath.setBounds(15, 60, 300, 30);

        
        // 初始化平均分标签，用于显示计算结果
        LabelAverage = new JLabel();
        LabelAverage.setFont(new java.awt.Font("宋体", java.awt.Font.BOLD,15));
        LabelAverage.setForeground(Color.RED);
        LabelAverage.setBounds(93, 130, 70, 20);

        
        // 初始化并设置确定按钮的位置和大小，添加点击事件监听
        Button = new JButton("确定");
        Button.setFont(new java.awt.Font("宋体", java.awt.Font.BOLD, 14));
        Button.setForeground(Color.BLUE);
        Button.setBounds(15, 180, 300, 30);
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(); 
                // 处理按钮点击事件
            }
        });

        
        // 设置背景
        JLabel lblBackground = new JLabel();                                         
        // 创建一个标签组件对象
        URL resource = this.getClass().getResource("/userUI/2024-06-18 150523.png"); 
        // 获取背景图片的路径
        ImageIcon icon = new ImageIcon(resource);                                     
        // 创建背景图片对象
        lblBackground.setIcon(icon);                                                  
        // 设置标签组件要显示的图标
        
        lblBackground.setBounds(-65, -35, icon.getIconWidth(), icon.getIconHeight()); 
        // 设置组件的显示大小及位置

        
        // 将所有组件添加到JFrame中
        Window.add(LabelPath);
        Window.add(LabelResults);
        Window.add(JavaTestPath);
        Window.add(LabelAverage);
        Window.add(Button);
        Window.getContentPane().add(lblBackground);

       
        // 显示JFrame
        Window.setVisible(true);
    }

    
    // 处理按钮点击事件，获取路径并计算结果
    private void handleButtonClick() {
        String path = JavaTestPath.getText();
        // 获取输入的路径
        DirectoryHandler directory = new DirectoryHandler(); 
        // 创建DirectoryHandler实例
        int average = 0;
        try {
            average = (int) (directory.directoryHandler(path) * 100); 
            // 调用directoryHandler方法并转换为整数
        } catch (Exception e) {
            e.printStackTrace();
             // 打印异常信息
        }
        LabelAverage.setText(average * 1.0 / 100 + " 分"); 
        // 设置平均分标签的文本
    }
    public static void main(String[] args) {
    	 UserInterface ui = new UserInterface();
         // 创建UserInterface类的实例
         ui.UserUI();
         // 调用UserInterface类的createUI方法 
    }
}
