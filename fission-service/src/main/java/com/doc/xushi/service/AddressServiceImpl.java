package com.doc.xushi.service;

import com.alibaba.fastjson.JSON;
import com.doc.xushi.entity.po.AddressPo;
import com.doc.xushi.mapper.AddressMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    AddressMapper addressMapper;


    @Transactional(rollbackFor = Exception.class)
    public void addUserAddress(AddressPo addressPo) throws Exception {

        if (addressPo == null || addressPo.getUserId() == null) {
            LOGGER.error("Add Address Paramer Error:{}", JSON.toJSONString(addressPo));
            throw new Exception("Add Address Paramer Error");
        }

        if (addressPo.getIsDefault() > 0) {
            addressMapper.updateNoDefault(addressPo.getUserId());
        }

        addressMapper.addUserAddress(addressPo);

    }
}
