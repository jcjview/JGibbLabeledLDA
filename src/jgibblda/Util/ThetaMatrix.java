package jgibblda.Util;

public class ThetaMatrix {
    public int  row;//
    public int col;
    public double data[][];
    public ThetaMatrix(int r, int c){
        row=r;
        col=c;
//        data=new double[row][col];
    }
    public StringBuilder save(){
        StringBuilder builder=new StringBuilder(row*col*20);
         for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                   builder.append(data[i][j]).append(",");
             }
             builder.append("\n");
         }
        return  builder;
    }
}
