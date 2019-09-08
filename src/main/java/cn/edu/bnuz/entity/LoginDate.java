package cn.edu.bnuz.entity;

import java.util.Date;

public class LoginDate {
    private Long loginDateId;
    private Date createTime;
    private Long userId;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getLoginDateId() {
        return loginDateId;
    }

    public void setLoginDateId(Long loginDateId) {
        this.loginDateId = loginDateId;
    }
}
