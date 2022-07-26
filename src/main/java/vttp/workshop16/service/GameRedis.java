package vttp.workshop16.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;
import vttp.workshop16.model.BoardService;

@Service
public class GameRedis implements GameRepo {
    private static final Logger logger = LoggerFactory.getLogger(GameRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(JsonObject body) {
        redisTemplate.opsForValue().set("boardgame", body.toString());
    }

    @Override
    public void findBoardId(String boardId) {
        String game = (String)redisTemplate.opsForValue().get(boardId);
        System.out.println(game);
    }
}
