package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Fruit;
import com.atguigu.admin.mapper.FruitMapper;
import com.atguigu.admin.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date:2022/2/27 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    FruitMapper fruitMapper;
    public Fruit getFruitById(Integer fid){
        return fruitMapper.getFruitById(fid);
    }
}
