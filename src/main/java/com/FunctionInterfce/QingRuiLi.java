package com.FunctionInterfce;
@FunctionalInterface
public interface QingRuiLi {
    void selectData();

    default void insertData(){

    }
    static void deleteData(){

    }
    boolean equals(Object obj);
}
