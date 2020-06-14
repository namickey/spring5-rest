package demo.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    List<TaskDto> list = new ArrayList<>();

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskDto> tasks() {
        return list;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public Object createTask(@Valid @RequestBody TaskForm taskForm, BindingResult result) {

        if(result.hasErrors()){
            return result.getFieldError();
        }

        TaskDto taskDto = new TaskDto(list.size(), taskForm.getName());
        list.add(taskDto);
        return taskDto;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public Object deleteTask(@PathVariable("id") int id) {
        for (TaskDto task: list) {
            if (task.getId() == id) {
                list.remove(task);
                return task;
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
