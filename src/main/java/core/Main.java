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
        if (ldt().isAfter(time.get(6))){
            num = 6;
        }
        return num;
    }
    protected enum schedule{
        ProjectN,
        BasicProgram,
        英語_英作文,
        英語_多読,
        中国語_会話,
        中国語_文法,
        プログラミング,
        大学受験_中学復習,
        進路学習,
        放課後,
    }

    static String curriculum(int num){
        String A = "";

        List<String> basic = new ArrayList<>();
        basic.add(schedule.ProjectN.toString());
        basic.add(schedule.ProjectN.toString());
        basic.add(schedule.BasicProgram.toString());
        int dow = ldt().getDayOfWeek().getValue();
        switch (dow){
            case 1:
                List<String> mon = new ArrayList<>();
                mon.add(schedule.英語_英作文.toString());
                mon.add(schedule.英語_多読.toString());
                mon.add(schedule.プログラミング.toString());
                mon.add(schedule.放課後.toString());
                basic.addAll(mon);
                A = basic.get(num);
                break;
            case 2:
                List<String> tue = new ArrayList<>();
                tue.add(schedule.中国語_会話.toString() + "/" + schedule.英語_英作文);
                tue.add(schedule.中国語_会話.toString() + "/" + schedule.プログラミング);
                tue.add(schedule.大学受験_中学復習.toString());
                tue.add(schedule.放課後.toString());
                basic.addAll(tue);
                A = basic.get(num);
                break;
            case 3:
                List<String> wed = new ArrayList<>();
                for (int i=0; i<3; i++){
                    wed.add(schedule.大学受験_中学復習.toString());
                }
                wed.add(schedule.放課後.toString());
                basic.addAll(wed);
                A = basic.get(num);
                break;
            case 4:
                List<String> thu = new ArrayList<>();
                thu.add(schedule.大学受験_中学復習.toString() + "/" + schedule.BasicProgram);
                thu.add(schedule.英語_英作文.toString());
                thu.add(schedule.プログラミング.toString());
                thu.add(schedule.放課後.toString());
                basic.addAll(thu);
                A = basic.get(num);
                break;
            case 5:
                List<String> fri = new ArrayList<>();
                for (int i=0; i<2; i++){
                    fri.add(schedule.中国語_文法.toString() + "/" + schedule.プログラミング);
                }
                fri.add(schedule.進路学習.toString());
                fri.add(schedule.放課後.toString());
                basic.addAll(fri);
                A = basic.get(num);
                break;
        }
        return A;
    }
}