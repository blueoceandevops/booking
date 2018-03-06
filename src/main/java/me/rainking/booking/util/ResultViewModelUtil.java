package me.rainking.booking.util;

import me.rainking.booking.viewmodel.ResultViewModel;

/**
 * @author Rain
 */
public class ResultViewModelUtil {

    public static ResultViewModel success(Object object) {

        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.setData(object);
        resultViewModel.setCode(0);
        resultViewModel.setMsg("成功");

        return resultViewModel;
    }

    public static ResultViewModel success() {
        return success(null);
    }

    public static ResultViewModel error(Integer code, String msg) {

        ResultViewModel resultViewModel = new ResultViewModel();
        resultViewModel.setCode(code);
        resultViewModel.setMsg(msg);

        return resultViewModel;
    }
}
