package core;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static core.Bot.bot;


public class Main {
    private static LocalDateTime ldt = LocalDateTime.now();

    public static void main(String args[]) throws IOException {
        System.out.println(curriculum(time()));
        bot();
    }
    static int time(){
        int year = ldt.getYear();
        int month = ldt.getMonth().getValue();
        int dayofmonth = ldt.getDayOfMonth();
        int n = 0;

        List<LocalDateTime> nexttime = new ArrayList<>();
        nexttime.add((LocalDateTime.of(year,month,dayofmonth,9,45)));
        for (int i=0; i<7; i++){
            nexttime.add(nexttime.get(n).plusMinutes(60));
            n++;
            if (i==3){
                nexttime.add(LocalDateTime.of(year,month,dayofmonth,13,15));
                n++;
            }
        }
        int num = 0;
        int x = 0;
        int y = 1;

        for (int i=0; i<7; i++) {
            if (ldt.isAfter(nexttime.get(x)) && ldt.isBefore(nexttime.get(y))) {
                num = i;
                break;
            } else {
                x++;
                y++;
            }
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
        String A = "";

        List<String> basic = new ArrayList<>();
        basic.add(PN);
        basic.add(PN);
        basic.add(BP);
        num++;
        int dow = ldt.getDayOfWeek().getValue();
        switch (dow){
            case 1:
                List<String> mon = new ArrayList<>();
                mon.add(EN);
                mon.add(EN);
                mon.add(PR);
                basic.addAll(mon);
                A = basic.get(num);
                break;
            case 2:
                List<String> tue = new ArrayList<>();
                tue.add(CN + "/" + EN);
                tue.add(CN + "/" + PR);
                tue.add(UJ);
                basic.addAll(tue);
                A = basic.get(num);
                break;
            case 3:
                List<String> wed = new ArrayList<>();
                for (int i=0; i<3; i++){
                    wed.add(UJ);
            }
                basic.addAll(wed);
                A = basic.get(num);
                break;
            case 4:
                List<String> thu = new ArrayList<>();
                thu.add(UJ + "/" + BP);
                thu.add(EN);
                thu.add(PR);
                basic.addAll(thu);
                A = basic.get(num);
                break;
            case 5:
                List<String> fri = new ArrayList<>();
                for (int i=0; i<2; i++){
                    fri.add(CN + "/" + PR);
                }
                fri.add(SN);
                basic.addAll(fri);
                A = basic.get(num);
                break;

        }
        return A;
    }
}