package com.aysekoc.projecqrs.application.book.query.getList;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetListBookItemDto {
    private UUID id;
    private String name;
}
