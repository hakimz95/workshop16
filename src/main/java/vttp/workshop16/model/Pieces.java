
package vttp.workshop16.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rulebook",
    "board",
    "discs"
})
@Generated("jsonschema2pojo")
public class Pieces {

    @JsonProperty("rulebook")
    private Rulebook rulebook;
    @JsonProperty("board")
    private Board board;
    @JsonProperty("discs")
    private Discs discs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("rulebook")
    public Rulebook getRulebook() {
        return rulebook;
    }

    @JsonProperty("rulebook")
    public void setRulebook(Rulebook rulebook) {
        this.rulebook = rulebook;
    }

    @JsonProperty("board")
    public Board getBoard() {
        return board;
    }

    @JsonProperty("board")
    public void setBoard(Board board) {
        this.board = board;
    }

    @JsonProperty("discs")
    public Discs getDiscs() {
        return discs;
    }

    @JsonProperty("discs")
    public void setDiscs(Discs discs) {
        this.discs = discs;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
