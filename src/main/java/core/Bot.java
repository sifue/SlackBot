package core;

import org.riversun.slacklet.SlackletService;
import java.io.IOException;
import static core.Main.curriculum;
import static core.Main.time;

class Bot {
    static void bot() throws IOException {
        String token = "xoxb-364954023541-364589880980-bANhlnH5Xb5j60papLcslKyA";
        String Channel = "general";
        SlackletService slack = new SlackletService(token);
        slack.start();
        slack.sendMessageTo(Channel,curriculum(time()));
        slack.stop();

    }
}
