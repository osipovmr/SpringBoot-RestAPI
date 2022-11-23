package com.cef.testTask.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
/*@EntityListeners({Order.class, User.class})*/
@Data
public abstract class Model implements Serializable {

    @CreatedDate
    private Date createdDate = new Date();
}
