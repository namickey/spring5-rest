package demo.item;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ItemController {

    List<ItemDto> list = new ArrayList<>();

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<ItemDto> items() {
        return list;
    }

    @RequestMapping(value = "/item/{name}", method = RequestMethod.GET)
    public Object createItem(@PathVariable("name") String name) {
      ItemDto itemDto = new ItemDto(list.size(), name);
      list.add(itemDto);
      return itemDto;
    }

    @RequestMapping(value = "/item/delete/{id}", method = RequestMethod.GET)
    public Object deleteItem(@PathVariable("id") int id) {
        for (ItemDto item: list) {
            if (item.getId() == id) {
                list.remove(item);
                return item;
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
