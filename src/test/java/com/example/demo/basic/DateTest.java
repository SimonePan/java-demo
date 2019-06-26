package com.example.demo.basic;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/**
 * @author Grace.Pan
 * @date 2019/6/24
 */
public class DateTest {

    @Test
    public void format(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("KK:mma", Locale.ENGLISH);
        String startTime = dateTimeFormatter.format(LocalTime.of(10,52));
        Assert.assertEquals("10:52AM",startTime);
        System.out.println(dateTimeFormatter.format(LocalTime.now()));
    }

    @Test
    public void formatSimple(){
        SimpleDateFormat sd = new SimpleDateFormat("KK:mma", Locale.ENGLISH);
        String time = sd.format(new Date());
        System.out.println(time);
    }

}
