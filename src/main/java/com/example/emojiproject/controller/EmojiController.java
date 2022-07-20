package com.example.emojiproject.controller;

import com.example.emojiproject.model.Emoji;
import com.example.emojiproject.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmojiController {

    @Autowired
    private QueryService service;
    @GetMapping("/{anything}")
    public List<String> getEmoji(@PathVariable String anything)
    {
        List<Emoji> emojis = service.getemo(anything);
        List<String> emoji = new ArrayList<>();
        for (Emoji emoticon: emojis) {
            emoji.add(emoticon.getEmoji());
        }
        return emoji;
    }

    @PostMapping("/add/{indexName}")
    public String addEmojis(@PathVariable String indexName) throws IOException {
        service.writeAccounts(indexName);
        return "added";
    }
    @DeleteMapping("/delete/{indexName}")
    public String deleteIndex(@PathVariable String indexName) throws IOException {
        service.deleteIndex(indexName);
        return "Deleted";
    }
}
