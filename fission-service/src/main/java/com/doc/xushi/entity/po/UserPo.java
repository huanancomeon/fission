package com.doc.xushi.entity.po;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/6.
 */
public class UserPo implements Serializable {

    private static final long serialVersionUID = 618807716048630001L;

    private Long userId;

    private String openUserId;

    private Long score;

    private Long supUserId;

    private String channel;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOpenUserId() {
        return openUserId;
    }

    public void setOpenUserId(String openUserId) {
        this.openUserId = openUserId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getSupUserId() {
        return supUserId;
    }

    public void setSupUserId(Long supUserId) {
        this.supUserId = supUserId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
