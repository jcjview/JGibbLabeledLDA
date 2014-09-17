
//-est -alpha 0.5 -beta 0.1 -ntopics 10 -niters 1000 -samplinglag 1000 -twords 20 -dir model/ -dfile we.gz   -unlabeled
package jgibblda;

import jgibblda.Util.FileIO;
import jgibblda.Util.ThetaMatrix;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LDA
{   public LDAInterface lda_Interface;
    public List<String> docs;
    LDACmdOption option ;
    public Model newModel;
    public LDA( List<String> docs,LDACmdOption option){
        //   this.lda_Interface=lda_Interface;
        this.docs=docs;
        this.option=option;
    }
    public void doLDA(){

            if (option.est || option.estc){
                Estimator estimator = new Estimator(option,docs);
                estimator.estimate();
            }
            else if(option.inf){
                option.modelName="model-final";
                Inferencer inferencer = new Inferencer(option,docs);
               newModel = inferencer.inference();
                //String [] test = {"手机 小苹果 人", "话费 余额 我", "滁州 马鞍山 无锡"};
            }
    }
    public ThetaMatrix returnModelTheta() {
        return newModel.returnModelTheta();
    }

    public static void main(String args[])
    {
        LDACmdOption option = new LDACmdOption();
//        option.est=true;
        option.dir = "lda\\";
        option.inf = true;   //预测词
        option.alpha=0.1;
        option.beta=0.01;
        option.modelName = "model-final";
//        option.
        option.niters = 100;//迭代次数
        option.K=50;       //主题个数
        option.twords=10; //主题词个数
        option.unlabeled=true;//不用label技术
        option.nburnin=900;
//        option.
        String filePath ="resource.txt";
        InputStreamReader inputReader = null;
        BufferedReader bufferReader = null;
        List<String> docContents=new LinkedList<String>();
        try
        {   File file=new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            inputReader = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(inputReader);
            // 读取一行
            String line = null;
            docContents=new ArrayList<String>();
            while ((line = bufferReader.readLine()) != null)
            {
                docContents.add(line);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            assert bufferReader != null;
            try {
                bufferReader.close();
                inputReader.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        LDA lda= new LDA(docContents,option);
        lda.doLDA();
        ThetaMatrix theta=lda.newModel.returnModelTheta();
        lda=null;
        FileIO.writeToFile("1",theta.save().toString());


    }

}
