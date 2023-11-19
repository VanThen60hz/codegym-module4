package com.codegym.question.dto;

import com.codegym.question.model.Type;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.codegym.question.model.Question}
 */
@Value
public class QuestionDto implements Serializable {
    Integer id;
    @Size(message = "Tiêu đề không đúng độ dài quy định",min = 5,max = 100)
    String title;
    @Size(message = "Nội dung không đúng độ dài quy định",min = 5,max = 100)
    String content;
    Type type;
    String answer;
}