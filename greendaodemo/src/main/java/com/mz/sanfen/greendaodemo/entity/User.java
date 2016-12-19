package com.mz.sanfen.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/12/15.
 */

@Entity(
        active = true,
        nameInDb = "USER",
        createInDb = false)
public class User {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String name;

    private int age;

    private Long blogId;

    @ToOne(joinProperty = "blogId")
    private Blog blog;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 384172391)
    private transient Long blog__resolvedKey;

    @Generated(hash = 1535784894)
    public User(Long id, @NotNull String name, int age, Long blogId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.blogId = blogId;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public Long getBlogId() {
        return this.blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1907406751)
    public Blog getBlog() {
        Long __key = this.blogId;
        if (blog__resolvedKey == null || !blog__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BlogDao targetDao = daoSession.getBlogDao();
            Blog blogNew = targetDao.load(__key);
            synchronized (this) {
                blog = blogNew;
                blog__resolvedKey = __key;
            }
        }
        return blog;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1063134684)
    public void setBlog(Blog blog) {
        synchronized (this) {
            this.blog = blog;
            blogId = blog == null ? null : blog.getId();
            blog__resolvedKey = blogId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
