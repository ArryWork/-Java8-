package WorkDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WorkDateUtil {
    private static List<Calendar> holidayList = new ArrayList<Calendar>();  //节假日列表
    public static String addDateByWorkDay(Calendar calendar,int day){

        try {
            for (int i = 0; i < day; i++) {

                calendar.add(Calendar.DAY_OF_MONTH, 1);

                if(checkHoliday(calendar)){
                    i--;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return  df.format(calendar.getTime());
    }
    public static boolean checkHoliday(Calendar calendar) throws Exception{

        //判断日期是否是周六周日
        if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            return true;
        }
        //判断日期是否是节假日
        for (Calendar ca : holidayList) {
            if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                    ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
                    ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        try {


            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Calendar ca = Calendar.getInstance();
            Date d = df.parse("2018-01-23");
            ca.setTime(d);//设置当前时间
            System.out.println(ca.get(Calendar.DAY_OF_WEEK));
            WorkDateUtil ct = new WorkDateUtil();
            String c = addDateByWorkDay(ca,5);
            System.out.println(c);

        } catch ( Exception e) {
            // TODO: handle exception

            e.printStackTrace();
        }
    }
}
