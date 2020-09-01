package effectiveJava;

import org.omg.CORBA.INTERNAL;

/**
 * @author yuanxindong
 * @date 2020/8/30 11:22 下午
 */
public class Response<T> {
  public static Integer OK = 1;
  public static Integer FAILED = -1;
  private Integer code;
  private String message;
  private T data;

  public Response(String message) {
    this.message = message;
  }

  public static Response OK(String message,Object data) {
    Response response = new Response<>(message);
    response.setCode(OK);
    response.setData(data);
    return response;
  }

    public static Response failed(String message) {
        Response response = new Response<>(message);
        response.setCode(FAILED);
        return response;
    }
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
