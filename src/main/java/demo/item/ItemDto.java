package demo.item;

import lombok.Data;

@Data
public class ItemDto {

    private int id;
    private String name;

    public ItemDto(int id, String name){
      this.id = id;
      this.name = name;
    }
}
