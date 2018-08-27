package pl.coderslab.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.validator.LoginValidator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(groups = LoginValidator.class)
    private String username;
    @NotEmpty(groups = {LoginValidator.class, Default.class})
    private String password;
    @NotEmpty
    @Column(unique = true)
    @Email(groups = {LoginValidator.class, Default.class})
    private String email;
    private boolean enabled=false;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Tweet> tweets = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(mappedBy = "sender")
    private List<Message> senderMessages = new ArrayList<>();
    @OneToMany(mappedBy = "receiver")
    private List<Message> receiverMessages = new ArrayList<>();

    public User() {
    }

    public List<Message> getSenderMessages() {
        return senderMessages;
    }

    public void setSenderMessages(List<Message> senderMessages) {
        this.senderMessages = senderMessages;
    }

    public List<Message> getReceiverMessages() {
        return receiverMessages;
    }

    public void setReceiverMessages(List<Message> receiverMessages) {
        this.receiverMessages = receiverMessages;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
