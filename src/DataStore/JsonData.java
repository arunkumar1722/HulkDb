package DataStore;

import org.json.simple.JSONObject;

import java.util.Date;
/**
 * The Value which is going to be stored in The [KeyValueDataStore]
 * */
public class JsonData {
    /** Supplied By User */
    private JSONObject jsonObject;

    /** Time to Live in seconds
     * Default  -1 Representing Infinite LifeTime.
     * Or Number in seconds to Live.
     * */
    private Long timeToLive;

    /** Date Created
     * */
    private Date dateCreated;


    JsonData(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        this.dateCreated =  new Date();
    }

    JsonData(JSONObject jsonObject, Long timeToLive) {
        this.jsonObject = jsonObject;
        this.timeToLive = timeToLive;
        this.dateCreated = new Date();
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Long getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
