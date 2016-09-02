package actors;


import akka.actor.Props;
import akka.actor.UntypedActor;
import com.alibaba.fastjson.JSON;
import com.avaje.ebean.Ebean;
import models.Blog;

public class BlogActor extends UntypedActor {

    public static Props props = Props.create(BlogActor.class);

    public void onReceive(Object blogId) throws Exception {
        Blog blog = Ebean.find(Blog.class, blogId);
        System.out.println(JSON.toJSON(blog));
        sender().tell(blog, self());
    }
}
