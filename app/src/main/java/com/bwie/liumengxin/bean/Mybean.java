package com.bwie.liumengxin.bean;

/**
 * date：2017/11/20
 * 用途：
 */
public class Mybean {
    private String title;
    private String pic;
    private String dataId;
    private String duration;
    private String description;

    @Override
    public String toString() {
        return "Mybean{" +
                "title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", dataId='" + dataId + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Mybean(String title, String pic, String dataId, String duration, String description) {
        this.title = title;
        this.pic = pic;
        this.dataId = dataId;
        this.duration = duration;
        this.description = description;
    }
}
