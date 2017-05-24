package com.example.bean;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Entity
public class NewBean {


    @Id
    @GeneratedValue
    private long id;

    private String impid;

    private String dislike_reason;
    private String image_urlss;

    @Transient
    private List<String> dislike_reasons;
    @Transient
    private List<String> image_urls;
    @Transient
    private int like;

    private int likes;

    private String ctype;
    private String pageid;
    private String title;
    private int dtype;
    private int display_flag;
    private int title_sn;
    private int comment_count;
    private int up;


    private String meta;
    private String source;
    private String content_type;
    private String url;
    private String category;
    private String image;

    private boolean feedback_forbidden;
    private boolean b_political;
    private boolean auth;
    private boolean is_gov;

    private String summary;
    private String date;
    private String docid;
    private String itemid;


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

    public String getDislike_reason() {
        return dislike_reason;
    }

    public void setDislike_reason() {
        if (getDislike_reasons() != null && !getDislike_reasons().isEmpty()) {
            this.dislike_reason = getDislike_reasons().toString();
        }
    }

    public List<String> getDislike_reasons() {
        return dislike_reasons;
    }

    public void setDislike_reasons(List<String> dislike_reasons) {
        this.dislike_reasons = dislike_reasons;
    }

    public void setDislike_reason(String dislike_reason) {
        this.dislike_reason = dislike_reason;
    }

    public String getImage_urlss() {
        return image_urlss;
    }

    public void setImage_urlss() {
        if (getImage_urls() != null && !getImage_urls().isEmpty()) {
            this.image_urlss = getImage_urls().toString();
        }

    }

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }

    public int getDisplay_flag() {
        return display_flag;
    }

    public void setDisplay_flag(int display_flag) {
        this.display_flag = display_flag;
    }

    public int getTitle_sn() {
        return title_sn;
    }

    public void setTitle_sn(int title_sn) {
        this.title_sn = title_sn;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes() {
        this.likes = this.like;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFeedback_forbidden() {
        return feedback_forbidden;
    }

    public void setFeedback_forbidden(boolean feedback_forbidden) {
        this.feedback_forbidden = feedback_forbidden;
    }

    public boolean isB_political() {
        return b_political;
    }

    public void setB_political(boolean b_political) {
        this.b_political = b_political;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public boolean isIs_gov() {
        return is_gov;
    }

    public void setIs_gov(boolean is_gov) {
        this.is_gov = is_gov;
    }

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }
}
