package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Blog extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    @Size(max = 50)
    public String passwd;

    @Size(max = 1)
    public String sex;

    @Size(max = 20)
    public String phone;

    @Size(max = 255)
    public String email;

    @Temporal(TemporalType.DATE)
    public Date birthday;

    @Temporal(TemporalType.TIMESTAMP)
    public Date registerTime;

    @Lob
    @Size(max = 65535)
    @Column(columnDefinition = "text")
    public String descr;

    public boolean done;

    @Formats.DateTime(pattern="dd/MM/yyyy")
    public Date dueDate = new Date();

    public static Finder<Long, Blog> find = new Finder<Long,Blog>(Blog.class);
}
