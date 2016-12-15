# Annotations

## 导包

```
compile 'com.android.support:support-annotations:24.2.1'

```

## 常用注解

- @NonNull

注解修饰的参数不能为null, 如果为空，编译器会出现警告提醒

```java

    /**
     * @NonNull 表示不能为空， 否则会警告
     * @param s
     */
    public void showToast(@NonNull String s){
        Toast.makeText(this, "Hello" + s, Toast.LENGTH_SHORT).show();
    }

```

- @Nullable

表示返回值可以为空

```java
    @Nullable
    public String getName(@NonNull User user){
        return user.user;
    }

```

- @StringRes

可以判断是否传递了错误的资源整型值给函数 指定为某个res文件，否则报错

```java
    /**
     * @StringRes 表示只能是String.xml下的资源id 否则会报错
     * @param id
     */
    public void showToast(@StringRes int id){
        Toast.makeText(this, "Hello" + this.getResources().getString(id), Toast.LENGTH_SHORT).show();
    }

```

- @IntDef

- @StringDef

可以使用这个注解老限定值可以接受的范围 如果不是注解中的MAN | WOMEN , 编译器会报错。

```java
    public static final int MAN = 1;
    public static final int WOMEN = 0;

    private int sex;

    public String user;


    /**
     * 限制值得范围
     */
    @IntDef(flag = true, value = {MAN, WOMEN})
    public @interface Flavour{}


    @Flavour
    public int getSex() {
        return sex;
    }

    /*
    这个方法的参数只能传递User.MAN | User.WOMAN
     */
    public void setSex(@Flavour int sex) {
        this.sex = sex;
    }


```