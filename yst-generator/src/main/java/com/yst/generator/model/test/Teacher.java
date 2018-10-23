package com.yst.generator.model.test;

import javax.persistence.*;

@Table(name = "t_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;

    @Column(name = "schoolId")
    private Long schoolid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
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

    /**
     * @return schoolId
     */
    public Long getSchoolid() {
        return schoolid;
    }

    /**
     * @param schoolid
     */
    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }
}