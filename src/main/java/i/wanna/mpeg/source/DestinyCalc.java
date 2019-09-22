package i.wanna.mpeg.source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;

public enum DestinyCalc {
    CALC_WEATHER((day,inputDate) ->
    {
        String conver = calcDate(day, inputDate);
        Integer last = Integer.valueOf(conver.substring(conver.length() - 1));
        return last%4;
    }
    ),
    CALC_DESTINY((day,inputDate) ->
    {
        String conver = calcDate(day, inputDate);
        Integer last = Integer.valueOf(conver.substring(conver.length() - 2));
        return last%25;
    }
    ),
    CALC_PLACE_COLOR((day, inputDate) ->
    {
        String conver = calcDate(day, inputDate);
        Integer last = Integer.valueOf(conver.substring(conver.length() - 2));
        return last%25;
    }
    ),
    CALC_NUMBER((day,inputDate) ->
    {
        String conver = calcDate(day, inputDate);
        Integer last = Integer.valueOf(conver.substring(conver.length() - 2));
        return (last%45)+1;
    }
    );
    private BiFunction<String, LocalDateTime,Integer> expression;

    DestinyCalc(BiFunction<String, LocalDateTime, Integer> expression) { this.expression = expression;}

    public Integer calculate(String value, LocalDateTime date) {
        return expression.apply(value, date);
    }

    private static String calcDate(String  day, LocalDateTime inputDate){
        String day_year_month_day [] = day.split("/");
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatter = formmat1.format(inputDate);
        String input_year_month_day [] = formatter.split("/");
        Integer day_int = 0;
        Integer input_int = 0;
        day_int = Integer.valueOf(day_year_month_day[0]) * Integer.valueOf(day_year_month_day[1]+day_year_month_day[2]);
        input_int = Integer.valueOf(input_year_month_day[0]) + Integer.valueOf(input_year_month_day[1]+input_year_month_day[2]);
        Integer result = (day_int + input_int) / Integer.parseInt(input_year_month_day[2]);
        return String.valueOf(result);
    }


}