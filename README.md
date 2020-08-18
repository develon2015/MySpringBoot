# MySpringBoot

# 如何使用
在您的项目文件`settings.gradle.kts`中包含本项目:
```
include("MySpringBoot")
```
然后在`build.gradle.kts`中添加依赖:
```
dependencies {
    implementation(project("MySpringBoot"))
}
```
