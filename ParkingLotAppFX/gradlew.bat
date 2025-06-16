@echo off
set DIR=%~dp0
set JAVA_EXE=java

rem Find Java
if defined JAVA_HOME (
  set JAVA_EXE=%JAVA_HOME%\bin\java.exe
)

"%JAVA_EXE%" ^
  -Dorg.gradle.appname=gradlew ^
  -classpath "%DIR%\gradle\wrapper\gradle-wrapper.jar" ^
  org.gradle.wrapper.GradleWrapperMain %*
