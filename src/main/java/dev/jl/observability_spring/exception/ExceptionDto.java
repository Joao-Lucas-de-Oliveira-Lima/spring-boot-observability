package dev.jl.observability_spring.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@JsonPropertyOrder(alphabetic = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String title;
    private String instance;
    private String detail;
    private Integer status;
    private Instant timestamp;
}
