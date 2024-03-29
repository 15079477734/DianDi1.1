package com.bmob.im.demo.bean;

import com.bmob.im.demo.util.util.GetDate;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.Date;

/**
 * ************************************************************
 * *********    User : SuLinger(462679107@qq.com) .
 * *********    Date : 2014-09-10  .
 * *********    Time:  2014-09-10  .
 * *********    Project name :PBOX1.3 .
 * *********    Copyright @ 2014, SuLinger, All Rights Reserved
 * *************************************************************
 */

@DatabaseTable(tableName = "plan")
public class Plan implements Serializable {
    public static final String ID = "_id";
    public static final String TITLE = "title";
    public static final String DATE = "date";
    public static final String PROGRESS = "progress";
    public static final String CATEGORY = "category";
    public static final String IOP = "top";
    public static final String NOTE = "note";

    public final static int URGENT_TOP = 1;
    public final static int URGENT_EXTRA = 2;
    public final static int URGENT_HIGH = 3;
    public final static int URGENT_MIDDLE = 4;
    public final static int URGENT_LOW = 5;
    public final static int URGENT_FINISHED = 6;
    @DatabaseField(useGetSet = true, generatedId = true)
    private int _id;
    @DatabaseField(useGetSet = true, defaultValue = "")
    private String title;
    @DatabaseField(dataType = DataType.DATE, useGetSet = true)
    private Date planDate;
    @DatabaseField(useGetSet = true, defaultValue = "0")
    private int progress;
    @DatabaseField(useGetSet = true, defaultValue = "0")
    private String category;
    @DatabaseField(useGetSet = true, defaultValue = "0")
    private String top;
    @DatabaseField(useGetSet = true, defaultValue = "")
    private String note;
    @DatabaseField(useGetSet = true, defaultValue = "6")
    private int type;

    public Plan() {
    }

    @Override
    public String toString() {
        return "Plan{" +
                "_id=" + _id +
                ", title='" + title + '\'' +
                ", date=" + GetDate.getDatetimeString(planDate) +
                ", progress=" + progress +
                ", category='" + category + '\'' +
                ", top='" + top + '\'' +
                ", note='" + note + '\'' +
                ", type=" + type +
                '}';
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }


    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
