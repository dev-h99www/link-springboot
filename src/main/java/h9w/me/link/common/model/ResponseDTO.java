package h9w.me.link.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseDTO<D> {

    private boolean result;
    private String message;
    private D data;

    public static <D> ResponseDTO<D> setSuccess(String message, D data) {

        return new ResponseDTO(true, message, data);
    }

    public static <D> ResponseDTO<D> setFailed(String message) {
        return setFailed(message, null);
    }

    public static <D> ResponseDTO<D> setFailed(String message, D data) {
        return new ResponseDTO<D> (false, message, data);
    }
}
