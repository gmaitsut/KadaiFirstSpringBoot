package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {


    //仕様2：四則演算を行なう

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcminus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calctimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果：" + res;
    }


    //仕様1：指定日の曜日を算定する

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String disDayOfWeek(@PathVariable String yyyymmdd) {

        //指定日の年を切り取り
        String year = yyyymmdd.substring(0,4);

        //指定日の月を切り取り
        String month = yyyymmdd.substring(4,6);

        //指定日の日を切り取り
        String day = yyyymmdd.substring(6,8);

        //Stringから数値へ変換
        LocalDate localDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        //指定日の曜日を取得
        DayOfWeek dayofweek = localDate.getDayOfWeek();

        return "実行結果：" + dayofweek.getDisplayName(TextStyle.FULL, Locale.US) ;
    }


    }



