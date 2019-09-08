package cn.edu.bnuz.util;

public class PageCalculator {
    public static int caculateRowIndex(int pageIndex, int pageSize) {
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
