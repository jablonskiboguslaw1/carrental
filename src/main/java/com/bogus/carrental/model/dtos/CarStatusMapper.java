package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.CarStatus;
import com.bogus.carrental.model.Status;

public class CarStatusMapper {
    public static CarStatus mapToStatus(CarStatusDto status) {
        return CarStatus.builder()
                .endDate(status.getReservationEnd())
                .startDate(status.getReservationStart())
                .status(Status.valueOf(status.getStatus().toUpperCase()))

                .build();
    }
}
