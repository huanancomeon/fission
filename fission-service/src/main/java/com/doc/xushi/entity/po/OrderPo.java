package com.doc.xushi.entity.po;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by 5000 on 2018/4/6.
 */
public class OrderPo implements Serializable {

    private static final long serialVersionUID = -5324988137231991642L;

    private Long orderId;

    private Long userId;

    private Long addressId;

    private String remark;

    private Long money;

    private String mailNo;

    private String mailCompary;

    private Integer status;

    private Date createTime;

    private Date updateTIme;

    private List<OrderGoodsPo> goodsList;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMailNo() {
        return mailNo;
    }

    public void setMailNo(String mailNo) {
        this.mailNo = mailNo;
    }

    public String getMailCompary() {
        return mailCompary;
    }

    public void setMailCompary(String mailCompary) {
        this.mailCompary = mailCompary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }

    public List<OrderGoodsPo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsPo> goodsList) {
        this.goodsList = goodsList;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
