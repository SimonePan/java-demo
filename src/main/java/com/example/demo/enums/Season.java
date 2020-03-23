package com.example.demo.enums;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * enum实际继承了 java.lang.Eunm
 *
 * @author Grace.Pan
 * @date 2019/6/18
 */
public enum Season {
    SPRING("春天", 0), SUMMER("夏天", 1), AUTUMN("球天", 2), WINTER("冬天", 3);

    private String name;
    private int code;

    Season(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        //以数组形式返回枚举类的所有成员
        Season[] values = Season.values();
        //根据字符串转换成枚举实例
        Season spring = Season.valueOf("SPRING");
        //根据字符串转换成枚举实例
        Season spr = Enum.valueOf(Season.class, "SPRING");
        System.out.println(values.toString() + values[0].name);
        System.out.println(spring.name + spr.toString());
        System.out.println(spr.name + spr.toString());

        EnumSet<Season> seasons = EnumSet.allOf(Season.class);
        seasons.forEach(season -> System.out.println(season));

        EnumMap<Season, String> stringEnumMap = new EnumMap<Season, String>(Season.class);
        stringEnumMap.put(Season.SPRING, "S");
        stringEnumMap.put(Season.WINTER, "W");
        System.out.println(stringEnumMap.get(Season.SPRING));
    }
}
