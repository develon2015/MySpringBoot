# MySpringBoot

# 如何使用
在你的根项目文件`settings.gradle`中包含本项目:
```
include 'MySpringBoot'
```
然后在根项目下SpringBoot应用程序子项目的配置文件`build.gradle`中添加依赖:
```
dependencies {
    implementation project(':MySpringBoot')
}
```
