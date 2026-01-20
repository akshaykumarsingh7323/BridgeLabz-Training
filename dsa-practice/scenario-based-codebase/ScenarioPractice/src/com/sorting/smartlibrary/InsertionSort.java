package com.sorting.smartlibrary;

class InsertionSort {

    static void sortBooks(Book[] books) {
        for (int i = 1; i < books.length; i++) {
            Book key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j].title.compareToIgnoreCase(key.title) > 0) {
                books[j + 1] = books[j];
                j--;
            }

            books[j + 1] = key;
        }
    }
}
