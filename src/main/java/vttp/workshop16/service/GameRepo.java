package vttp.workshop16.service;

import vttp.workshop16.model.BoardService;

public class GameRepo {
    public void save(final BoardService bs);

    public BoardService findById(final String boardId);
}
