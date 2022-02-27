package com.atguigu.admin.bean;

import lombok.Data;

/**
 * @date:2022/2/27 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
@Data
public class Fruit {
    private Integer fid;
    private String fname;
    private Integer price;
    private Integer fcount;
    private String remark;
}
