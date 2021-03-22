package response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class AddBookResponse {
    @JsonProperty("Msg")
    private String Msg;

    private String ID;

    public String getMsg() {
        return Msg;
    }



    @JsonSetter("msg")
    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getID() {
        return ID;
    }

    @JsonSetter("id")
    public void setId(String ID) {
        this.ID= ID;
    }
}
