package generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ExecuSql {


    private static String uname="root";

    private static String pwd="123456";
    /**
     * 下载代码后执行这一段代码即可自动导入数据库
     * @param args
     */
    public static void main(String[] args) {
        authoritySql();
        distributionSql();
    }

    public static  void authoritySql(){
        String url="jdbc:mysql://127.0.0.1:3306/?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String fileName="authority";
        String uname= ExecuSql.uname;
        String  pwd=ExecuSql.pwd;
        toExcuesql(url,uname,pwd,fileName);
    }
    public static void distributionSql(){
        String url="jdbc:mysql://127.0.0.1:3306/?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String fileName="distribution";
        String uname= ExecuSql.uname;
        String  pwd=ExecuSql.pwd;
        toExcuesql(url,uname,pwd,fileName);
    }

    public static  void testSql(){
        String url="jdbc:mysql://127.0.0.1:3306/?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false";
        String uname= ExecuSql.uname;
        String  pwd=ExecuSql.pwd;
        String fileName="distribution";
        toExcuesql(url,uname,pwd,fileName);
    }

    public static void toExcuesql(String url,String username,String password,String fileName){
        try {
            // 建立连接
            Connection conn = DriverManager.getConnection(url, username, password);
            // 创建ScriptRunner，用于执行SQL脚本
            ScriptRunner runner = new ScriptRunner(conn);
            runner.setErrorLogWriter(null);
            runner.setLogWriter(null);
            // 执行SQL脚本
            runner.runScript(Resources.getResourceAsReader("sql/" + fileName + ".sql"));
            // 关闭连接
            conn.close();
            // 若成功，打印提示信息
            System.out.println("====== 导入成功 ======");
        } catch (IOException | SQLException e) {
            System.out.println("====== 导入失败 ======");
            e.printStackTrace();
        }
    }

}

