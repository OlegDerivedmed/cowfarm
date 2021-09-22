package com.example.cowfarm.common;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

import static com.example.cowfarm.util.Constants.*;

@Slf4j
public class ApplicationRunner {

    private Farm farm;

    public void runApplication(String[] args) {
        checkArgsAreValid(args);
        String solutionType = args[0];
        initialize(solutionType);
        showMenu();
    }

    private void initialize(String solutionType) {
        farm = new FarmService().provideFarm(solutionType);
    }

    private void showMenu() {
        log.info(MAIN_MENU);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            log.info(SELECT_OPTION_MESSAGE);
            int selectedOption = selectOption(scanner);
            switch (selectedOption) {
                case 1: {
                    addCow(scanner);
                    break;
                }
                case 2: {
                    removeCow(scanner);
                    break;
                }
                case 3: {
                    printFarmData();
                    break;
                }
                case 4: {
                    return;
                }
                default: {
                    log.error(INVALID_INPUT_MESSAGE);
                    break;
                }
            }
        }
    }

    private void addCow(Scanner scanner) {
        log.info(ENTER_PARENT_ID_MESSAGE);
        long parentId;
        try {
            parentId = Long.parseLong(scanner.nextLine());
        } catch (Exception e) {
            log.error(INVALID_INPUT_MESSAGE);
            return;
        }
        log.info(ENTER_NAME_MESSAGE);
        String name = scanner.nextLine();
        farm.giveBirth(parentId, name);
    }

    private void removeCow(Scanner scanner) {
        log.info(ENTER_COW_ID_MESSAGE);
        long cowId;
        try {
            cowId = Long.parseLong(scanner.nextLine());
        } catch (Exception e) {
            log.error(INVALID_INPUT_MESSAGE);
            return;
        }
        farm.endLifeSpan(cowId);
    }

    private void printFarmData() {
        farm.printFarmData();
    }

    private void checkArgsAreValid(String[] args) {
        if (args.length != 1 || !(args[0].equals(SOLUTION_TYPE_ONE) || args[0].equals(SOLUTION_TYPE_TWO))) {
            throw new RuntimeException(INVALID_ARGUMENT_MESSAGE);
        }
    }

    private int selectOption(Scanner scanner) {
        int selectedOption;
        try {
            selectedOption = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return 0;
        }
        return selectedOption;
    }
}
