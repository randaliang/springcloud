然后在对应的 'D:/ideaprojects/cloud-config-repo'目录加入配置文件：cloud-config-client.properties和cloud-config-common.properties，里面添加如下内容

复制代码
cloud-config-common.properties的内容
———————————————————————————————————————————————————————————————————————
#url编码，解决中文问题
server.tomcat.uri-encoding=UTF-8
#序列化时间格式
spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.mvc.date-format=yyyy-MM-dd HH:mm:ss
#mvc序列化时候时区选择
spring.jackson.time-zone=GMT+8
#aop启用
spring.aop.auto=true
spring.aop.proxy-target-class=true
————————————————————————————————————————————————————————————————————————
cloud-config-client.properties的内容
———————————————————————————————————————————————————————————————————————— 
#<!-- 项目名称（spring默认读取）--> 
spring.application.name=client-test 
#数据库配置 
#自定义属性配置 
bing.for.test=hello-word