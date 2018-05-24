package core;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import static core.Main.*;

class Bot{
    static void bot() throws IOException{
        ResourceBundle rb = ResourceBundle.getBundle("resource",UTF8_ENCODING_CONTROL);
        String token = ResourceBundle.getBundle("credentials").getString("slack.bot_api_token");
        SlackletService slack = new SlackletService(token);
        ldt();
        int n = time();
        n++;
        String num = Integer.toString(n);
        slack.addSlacklet(new Slacklet(){
            @Override
            public void onMentionedMessagePosted(SlackletRequest req,SlackletResponse resp){
                String san = rb.getString("san");
                String mention = req.getUserDisp();
                if (time()==6){
                    resp.reply(mention + san + rb.getString("after_school"));
                } else {
                    resp.reply(mention + san + num + rb.getString("time") + curriculum(time()) + rb.getString("desu"));
                }
            }
        });
        slack.start();
    }
    static ResourceBundle.Control UTF8_ENCODING_CONTROL = new ResourceBundle.Control(){
        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
            throws IOException{
            String resourceName = toResourceName(baseName, "properties");

            try (InputStream is = loader.getResourceAsStream(resourceName)){
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader reader = new BufferedReader(isr);
                return new PropertyResourceBundle(reader);
            }
        }
    };
}
