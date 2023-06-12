package com.rusetskii.search;

import com.drew.lang.annotations.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.management.Query;

@Data
@AllArgsConstructor
public class QueryParams {
    private String query;
}
