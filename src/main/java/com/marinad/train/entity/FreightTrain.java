package com.marinad.train.entity;


import com.google.common.base.Preconditions;
import com.marinad.cargo.entity.Cargo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FreightTrain extends Train {
    @Getter
    private final int liftingCapacity;
    private int filled = 0;
    private final List<Cargo> cargoList = new ArrayList<Cargo>();

    private FreightTrain(String model, int liftingCapacity) {
        super(model, "Freight");
        this.liftingCapacity = liftingCapacity;
        log.info("Freight train created");
    }

    public static FreightTrain of(String model, int liftingCapacity){
        Preconditions.checkArgument(liftingCapacity > 0, "Incorrect lifting capacity");
        return new FreightTrain(model, liftingCapacity);
    }

    public void addCaro(Cargo cargo){
        Preconditions.checkNotNull(cargo,"Cargo is null");
        Preconditions.checkState(cargo.getWeight()+filled < liftingCapacity, "Freight train is full");
        filled += cargo.getWeight();
        cargoList.add(cargo);
        log.info("Correct cargo added");
    }

    public List<Cargo> getCargoList(){
        return List.copyOf(cargoList);
    }
}
