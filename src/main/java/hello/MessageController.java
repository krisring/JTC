package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path="/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path="/sendMessage")
    public @ResponseBody String sendMessage(@RequestParam Long senderId, @RequestParam Long recipientId, @RequestParam String message){
        MessageEntity messageEntity = new MessageEntity();
        CustomerEntity customerEntity = new CustomerEntity();
        Long senderCompanyId = customerEntity.getId();
        Long recipientCompanyId = customerEntity.getId();
        List<Long> senderCompanyRelations = customerEntity.getCustomerCompanyRelations(senderCompanyId);
        if(senderCompanyId.equals(recipientCompanyId)) {
            messageEntity.setMessage(senderId, recipientId, message);
            messageRepository.save(messageEntity);
            return "Message Sent. ";
        }else{
            if(senderCompanyRelations.contains(recipientCompanyId)){
                messageEntity.setMessage(senderId, recipientId, message);
                messageRepository.save(messageEntity);
                return "Message Sent. ";
            } else {
                return "Company relation not found. ";
            }
        }
        return "Message NOT Sent. ";
    }
}
