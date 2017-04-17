package org.flinnfoundation.mapper;

import io.swagger.model.MessageDto;
import org.flinnfoundation.model.Message;
import org.flinnfoundation.service.mimqip.mapper.OrikaMapper;
import org.springframework.stereotype.Component;


@Component
public class MessageMapper extends OrikaMapper<Message, MessageDto> {

    protected MessageMapper() {
        super(Message.class, MessageDto.class);
    }
}
