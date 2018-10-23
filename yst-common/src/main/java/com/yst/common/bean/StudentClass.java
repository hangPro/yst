package com.yst.common.bean;

import javax.persistence.*;

@Table(name = "t_student_class")
public class StudentClass {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "teacherId")
    private Long teacherid;

    private String phone;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return teacherId
     */
    public Long getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid
     */
    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}