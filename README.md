# JDBC通过SSL方式连接Mysql

### 服务器
root@10.186.63.7  root  

### Mysql版本
5.7.30  

### Mysql安装路径
/opt/mysql5.7.30/

#### 服务端ca证书对应jks文件
/Users/wd/Documents/Action/project/gmssl/SSLJdbc/5.7.30/truststore.jks
#### 客户端证书对应jks文件
/Users/wd/Documents/Action/project/gmssl/SSLJdbc/5.7.30/client-keystore.jks

### 登录命令：
```
/opt/mysql5.7.30/bin/mysql -uroot -h127.0.0.1 -P25730 -proot --ssl-mode=VERIFY_CA --ssl-ca=/opt/mysql5.7.30/25730/ca.pem --ssl-cert=/opt/mysql5.7.30/25730/client-cert.pem --ssl-key=/opt/mysql5.7.30/25730/client-key.pem
```
