package com.yst.common.bean;

import javax.persistence.*;

@Table(name = "t_school")
public class School {
    /**
     * ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public Long getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}