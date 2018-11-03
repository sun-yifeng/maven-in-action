# 帮助命令
mvn -h 显示帮助 <br>
mvn help:system 显示系统属性及环境变量 <br>
# 构建命令
mvn clean 清理 <br>
mvn clean compile 编译 <br>
mvn clean package 打包 <br>
mvn clean test 单元测试 <br>
mvn clean install 安装构件到本地仓库 <br>
mvn clean deploy  部署构件到远程仓库 <br>
mvn clean install -U 强制取最新的依赖快照，默认是每天更新，这个地方是个坑 <br>
mvn clean package -Dmaven.test.skip=true 打包时忽略测试 <br>
mvn clean install -Dmaven.test.skip=true 安装时忽略测试 <br>
# 反应堆裁剪
mvn clean install -pl module-name1,module-name2 构建指定的模块，多个模块用逗号分开 <br>
mvn clean install -pl module-name -am 构建指定模块及父模块 <br>
mvn clean install -pl module-name -amd 构建指定模块及子模块 <br>
mvn clean install -rf module-name 从指定模块开始，按照反应堆顺序（Reactor Build Order）构建模块 <br>
mvn clean install -pl module-begin -amd -rf module-end 指定开始、结束模块，按反应堆顺序构建模块 <br>
# 依赖优化
mvn dependency:list 打印依赖 <br>
mvn dependency:tree 打印依赖树 <br>
mvn dependency:analyze 分析依赖 <br>
mvn dependency:tree -Dverbose > tree.log 分析依赖树 <br>
# 插件绑定
mvn verify 查看自定义绑定 <br>
# 测试命令
mvn test 运行所有junit <br>
mvn test -Dtest=ClassNameTest 运行某个测试类 <br>
mvn cobertura:cobertura 测试覆盖率分析报告 <br>
mvn clean deploy site -deploye 部署项目站点 <br>
# web页面测试
mvn jetty:run <br>
# 版本管理
mvn release:prepare 版本准备、打版本标签、提交到版本库 <br>
mvn release:rollback 回退版本，需要手动删除版本标签 <br>
mvn release:perform 发布版本，签出源代码并执行mvn deploy <br>
# 内置属性
${basedir} 项目根目录 <br>
${version} 项目版本 <br>
# 常用属性
${project.build.sourceDirectory} 主源代码目录 <br>
${project.build.testSourceDirectory} 测试代码目录 <br>
${project.build.directory} 构建输出目录target <br>
${project.build.outputDirectory} 编译输出目录target/classes <br>
${project.build.testOutputDirectory} 测试代码输出目录target/test-classes <br>
${project.groupId} 项目的groupId <br>
${project.artifactId} 项目的artifactId <br>
${project.version} 项目的version，等价${version} <br>
${project.build.finalName} 打包名称，默认是${project.artifactId}-${project.version} <br>
${setting.localRepository} setting.xml的地址 <br>
${user.home} 用户主目录 <br>
${env.JAVA_HOME} JAVA环境变量 <br>
# 搜索构建的仓库服务(经常用到)
http://mvnrepository.com <br>
http://repository.sonatype.org <br>
http://www.jarvana.com/jravana <br>
http://www.mvnbrowser.com <br>
# IDE新建项目时启动nexux，否则新建的项目错误不好排查
nexus -help 提示nexus主目录及启动方法 <br>
./nexus start 启动nexus <br>
/usr/local/nexus-3.9.0-01-mac/nexus-3.9.0-01/bin/nexus start 启动nexus <br>
http://localhost:8081/  启动一两分钟后才能访问 <br>
# 登录用户密码admin/admin123

