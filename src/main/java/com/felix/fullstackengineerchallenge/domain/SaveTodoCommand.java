package com.felix.fullstackengineerchallenge.domain;

import jakarta.validation.constraints.NotEmpty;

public record SaveTodoCommand(@NotEmpty String text) {}
