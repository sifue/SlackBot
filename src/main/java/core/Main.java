package core;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import static core.Bot.bot;

public class Main {

    public static void main(String args[]) throws IOException {
        System.out.println(curriculum(time()));
        System.out.println(time());
        bot();
    }

    static LocalDateTime ldt(){
        return LocalDateTime.now();
    }

    static int time(){
        int year = ldt().getYear();
        int month = ldt().getMonth().getValue();
        int dayofmonth = ldt().getDayOfMonth();
        int n = 0;

        List<LocalDateTime> time = new ArrayList<>();
        time.add((LocalDateTime.of(year,month,dayofmonth,9,45)));
        for (int i=0; i<7; i++){
            time.add(time.get(n).plusMinutes(60));
            n++;
            if (i==2){
                time.add(LocalDateTime.of(year,month,dayofmonth,13,15));
                n++;
            }
        }
        int num = 0;
        int x = 0;
        int y = 1;

        for (int i=0; i<8; i++){
            if (ldt().isAfter(time.get(x)) && ldt().isBefore(time.get(y))){
                num = i;
                break;
            }else{
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
        String BR ="放課後";
        String A = "";

        List<String> basic = new ArrayList<>();
        basic.add(PN);
        basic.add(PN);
        basic.add(BP);
        int dow = ldt().getDayOfWeek().getValue();
        switch (dow){
            case 1:
                List<String> mon = new ArrayList<>();
                mon.add(EN);
                mon.add(EN);
                mon.add(PR);
                mon.add(BR);
                basic.addAll(mon);
                A = basic.get(num);
                break;
            case 2:
                List<String> tue = new ArrayList<>();
                tue.add(CN + "/" + EN);
                tue.add(CN + "/" + PR);
                tue.add(UJ);
                tue.add(BR);
                basic.addAll(tue);
                A = basic.get(num);
                break;
            case 3:
                List<String> wed = new ArrayList<>();
                for (int i=0; i<3; i++){
                    wed.add(UJ);
                }
                wed.add(BR);
                basic.addAll(wed);
                A = basic.get(num);
                break;
            case 4:
                List<String> thu = new ArrayList<>();
                thu.add(UJ + "/" + BP);
                thu.add(EN);
                thu.add(PR);
                thu.add(BR);
                basic.addAll(thu);
                A = basic.get(num);
                break;
            case 5:
                List<String> fri = new ArrayList<>();
                for (int i=0; i<2; i++){
                    fri.add(CN + "/" + PR);
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