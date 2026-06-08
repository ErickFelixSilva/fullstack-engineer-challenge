package com.felix.fullstackengineerchallenge.domain;

import java.util.Calendar;
import java.util.Date;

public record Todo(Long id, String text, Calendar createdAt) {
}
