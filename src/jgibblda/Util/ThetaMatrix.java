package jgibblda.Util;

/**
 * Created with IntelliJ IDEA.
 * User: zjjin
 * Date: 14-9-17
 * Time: 下午5:22
 * To change this template use File | Settings | File Templates.
 */
public class ThetaMatrix {
    int row;//
    int col;
    double data[][];
    ThetaMatrix(int r,int c){
        row=r;
        col=c;
        data=new double[row][col];
    }
}
