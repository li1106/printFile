package com.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName PersonBean
 * @Description TODO
 * @Author Administrator
 * @Date 2020/6/3 17:34
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonBean implements Serializable {
    private String name;
    private Integer age;
}
