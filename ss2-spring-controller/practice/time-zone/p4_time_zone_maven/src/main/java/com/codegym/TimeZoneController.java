package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class TimeZoneController {
    @GetMapping("/world-clock")
    public String getTimeByTimeZone(ModelMap model, @RequestParam(required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Lấy ra thời gian hiện tại
        Date date = new Date();
        // Lấy ra time zone hiện tại
        TimeZone local = TimeZone.getDefault();
        // Lấy ra time zone của 1 thành phố cụ thể
        TimeZone locale = TimeZone.getTimeZone(city);
        // Tính thời gian hiện tại của 1 thành phố cụ thể
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Cài đặt lại thời gian cho biến date thành thời gian hiện tại của 1 thành phố cụ thể
        date.setTime(locale_time);
        //Chuyển dữ liệu và gửi qua view
        Map<String, String> attributes = new HashMap<>();
        attributes.put("city", city);
        attributes.put("date", String.valueOf(date));
        model.addAllAttributes(attributes);
        return "time";
    }
}
