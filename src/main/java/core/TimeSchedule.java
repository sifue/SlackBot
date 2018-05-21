package core;

import groovy.json.internal.IO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import static core.Main.start;

class TimeSchedule {
    static void task() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Timer timer = new Timer(false);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(timerTask,sdf.parse("13:20"));
    }
}