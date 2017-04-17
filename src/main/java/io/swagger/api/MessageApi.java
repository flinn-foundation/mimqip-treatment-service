package io.swagger.api;

import io.swagger.model.MessageDto;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-04-17T15:18:43.957-04:00")

@Api(value = "Message", description = "the Message API")
public interface MessageApi {

    @ApiOperation(value = "Get messages by patientId", notes = "Get messages by patientId", response = MessageDto.class, responseContainer = "List", tags={ "message", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Array of messages", response = MessageDto.class) })
    @RequestMapping(value = "/messages",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<MessageDto>> getMessages( @NotNull @ApiParam(value = "Id of patient messages to fetch", required = true) @RequestParam(value = "patientId", required = true) Long patientId) {
        // do some magic!
        return new ResponseEntity<List<MessageDto>>(HttpStatus.OK);
    }

}
