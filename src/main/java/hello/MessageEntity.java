package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String message;
    private Long senderId;
    private Long recipientId;
    private Long companyId;
    private boolean read;

    protected MessageEntity() {}

    public MessageEntity(String message){
        this.message = message;
    }

    @Override
    public String toString(){
        return String.format(
                "MessageEntity[id=%d, message='%s']",
                id, message);
    }

    public void setMessage(Long senderId, Long recipientId, String message) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.message = message;
    }
}
