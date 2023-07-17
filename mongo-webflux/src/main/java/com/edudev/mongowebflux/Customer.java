package com.edudev.mongowebflux;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class Customer {

    @Id
    public String id;
    public String name;

}
