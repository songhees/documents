package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.Data;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restaurant {
    @Setter(onMethod_= @Autowired)
    private Chef chef;

}
