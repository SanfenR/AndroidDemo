# 介绍

[官网地址](http://greenrobot.org/greendao/)

[GreenDao github](https://github.com/greenrobot/greenDAO)

# GreenDao 优点

1. 性能高，号称Android最快的关系型数据库
2. 内存占用小
3. 库文件比较小，小于100K，编译时间低，而且可以避免65K方法限制
4. 支持数据库加密  greendao支持SQLCipher进行数据库加密 有关SQLCipher可以参考这篇博客Android数据存储之Sqlite采用SQLCipher数据库加密实战
5. 简洁易用的API

# GreenDao 3.0基本使用

## 在.gradle添加依赖

```groovy
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.greenrobot:greendao-gradle-plugin:3.2.1'
    }
}

apply plugin: 'org.greenrobot.greendao'

dependencies {
    compile 'org.greenrobot:greendao:3.2.0'
}
```

需要配置数据库的基本属性

```groovy
    greendao {
        schemaVersion 1
        targetGenDir 'src/main/java'
    }
```
- schemaVersion：数据库版本号
- daoPackage：设置DaoMaster, DaoSession, Dao包名
- targetGenDir: 设置DaoMaster, DaoSession, Dao目录
- targetGenDirTest: 设置生成单元测试目录
- generateTests 设置自动生成单元测试用例

## 创建实体

```java
@Entity()
public class User {

    @Id
    private Long id;
    private String name;
    private int age;
    //省去了get/set方法
}

```
实体@Entity注解:

- schema：表示GreenDao当前实体属于哪个schema
- active: 标记一个实体处于活动状态，活动实体有更新，删除和刷新方法
- nameInDb: 在数据中使用的别名，默认使用的是实名的类别
- indexes: 定义索引，可以跨越多个列
- createInDb: 标记创建数据库表

基础属性注解:

- @Id: 主键 Long型，可以通过@Id(autoincrement = true)设置自增长
- @Property: 设置一个非默认关系映射所对应的列名，默认是的使用字段名 举例：@Property (nameInDb="name")
- @NotNul：设置数据库表当前列不能为空
- @Transient ：添加次标记之后不会生成数据库表的列

索引注解:
- @Index：使用@Index作为一个属性来创建一个索引，通过name设置索引别名，也可以通过unique给索引添加约束
- @Unique：向数据库列添加了一个唯一的约束

关系注解:
- @ToOne：定义与另一个实体（一个实体对象）的关系
- @ToMany：定义与多个实体对象的关系


## 编译生成DaoMaster, DaoSession, Dao

![image](http://ohqvqufyf.bkt.clouddn.com/greendao.png)


- 创建一个数据库管理者单例
```java
public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }
}
```

- 获取可读可写数据库

```java

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        return openHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        return openHelper.getWritableDatabase();
    }

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insertUser(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insert(user);
    }

    /**
     * 插入用户集合
     *
     * @param users
     */
    public void insertUserList(List<User> users) {
        if (users == null || users.isEmpty()) {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insertInTx(users);
    }

    /**
     * 删除一条记录
     *
     * @param user
     */
    public void deleteUser(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.delete(user);
    }

    /**
     * 更新一条记录
     *
     * @param user
     */
    public void updateUser(User user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.update(user);
    }

    /**
     * 查询用户列表
     */
    public List<User> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        return qb.list();
    }

    /**
     * 查询用户列表
     */
    public List<User> queryUserList(int age) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.Age.gt(age)).orderAsc(UserDao.Properties.Age);
        return qb.list();
    }
```


# 外键使用(@ToOne, @ToMany)


```java
@Entity
public class User {
    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;

    private int age;

    private Long blogId;

    @ToOne(joinProperty = "blogId")
    private Blog blog;
}

```
- joinProperties这个参数是referencedJoinProperty 参数的升级版。在referencedJoinProperty参数中我们发现俩个实体关联的外键是CustomerId与id，但是如果我们的需求是外键不能通过id来定义，需要用自己自定义属性来定义，第一种方法就没法用了，而joinProperties就是为了解决这个需求的。


[github源码](https://github.com/SanfenR/AndroidDemo/tree/master/greendaodemo)


# 参考资料

[GreenDao 3.0使用](http://www.jianshu.com/p/252555228b72)

[Android数据存储之GreenDao 3.0 详解](https://www.cnblogs.com/whoislcj/p/5651396.html)

[GreenDao3.0新特性解析（配置、注解、加密](http://www.cnblogs.com/dsxniubility/p/5699543.html)

[史上最高效的ORM方案——GreenDao3.0高级用法](http://www.jianshu.com/p/d61983df2341)