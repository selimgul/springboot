package com.example.validation;

import lombok.Data;

@Data
public class User {
    @StartWith(value = "Demo", message = "name \"Demo\" ile başlamalı.")
    private String name;
}
