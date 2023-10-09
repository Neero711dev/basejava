package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    @Override
    protected void insertElement(Resume r, int index) {
        storage[arraySize] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[arraySize - 1];

    }


    protected int getIndex(String uuid) {
        for (int i = 0; i < arraySize; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
