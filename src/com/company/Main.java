package com.company;

import com.company.exceptions.MyArrayDataException;
import com.company.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        int x = 4;
        String[][] arr4x4 = {
                {"123","12","398","2"},
                {"3","62","928","23"},
                {"103","15","7","3546","1"},
                {"1","123","98","855"}
        };

        try {
            System.out.println(arrCheck(arr4x4, x));
        } catch (MyArraySizeException s){
            System.out.println(s.getMessage());
        } catch (MyArrayDataException d){
            System.out.println(d.getMessage());
        }


    }

    private static int arrCheck(String[][] arr, int l) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < l; i++) {
            if (arr[i].length !=l || arr.length != l) {
                throw new MyArraySizeException("Обнаружен массив другого размера!");
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (isNumeric(arr[i][j])) {
                    result += Integer.parseInt(arr[i][j]);
                }
                else throw new MyArrayDataException("Элемент массива [" + i + "][" + j + "]  не является числом!");
            }
        }
        return result;
    }
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}