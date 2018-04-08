package com.doc.xushi.entity.po;

import java.io.Serializable;

/**
 * Created by 5000 on 2018/4/6.
 */
public class AddressPo implements Serializable {

    private static final long serialVersionUID = 8498192202791565447L;

    private Long addressId;

    private Long userId;

    private String name;

    private String address;

    private String phone;

    private Integer isDefault;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
