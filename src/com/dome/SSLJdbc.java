package com.dome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SSLJdbc {

    static final String USER = "root"; // none用户
    static final String PASS = "root";

    //## ssl-mode:DISABLED
    // 建立未加密连接
    //static final String DB_URL = "jdbc:mysql://10.186.63.7:25730/test?useSSL=false";

    //## ssl-mode:PERFERRRD
    // 优先建立加密连接
    /*static final String DB_URL = "jdbc:mysql://10.186.63.7:25730/test?" +
            "requireSSL=false" +
            "&useSSL=true" +
            "&verifyServerCertificate=false";*/

    //## 建立加密连接，不参与认证 ssl-mode:REQUIRED
    /*static final String DB_URL = "jdbc:mysql://10.186.63.7:25730/test?" +
            "requireSSL=true" +
            "&useSSL=true" +
            "&verifyServerCertificate=false";*/

    //## 建立加密连接，单向认证（客户端验证服务器身份）ssl-mode:VERIFY_CA
    /*static final String DB_URL = "jdbc:mysql://10.186.63.7:25730/test?" +
            // "requireSSL=true" +
            "&useSSL=true" +
            "&verifyServerCertificate=true" +
            "&trustCertificateKeyStoreUrl=file:/Users/wd/Documents/Action/project/gmssl/SSLJdbc/5.7.30/truststore.jks" +
            "&trustCertificateKeyStorePassword=123456";*/

    //## 建立加密连接，双向认证（客户端服务端双向验证）
    static final String DB_URL = "jdbc:mysql://10.186.63.7:25730/test?" +
            // "requireSSL=true" +
            "&useSSL=true" +
            "&verifyServerCertificate=true" +
            "&trustCertificateKeyStoreUrl=file:/Users/wd/Documents/Action/project/gmssl/SSLJdbc/5.7.30/truststore.jks" + //给客户端验证服务端身份
            "&trustCertificateKeyStorePassword=123456" +
            "&clientCertificateKeyStoreUrl=file:/Users/wd/Documents/Action/project/gmssl/SSLJdbc/5.7.30/client-keystore.jks" + // 给服务端验证客户端身份
            "&clientCertificateKeyStorePassword=123456";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stat = conn.createStatement();
            stat.execute("select * from tableA");
            System.out.println("查询成功");
            stat.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
