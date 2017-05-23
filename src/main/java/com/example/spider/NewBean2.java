package com.example.spider;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
public class NewBean2 {
    private long id;

    private String impid;

    private List<String> dislike_reasons;

    private String ctype;
    private String pageid;
    private String title;
    private int dtype;

    private String meta;

    private String summary;
    private String date;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImpid() {
        return impid;
    }

    public void setImpid(String impid) {
        this.impid = impid;
    }

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }

    public int getDtype() {
        return dtype;
    }

    public void setDtype(int dtype) {
        this.dtype = dtype;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public List<String> getDislike_reasons() {
        return dislike_reasons;
    }

    public void setDislike_reasons(List<String> dislike_reasons) {
        this.dislike_reasons = dislike_reasons;
    }
}
