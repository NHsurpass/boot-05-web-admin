package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date:2022/2/26 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;
    //以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
