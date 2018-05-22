package core;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import java.io.IOException;
import java.util.ResourceBundle;

import static core.Main.curriculum;
import static core.Main.time;

class Bot {
    static void bot() throws IOException {
        String token = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");
        SlackletService slack = new SlackletService(token);
        slack.addSlacklet(new Slacklet(){
            @Override
            public void onMentionedMessagePosted(SlackletRequest req,SlackletResponse resp){
                String mention = req.getUserDisp();
                resp.reply(mention + "さん、次の授業は" + curriculum(time()) + "です");
            }

        });
        slack.start();


    }
}
