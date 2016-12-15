
# dagger2 简单使用

## 导包

```gradle
apply plugin: 'com.neenbedankt.android-apt'
apply plugin: 'me.tatarka.retrolambda'

dependencies {
    //dragger2
    apt 'com.google.dagger:dagger-compiler:2.5'
    compile 'com.google.dagger:dagger:2.5'
    provided 'javax.annotation:jsr250-api:1.0'
}

```

- 需要在工程目录下的build.gradle添加apt

```
dependencies {
        classpath 'me.tatarka:gradle-retrolambda:3.2.4'
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }

```