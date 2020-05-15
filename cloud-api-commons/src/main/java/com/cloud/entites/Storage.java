package com.cloud.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private long id ;
    private long produceId;
    private long total;
    private long used;
    private long residue;
}
