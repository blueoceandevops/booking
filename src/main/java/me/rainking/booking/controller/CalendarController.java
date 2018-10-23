package me.rainking.booking.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import me.rainking.booking.viewmodel.BookRecordViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 *
 * @author Rain
 */
@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String showCalendar(){
        return "calendar";
    }

    @GetMapping("/getJson")
    @ResponseBody
    public BookRecordViewModel getJson()
    {
        BookRecordViewModel bookRecordViewModel = new BookRecordViewModel();
        bookRecordViewModel.setTitle("hello");
        bookRecordViewModel.setStart(new Date());

        return bookRecordViewModel;
    }


}
