package vttp.workshop16.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path="/api/boardgame")
public class RestApiController {
    @Autowired
    private BoardService bd;
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> postUser(@RequestBody String payload) {
        JsonObject body;
        try (InputStream is = new ByteArrayInputStream(payload.getBytes())) {
            JsonReader reader = Json.createReader(is);
            body = reader.readObject ();
        } catch (Exception ex) {
            body = Json.createObjectBuilder().add("error", ex.getMessage()).build();
            return ResponseEntity.internalServerError().body(body.toString());
        }
        return ResponseEntity.internalServerError().body(body.toString());
    }

    @GetMapping (path = "{boardgameId}")
    public ResponseEntity<String> getUser(@PathVariable(name = "boardgameId")String boardId){
        final Board board = bg.get(boardId);

        final JsonObject resp = Json.createObject()
                .add("game", board.getName())
                .build();

                return ResponseEntity.ok(resp.toString());
    }

}
