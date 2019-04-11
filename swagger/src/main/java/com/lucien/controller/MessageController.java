
package com.lucien.controller;

import java.util.List;

import com.lucien.config.BaseResult;
import com.lucien.model.Message;
import com.lucien.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@Api(value = "message", description = "message operation API", position = 100, protocols = "http")
@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @ApiOperation(
        value = "message list",
        notes = "complete message content list",
        produces = "application/json, application/xml",
        consumes = "application/json, application/xml",
        response = List.class
    )
    @GetMapping(value = "messages")
    public List<Message> list() {
        List<Message> messages = this.messageRepository.findAll();
        return messages;
    }

    @ApiOperation(
        value = "add message", 
        notes = "create message based on params"
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "id", value = "message ID", required = true, dataType = "Long", paramType = "query"),
        @ApiImplicitParam(name = "text", value = "content", required = true, dataType = "String", paramType = "query"),
        @ApiImplicitParam(name = "summary", value = "summary", required = false, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = "message")
    public Message create(Message message) {
        message = this.messageRepository.save(message);
        return message;
    }
    
    @ApiOperation(
        value = "modify message",
        notes = "modify message based on params"
    )
    @PutMapping(value = "message")
    @ApiResponses({
        @ApiResponse(code = 100, message = "Continue"),
        @ApiResponse(code = 101, message = "Switching protocol"),
        @ApiResponse(code = 102, message = "Processing"),
        @ApiResponse(code = 103, message = "Early hints"),
        @ApiResponse(code = 200, message = "OK")
    })
    public Message modify(Message message) {
        Message messageResult = this.messageRepository.update(message);
        return messageResult;
    }

    // updateText
    @PatchMapping(value = "message/text")
    public BaseResult<Message> patch(Message message) {
        Message messageResult = this.messageRepository.updateText(message);
        return BaseResult.successWithData(messageResult);
    }

    // findMessage
    @GetMapping(value = "message/{id}")
    public Message get(@PathVariable Long id) {
        Message message = this.messageRepository.findMessage(id);
        return message;
    }

    // deleteMessage
    @DeleteMapping(value = "message/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.messageRepository.deleteMessage(id);
    }
}
