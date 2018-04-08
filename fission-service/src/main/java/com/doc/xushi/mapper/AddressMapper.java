package com.doc.xushi.mapper;

import com.doc.xushi.entity.po.AddressPo;
import com.doc.xushi.entity.vo.PageVo;

import java.util.List;

/**
 * Created by 5000 on 2018/4/6.
 */
public interface AddressMapper {

    AddressPo addUserAddress(AddressPo address);

    int updateUserAddress(AddressPo address);

    int updateNoDefault(Long userId);

    List<AddressPo> getAddressList(PageVo pageVo);

}
