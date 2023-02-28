# ui_auto_selenium_test
采用java语言+web UI自动化测试框架selenium+测试用例运行管理testng框架+报告美化框架Allure+log4j日志输出框架
Maven项目搭建，分为：
公共层：BasePage类和BaseTest类，其中BasePage类封装页面元素的一些操作方法，BaseTest类封装浏览器操作的一些方法以及断言方法
页面层：继承BasePage类的具体页面类，存放具体页面的元素定位属性以及具体元素的操作方法
用例层：继承BaseTest类的测试脚本，先执行打开浏览器最大化浏览器等方法作为前置，然后在每一个test方法中实例化具体页面类对象，调用具体页面类中一些具体元素的操作方法模拟手工执行步骤
业务逻辑层：用来封装某些会重复的操作步骤，以便在test用例的test方法中直接调用已封装的业务逻辑的方法，大大减少代码量
监听器层：定义失败截图保存的监听器，失败重跑的监听器，并将监听器配置在testng.xml
工具层：定义ExcelUtil类用来获取excel文件中的数据并传给测试用例进行参数化
将项目克隆到本地电脑后，需要在本地安装Maven配置环境变量，然后给克隆到本地的项目配置本地maven，在cmd窗口切换到克隆项目路径下，一次执行：
mvn clean test  运行自动化测试脚本
mvn io.qameta.allure:allure-maven:serve   将测试结果数据通过allure服务生成报告

设计理念：使用Maven构建工具管理项目，引入PO设计模式对框架进行分层（页面层、逻辑操作层、用例层、基础层），将用例层的共性部分抽取到基础层的BaseTest用例基类，将页面层的共性部分抽取到基础差的BasePage页面基类，使用dataProvider实现数据驱动，集成log4j日志框架、集成Allure报表、添加一个listener层用于引入用例失败截图重试机制，提高用例稳定性、采用并行测试的方式提高用例执行效率，最后通过GIT将代码集成到Jenkins，每天定时执行构建，执行结果通过邮件发送到项目组相关人员。
其他设备使用IDEA工具克隆并在本地设备打开该项目的步骤：![image](https://user-images.githubusercontent.com/42194910/221786326-1d00afa3-e549-4a7a-bc0e-1e2c9e6535ea.png)
File >> New >> Project from Version Control...
![1677570247531](https://user-images.githubusercontent.com/42194910/221786827-1007f0c1-d5da-4514-8a42-60385929eea3.png)
