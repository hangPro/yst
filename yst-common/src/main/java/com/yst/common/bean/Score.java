package com.yst.common.bean;

import javax.persistence.*;

@Table(name = "t_score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classId")
    private Long classid;

    @Column(name = "studentId")
    private Long studentid;

    @Column(name = "lessonId")
    private Long lessonid;

    private Float score;

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

    /**
     * @return studentId
     */
    public Long getStudentid() {
        return studentid;
    }

    /**
     * @param studentid
     */
    public void setStudentid(Long studentid) {
        this.studentid = studentid;
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
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }
}