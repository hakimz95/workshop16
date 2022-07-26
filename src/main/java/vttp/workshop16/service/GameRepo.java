package vttp.workshop16.service;

import jakarta.json.JsonObject;
import vttp.workshop16.model.BoardService;

public interface GameRepo {
    public void save(JsonObject body);

    public void findBoardId(String boardId);
}
