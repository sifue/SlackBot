package core;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import java.io.IOException;
import java.util.ResourceBundle;

import static core.Main.*;

class Bot{
    static void bot() throws IOException{
        String token = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");
        SlackletService slack = new SlackletService(token);
        ldt();
        int n = time();
        n++;
        String num = Integer.toString(n);
        slack.addSlacklet(new Slacklet(){
            @Override
            public void onMentionedMessagePosted(SlackletRequest req,SlackletResponse resp){
                String mention = req.getUserDisp();
                if (time()==6){
                    resp.reply(mention + "さん、放課後です！" );
                } else {
                    resp.reply(mention + "さん、" + num + "時間目の授業は" + curriculum(time()) + "です");
                }
            }
        });
        slack.start();
    }
}
