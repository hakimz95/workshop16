package vttp.workshop16.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import vttp.workshop16.model.BoardService;

public class GameRedis implements GameRepo {
    private static final Logger logger = LoggerFactory.getLogger(GameRedis.class);

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(final BoardService bs) {
        redisTemplate.opsForHash().put("name", bs.getName(), bs);

    }

    @Override
    public BoardService findById(final String boardId) {
        String name = (String) redisTemplate.opsForHash().get(boardId, "name");
        logger.info(">>> name " + name);
        
        BoardService bs = new BoardService();
        bs.setName(name);
        return bs;
    }
}
