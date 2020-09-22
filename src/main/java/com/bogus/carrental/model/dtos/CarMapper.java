package com.bogus.carrental.model.dtos;

import com.bogus.carrental.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    private CarMapper() {
    }

    public static CarDto mapToCarDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .mark(car.getMark())
                .model(car.getModel())
                .bodyType(car.getBodyType())
                .color(car.getColor())
                .mileage(car.getMileage())
                .payForDay(car.getPayForDay())
                .productionYear(car.getProductionYear())
                .build();
    }

    public static List<CarDto> mapToCarDtos(List<Car> cars) {

        return cars.stream().map(car -> mapToCarDto(car)).collect(Collectors.toList());

    }

    public static Car mapDtoToCar(CarDto car) {
        return Car.builder()
                .id(car.getId())
                .mark(car.getMark())
                .model(car.getModel())
                .bodyType(car.getBodyType())
                .color(car.getColor())
                .mileage(car.getMileage())
                .payForDay(car.getPayForDay())
                .productionYear(car.getProductionYear())
                .build();
    }


}
