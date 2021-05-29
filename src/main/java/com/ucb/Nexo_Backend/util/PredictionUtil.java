package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.Prediction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class PredictionUtil {

    public static List<Prediction> prediction(List<CountryCases> listcases,Integer cant){
        List<Prediction> listprediction = new ArrayList<>();
        String countryId="";

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con= listcases.size();
        double [][] vector=new double[con][1];
        double [][] prediction=new double[con][1];
        int countcases=0;
        for (int i=0;i<con;i++){
            CountryCases countryCases = new CountryCases();
            countryCases= listcases.get(i);
            Prediction predictions= new Prediction();
            predictions.setCases(countryCases.getNewCases());
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId=countryCases.getCountryId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getCountryId());
            listprediction.add(predictions);
            if(countryCases.getNewCases()>0){

                prediction[countcases][0]= countryCases.getNewCases();
                countcases=countcases+1;
            }
        }
        int [] prediccionsucesfull = generarPrediccion(cant,countcases-1,prediction);

        for (int i=0;i<prediccionsucesfull.length;i++){
            Prediction predictions= new Prediction();
            predictions.setCases(prediccionsucesfull[i]);
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            predictions.setDate(dt);
            predictions.setStatus(1);
            predictions.setId(countryId);
            listprediction.add(predictions);
        }
        return listprediction;
    }

    private static int[] generarPrediccion(int cantidad, int con, double[][] vector1) {
        int [] pre= new int[cantidad];
        for(int i=0;i<cantidad;i++) {
            double[][] datosXY=generarXY(vector1,con);
            //Suma de XY
            Double sumXY=0.0;
            //Suma del X
            Double sumaX=0.0;
            //media X
            Double mediaX=0.0;

            Double sumaY=0.0;
            //media X
            Double mediaY=0.0;
            // suma X*X
            Double sumXX=0.0;
            for (int j=0;j<datosXY.length;j++){
                //for(int j=0;j<datosXY[0].length;j++){
                sumXY=sumXY+(datosXY[j][0]*datosXY[j][1]);
                sumaX=sumaX+datosXY[j][1];
                sumXX=sumXX+(datosXY[j][1]*datosXY[j][1]);
                sumaY=sumaY+datosXY[j][0];

                //}
            }
            //System.out.println("can: "+con);
            mediaX=sumaX/(con*1.0);
            //System.out.println("meX: "+mediaX+" suma"+sumaX);
            mediaY=sumaY/(con*1.0);
            Double b1=(sumXY-((sumaX*sumaY)/con))/(sumXX-((sumaX*sumaX)/con));
            //System.out.println("b1: "+b1);
            Double b0=mediaY-b1*mediaX;
            //System.out.println("b0: "+b0);
            //System.out.println("dato ex"+ Math.exp(b0+b1*datosXY[datosXY.length-1][0]));
            double val= Math.exp(b0+b1*datosXY[datosXY.length-1][0]);
            //System.out.printf("\n%.0f", val);
            pre[i]= (int) val;
            con=con+1;
            double [][] nuevoDatos=new double[con+1][1];
            for (int c=0;c<nuevoDatos.length-1;c++){
                nuevoDatos[c][0]=vector1[c][0];
            }
            nuevoDatos[nuevoDatos.length-1][0]=val;
            for (int c=0;c<nuevoDatos.length;c++){
                //System.out.print(nuevoDatos[c][0]+" ");
            }

            //System.out.println(" ");
            vector1=nuevoDatos;
            for (int c=0;c<vector1.length;c++){
                //System.out.print(vector1[c][0]+" ");
            }
        }
        return pre;
    }

    public static double[][] generarXY(double[][] vector1,int con){
        double [][] datosXY=new double[con][2];
        for (int i=0;i<datosXY.length+1;i++){
            for(int j=0;j<datosXY[0].length;j++){
                if (i>0){
                    if(j==0){
                        datosXY[i-1][j]=Math.log(vector1[i][0]);
                    }
                    else{
                        datosXY[i-1][j]=Math.log(vector1[i-1][0]);
                    }
                }
            }
        }

        return datosXY;
    }

    private static int cantidad(String s) throws IOException {
        FileInputStream fis=new FileInputStream(s);
        int valor=fis.read();
        int cont=0;
        while( (valor=fis.read()) != -1 ) {
            if(valor=='\n') {
                cont++;
            }
        }
        fis.close();
        return cont;
    }


    public static double [][] datosG(String archivo,double [][] vector) throws IOException {
        FileInputStream fis=new FileInputStream(archivo);
        int valor=fis.read();
        int cont=0;
        String reg="";
        while(valor!=-1){
            if(valor!='\n') {
                reg = reg + (char)valor;
            }else {
                vector[cont][0]=Double.parseDouble(reg);
                reg = "";
                cont++;
            }
            valor=fis.read();
        }
        fis.close();
        return vector;

    }
}
