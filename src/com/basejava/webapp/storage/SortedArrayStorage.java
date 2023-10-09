package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    protected void insertElement(Resume r, int index) {
        int insI = -index - 1;
        System.arraycopy(storage, insI, storage, insI + 1, arraySize - insI);
        storage[insI] = r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int nMoved = arraySize - index - 1;
        if (nMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, nMoved);
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, arraySize, searchKey);
    }
}
