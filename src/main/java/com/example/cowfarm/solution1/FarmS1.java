package com.example.cowfarm.solution1;

import com.example.cowfarm.common.Farm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.cowfarm.util.Constants.*;

@Data
@Slf4j
public class FarmS1 implements Farm {

    private Map<Cow, List<Cow>> household;
    private long currentId;

    public FarmS1() {
        household = new HashMap<>();
        Cow motherCow = new Cow(1, "Burionka", null);
        household.put(motherCow, new ArrayList<>());
        currentId = motherCow.getId();
    }

    @Override
    public void giveBirth(long parentId, String name) {
        Cow parent = getCowById(parentId);
        if (parent == null) {
            log.error(COW_PARENT_NOT_FOUND);
            return;
        }
        Cow cowToAdd = new Cow(++currentId, name, parent);
        household.put(cowToAdd, new ArrayList<>());
        household.get(parent).add(cowToAdd);
        log.info(COW_ADDED_TEMPLATE, cowToAdd);
    }

    @Override
    public void endLifeSpan(long id) {
        if (id == 1) {
            log.error(IMMORTAL_COW);
            return;
        }
        Cow cowToRemove = getCowById(id);
        if (cowToRemove == null) {
            log.error(COW_NOT_FOUND);
            return;
        }
        Cow parent = cowToRemove.getParent();
        household.remove(cowToRemove);
        household.get(parent).remove(cowToRemove);
        log.info(COW_REMOVED_TEMPLATE, cowToRemove);
    }

    @Override
    public void printFarmData() {
        log.info(HOUSEHOLD);
        household.keySet().forEach(k -> log.info(k.toString()));
    }

    private Cow getCowById(long id) {
        return household.keySet().stream().filter(cow -> id == cow.getId())
                .findFirst()
                .orElse(null);
    }
}
