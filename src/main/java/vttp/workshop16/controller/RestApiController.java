package vttp.workshop16.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import vttp.workshop16.model.*;
import vttp.workshop16.service.GameRedis;

@RestController
@RequestMapping(path="/api/boardgame")
public class RestApiController {
    @Autowired
    private BoardService bg;

    @Autowired
    GameRedis service;
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> postUser(@RequestBody String payload) {
        JsonObject body;
        URI location;

        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader reader = Json.createReader(is);
            body = reader.readObject ();
            location = new URI("http://localhost:8080/api/boardgame");
            service.save(body);
            JsonObject response = Json.createObjectBuilder()
                                    .add("firstName", "User")
                                    .build();
            return ResponseEntity.created(location).body(response.toString());
        } catch (Exception ex) {
            body = Json.createObjectBuilder().add("error", ex.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
    }

    @GetMapping (path = "{boardgameId}")
    public ResponseEntity<String> getUser(@PathVariable(name = "boardgameId")String boardId){
        //final Board board = (Board) bg.getName(boardId);

        bg.getName(boardId);

        final JsonObject resp = Json.createObjectBuilder()
                .add("game", bg.getName())
                .build();

                return ResponseEntity.ok(resp.toString());
    }

    @PutMapping (path="{boardgameId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> updateBoardId(@PathVariable(name = "boardgameId")String boardId, @RequestBody String payload){
        return null;
        
    }

}
