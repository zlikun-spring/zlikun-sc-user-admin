# 基于java8镜像
FROM java:8

# 指定作者信息
MAINTAINER zlikun "zlikun-dev@hotmail.com"

# 复制文件到容器
ADD admin.jar /app/app.jar
WORKDIR /app

# 指定暴露端口
EXPOSE 9010

# 配置容器启动后执行的命令
ENTRYPOINT ["java", "-jar", "app.jar"]