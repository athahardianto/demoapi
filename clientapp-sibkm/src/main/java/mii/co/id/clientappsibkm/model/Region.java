package mii.co.id.clientappsibkm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region{
    public Region(Region region) {
    }
    private Long id;
    private String name;
}
