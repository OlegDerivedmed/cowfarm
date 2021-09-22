package com.example.cowfarm.solution2;

import com.example.cowfarm.common.Farm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import static com.example.cowfarm.util.Constants.*;

@Data
@Slf4j
public class FarmS2 implements Farm {

    private Cow motherCow;
    private long currentId;

    public FarmS2() {
        motherCow = new Cow(1, "Burionka");
        currentId = motherCow.getId();
    }

    @Override
    public void giveBirth(long parentId, String name) {
        Cow mother = findById(motherCow, parentId);
        if (mother == null) {
            log.error(COW_PARENT_NOT_FOUND);
            return;
        }
        Cow childToAdd = new Cow(++currentId, name, mother);
        Cow child = mother.getChild();
        if (child == null) {
            mother.setChild(childToAdd);
        } else addAnotherChild(child, childToAdd);
        log.info(COW_ADDED_TEMPLATE, childToAdd);
    }

    @Override
    public void endLifeSpan(long id) {
        if (id == 1) {
            log.error(IMMORTAL_COW);
            return;
        }
        Cow cowToRemove = findById(motherCow, id);
        if (cowToRemove == null) {
            log.error(COW_NOT_FOUND);
            return;
        }
        Cow left = cowToRemove.getLeft();
        Cow right = cowToRemove.getRight();
        Cow parent = cowToRemove.getParent();
        Cow child = cowToRemove.getChild();
        if (child != null) {
            proceedHaveChild(child, parent, left, right);
        } else {
            proceedHaveNoChild(parent, left, right);
        }
        log.info(COW_REMOVED_TEMPLATE, cowToRemove);
    }

    @Override
    public void printFarmData() {
        log.info(HOUSEHOLD);
        printCow(motherCow);
    }

    private void printCow(Cow root) {
        if (root == null) {
            return;
        }
        log.info(root.toString());
        printCow(root.getChild());
        printCow(root.getRight());
    }

    private Cow findById(Cow root, long id) {
        if (root == null) {
            return null;
        }
        if (root.getId() == id) {
            return root;
        }

        Cow childResult = findById(root.getChild(), id);
        if (childResult != null) {
            return childResult;
        }
        return findById(root.getRight(), id);
    }

    private void addAnotherChild(Cow current, Cow cowToAdd) {
        Cow right = current.getRight();
        if (right == null) {
            current.setRight(cowToAdd);
            cowToAdd.setLeft(current);
        } else addAnotherChild(right, cowToAdd);
    }

    private void proceedHaveChild(Cow child, Cow parent, Cow left, Cow right) {
        child.setParent(parent);
        if (left != null) {
            left.setRight(child);
            child.setLeft(left);
        }
        if (right != null) {
            right.setLeft(child);
            child.setRight(right);
        }
        if (left == null) {
            parent.setChild(child);
        }
    }

    private void proceedHaveNoChild(Cow parent, Cow left, Cow right) {
        if (left != null) {
            left.setRight(right);
        }
        if (right != null) {
            right.setLeft(left);
            if (left == null) {
                parent.setChild(right);
            }
        } else parent.setChild(null);
    }
}
