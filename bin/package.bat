@echo off
echo.
echo [��Ϣ] ���Web���̣�����war/jar���ļ���
echo.

%~d0
cd %~dp0
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131
set PATH=%JAVA_HOME%/bin;%JAVA_HOME%/jre/bin
set CLASSPATH=.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar
cd ..
path = C:\apache-maven-3.6.3-bin\apache-maven-3.6.3\bin
call mvn clean package -Dmaven.test.skip=true

pause