package core;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

import static core.Bot.bot;
import static core.TimeSchedule.*;

public class Main {
    private static LocalDateTime ldt = LocalDateTime.now();

    public static void main(String args[]) throws ParseException {
        task();
    }
    static void start() throws IOException{
        bot();
    }

    static int time(){
        int year = ldt.getYear();
        int month = ldt.getMonth().getValue();
        int dayofmonth = ldt.getDayOfMonth();
        int n = 0;
        int num = 0;

        List<LocalDateTime> time = new ArrayList<>();
        time.add(LocalDateTime.of(year,month,dayofmonth,9,45));
        for (int i=0; i<5; i++){
            time.add(time.get(n).plusMinutes(50));
            n++;
            time.add(time.get(n).plusMinutes(10));
            n++;
            if (i==3){
                time.add(time.get(5).plusMinutes(40));
                n++;
            }
        }
        if (ldt.isAfter(time.get(0)) && ldt.isBefore(time.get(1))){
            num = 1;
        } else if (ldt.isAfter(time.get(1)) && ldt.isBefore(time.get(2))){
            num = 2;
        } else if (ldt.isAfter(time.get(2)) && ldt.isBefore(time.get(3))){
            num = 3;
        } else if (ldt.isAfter(time.get(3)) && ldt.isBefore(time.get(4))){
            num = 4;
        } else if (ldt.isAfter(time.get(4)) && ldt.isBefore(time.get(5))){
            num = 5;
        } else if (ldt.isAfter(time.get(5)) && ldt.isBefore(time.get(6))){
            num = 6;
        } else if (ldt.isAfter(time.get(6)) && ldt.isBefore(time.get(7))){
            num = 7;
        } else if (ldt.isAfter(time.get(7)) && ldt.isBefore(time.get(8))){
            num = 8;
        } else if (ldt.isAfter(time.get(8)) && ldt.isBefore(time.get(9))){
            num = 9;
        } else if (ldt.isAfter(time.get(9)) && ldt.isBefore(time.get(10))){
            num = 10;
        } else if (ldt.isAfter(time.get(10)) && ldt.isBefore(time.get(11))){
            num = 11;
        } else if (ldt.isAfter(time.get(11)) && ldt.isBefore(time.get(12))){
            num = 12;
        }
        return num;
    }

    static String curriculum(int num){
        String PN ="ProjectN";
        String BP ="BasicProgram";
        String EN ="英語";
        String CN ="中国語";
        String PR ="プログラミング";
        String UJ ="大学受験/中学復習";
        String SN ="進路指導";
        String BR ="休憩";
        String A = "";

        List<String> basic = new ArrayList<>();
        for (int i=0; i<2; i++){
            basic.add(PN);
            basic.add(BR);
        }
        basic.add(BP);
        basic.add(BR);

        int dow = ldt.getDayOfWeek().getValue();
        int n = 0;
        switch (dow){
            case 1:
                List<String> mon = new ArrayList<>();
                mon.add(EN);
                mon.add(BR);
                mon.add(EN);
                mon.add(BR);
                mon.add(PR);
                mon.add(BR);
                basic.addAll(mon);
                A = basic.get(num);
                break;
            case 2:
                List<String> tue = new ArrayList<>();
                tue.add(CN+"/"+EN);
                tue.add(BR);
                tue.add(CN+"/"+PR);
                tue.add(BR);
                tue.add(UJ);
                tue.add(BR);
                basic.addAll(tue);
                A = basic.get(num);
                break;
            case 3:
                List<String> wed = new ArrayList<>();
                for (int i=0; i<3; i++){
                    wed.add(UJ+"/"+EN);
                    wed.add(BR);
                }
                basic.addAll(wed);
                A = basic.get(num);
                break;
            case 4:
                List<String> thu = new ArrayList<>();
                thu.add(UJ+"/"+BP);
                thu.add(BR);
                thu.add(EN);
                thu.add(BR);
                thu.add(PR);
                thu.add(BR);
                basic.addAll(thu);
                A = basic.get(num);
                break;
            case 5:
                List<String> fri = new ArrayList<>();
                for (int i=0; i<2; i++){
                    fri.add(CN+"/"+PR);
                    fri.add(BR);
                }
                fri.add(SN);
                fri.add(BR);
                basic.addAll(fri);
                A = basic.get(num);
                break;
        }
        return A;

    }
}