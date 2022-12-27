package co.pragra.learning.librarymgmt.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
public class ErrorResponse {
    private int errorCode;
    private String appID;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:SSS")
    private Date dateTime;
    private String message;
}
