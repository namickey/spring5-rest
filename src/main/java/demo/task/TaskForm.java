package demo.task;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class TaskForm {

    @NotEmpty
    @Size(max = 10)
    private String name;

}
