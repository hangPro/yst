package com.yst.common.bean;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_plan_lesson")
public class PlanLesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lessonId")
    private Long lessonid;

    @Column(name = "planDateStart")
    private Date plandatestart;

    @Column(name = "planDateEnd")
    private Date plandateend;

    @Column(name = "classId")
    private Long classid;

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
     * @return lessonId
     */
    public Long getLessonid() {
        return lessonid;
    }

    /**
     * @param lessonid
     */
    public void setLessonid(Long lessonid) {
        this.lessonid = lessonid;
    }

    /**
     * @return planDateStart
     */
    public Date getPlandatestart() {
        return plandatestart;
    }

    /**
     * @param plandatestart
     */
    public void setPlandatestart(Date plandatestart) {
        this.plandatestart = plandatestart;
    }

    /**
     * @return planDateEnd
     */
    public Date getPlandateend() {
        return plandateend;
    }

    /**
     * @param plandateend
     */
    public void setPlandateend(Date plandateend) {
        this.plandateend = plandateend;
    }

    /**
     * @return classId
     */
    public Long getClassid() {
        return classid;
    }

    /**
     * @param classid
     */
    public void setClassid(Long classid) {
        this.classid = classid;
    }
}