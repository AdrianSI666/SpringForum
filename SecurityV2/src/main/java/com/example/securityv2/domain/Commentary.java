package com.example.securityv2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="commentary", schema = "public")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(columnDefinition="TEXT")
    @Lob
    private String content;

    private int rate;
    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    private byte[] attachment;


    public Commentary(String content, Train train, User user) {
        this.content = content;
        this.rate = 0;
        this.train = train;
        this.user = user;
        this.attachment=new byte[0];
    }

    public Commentary(String content, Train train, User user, byte[] attachment) {
        this.content = content;
        this.rate = 0;
        this.train = train;
        this.user = user;
        this.attachment = attachment;
    }

    @Override
    public String toString() {
        return "Commentary{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", rate=" + rate +
                ", attachment=" + Arrays.toString(attachment) +
                '}';
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
