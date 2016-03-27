package com.regex;

/**
 * Created by lvyong on 2016/3/27.
 */
public enum EnumType {
    SQL_INJECT("sql注入","[^%&',;=?$\\x22]+"),
    EMAIL("邮箱", "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$"),
    PHONE("手机", "^1[3|4|5|8][0-9]\\d{8}$"),
    URL("URL", "^((http|https)://)?([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?$ "),
    ID_CARD("身份证", "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$"),
    FLOAT("float","^[0-9]+\\.{0,1}[0-9]+$"),
    FLOAT2("float2位","^[0-9]+\\.{0,1}[0-9]{0,2}$"),
    A_z("A到z","^[A-Za-z]+$"),
    A_Z("A到Z","^[A-Z]+$"),
    a_z("a到z","^[a-z]+$"),
    A_z_09("A-Za-z0-9","^[A-Za-z0-9]+$"),
    CHINA("中文","[\\u4e00-\\u9fa5]+"),
    INT("int","^[0-9]*$"),
    TIME("时间","^((((0?[0-9])|([1][0-9])|([2][0-4])):([0-5]?[0-9])((s)|(:([0-5]?[0-9])))))?$"),
    DATE("日期","^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))");

    // 成员变量
    private String name;
    private String value;
    private EnumType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    /**
     * 根据枚举值获取枚举名
     * @param value
     * @return
     */
    public static String getName(String value) {
        for (EnumType e : EnumType.values()) {
            if (e.getValue() == value) {
                return e.name;
            }
        }
        return null;
    }

    /**
     * 根据枚举名获取枚举值
     * @param name
     * @return
     */
    public static String getValue(String name) {
        for (EnumType e : EnumType.values()) {
            if (e.getName() == name) {
                return e.value;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.value;
    }
}
