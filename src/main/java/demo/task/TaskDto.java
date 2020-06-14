package demo.task;

import lombok.Data;

@Data
public class TaskDto {

    private int id;
    private String name;

    public TaskDto(int id, String name){
      this.id = id;
      this.name = name;
    }
}
