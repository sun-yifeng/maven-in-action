#帮助命令
mvn -h 显示帮助
mvn help:system 显示系统属性及环境变量
#构建命令
mvn clean 清理
mvn clean compile 编译
mvn clean package 打包
mvn clean test 单元测试
mvn clean install 安装构件到本地仓库
mvn clean deploy  部署构件到远程仓库
mvn clean install -U 强制取最新的依赖快照，默认是每天更新，这个地方是个坑
mvn clean package -Dmaven.test.skip=true 打包时忽略测试
mvn clean install -Dmaven.test.skip=true 安装时忽略测试
#反应堆裁剪
mvn clean install -pl module-name1,module-name2 构建指定的模块，多个模块用逗号分开
mvn clean install -pl module-name -am 构建指定模块及父模块
mvn clean install -pl module-name -amd 构建指定模块及子模块
mvn clean install -rf module-name 从指定模块开始，按照反应堆顺序（Reactor Build Order）构建模块
mvn clean install -pl module-begin -amd -rf module-end 指定开始、结束模块，按反应堆顺序构建模块
#依赖优化
mvn dependency:list 打印依赖
mvn dependency:tree 打印依赖树
mvn dependency:analyze 分析依赖
mvn dependency:tree -Dverbose > tree.log 分析依赖树
#插件绑定
mvn verify 查看自定义绑定
#测试命令
mvn test 运行所有junit
mvn test -Dtest=ClassNameTest 运行某个测试类
mvn cobertura:cobertura 测试覆盖率分析报告
mvn clean deploy site -deploye 部署项目站点
#web页面测试
mvn jetty:run
#版本管理
mvn release:prepare 版本准备、打版本标签、提交到版本库
mvn release:rollback 回退版本，需要手动删除版本标签
mvn release:perform 发布版本，签出源代码并执行mvn deploy
#内置属性
${basedir} 项目根目录
${version} 项目版本
#常用属性
${project.build.sourceDirectory} 主源代码目录
${project.build.testSourceDirectory} 测试代码目录
${project.build.directory} 构建输出目录target
${project.build.outputDirectory} 编译输出目录target/classes
${project.build.testOutputDirectory} 测试代码输出目录target/test-classes
${project.groupId} 项目的groupId
${project.artifactId} 项目的artifactId
${project.version} 项目的version，等价${version}
${project.build.finalName} 打包名称，默认是${project.artifactId}-${project.version}
${setting.localRepository} setting.xml的地址
${user.home} 用户主目录
${env.JAVA_HOME} JAVA环境变量
#搜索构建的仓库服务(经常用到)
http://mvnrepository.com
http://repository.sonatype.org
http://www.jarvana.com/jravana
http://www.mvnbrowser.com
#nexus私服
nexus -help 提示nexus主目录及启动方法
./nexus start 启动nexus
http://localhost:8081/  启动一两分钟后才能访问

