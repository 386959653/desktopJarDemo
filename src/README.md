1、双击start.bat启动程序

2、通过编辑start.bat的参数，可以配置要清空几天前的回收站文件，参数类型为数字

3、默认情况回收站里30天前的文件（不输入参数或参数输入错误都用默认情况执行程序）

4、可以辅助windows系统的任务计划程序来定期清空回收站里的过期文件，
需要把文件(start.bat和desktopJarDemo-1.0-SNAPSHOT.jar)放到C:\Windows\system32下，
或者指定任务计划程序起始于你这些文件的根目录