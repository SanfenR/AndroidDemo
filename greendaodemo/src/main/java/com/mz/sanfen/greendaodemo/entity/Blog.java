package com.mz.sanfen.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/12/15.
 */

@Entity
public class Blog {
    @Id
    private Long id;
    private String title;
    @Generated(hash = 115006267)
    public Blog(Long id, String title) {
        this.id = id;
        this.title = title;
    }
    @Generated(hash = 1388801592)
    public Blog() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
