package mvc;

import java.io.Serializable;

/**
 * @author: lucheng
 * @data: 2021/7/26 14:44
 * @version: 1.0
 */
public class WebResult<S> implements Serializable {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 500;
    private Status state;
    private Long timestamp = System.currentTimeMillis();
    private S data;

    public static<S> WebResult<S> response(Status state, S data) {
        WebResult<S> webResp = new WebResult();
        webResp.setState(state);
        webResp.setData(data);
        return webResp;
    }

    public static <S> WebResult<S> success(S data, Integer code, String message) {
        return response(Status.generate(code, message), data);
    }

    public static <S> WebResult<S> success() {
        return success(null, SUCCESS, (String)null);
    }

    public static <S> WebResult<S> successData(S data) {
        return success(data, SUCCESS, (String) null);
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public S getData() {
        return data;
    }

    public void setData(S data) {
        this.data = data;
    }

    public static Integer getSUCCESS() {
        return SUCCESS;
    }

    public static Integer getERROR() {
        return ERROR;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }
}
