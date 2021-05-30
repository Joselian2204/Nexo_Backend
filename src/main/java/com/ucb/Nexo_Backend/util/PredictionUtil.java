package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;
import com.ucb.Nexo_Backend.models.Prediction;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class PredictionUtil {

    public static List<Prediction> predictionCAR1(List<CountryCases> listcases,Integer cant,Integer filter){
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
            if (filter==0){
                predictions.setCases(countryCases.getNewCases());
            }
            else{
                if (filter==1){
                    predictions.setCases(countryCases.getDeaths());
                }
                else{
                    if (filter==2){
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId=countryCases.getCountryId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getCountryId());
            listprediction.add(predictions);
            if(countryCases.getNewCases()>0){
                if (filter==0){
                    prediction[countcases][0]=countryCases.getNewCases();
                }
                else{
                    if (filter==1){
                        prediction[countcases][0]= countryCases.getDeaths();
                    }
                    else{
                        if (filter==2){
                            prediction[countcases][0]= countryCases.getRecovered();
                        }
                    }
                }
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
    public static List<Prediction> predictionMatrices(List<CountryCases> listcases,Integer cantidad){
        List<Prediction> listprediction = new ArrayList<>();
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] datosx=new double[mx][nx];
        double[][] datosy=new double[mx][ny];
        String countryId="";
        Calendar c = Calendar.getInstance();
        int indice = 0;

        for (CountryCases countryCases: listcases){
            datosx[indice][0] = 1;
            datosx[indice][1] = indice + 1;
            datosy[indice][0] = countryCases.getNewCases();
            indice = indice + 1;
            c.setTime(countryCases.getDate());
        }
        System.out.println(imprimir(datosx));
        System.out.println(imprimir(datosy));
        double[][] betas = generarBetas(datosx,datosy);
        String cadena = imprimir(betas);
        System.out.println(cadena);
        long[][] prediccionsucesfull = funcionLineal(betas,cantidad);
        for (int i=0;i<prediccionsucesfull.length;i++){
            Prediction predictions= new Prediction();
            predictions.setCases(prediccionsucesfull[i][1]);
            c.add(Calendar.DATE, 1);
            Date dt = c.getTime();
            predictions.setDate(dt);
            predictions.setStatus(1);
            predictions.setId(countryId);
            listprediction.add(predictions);
        }
        return listprediction;
    }

    public static List<Prediction> predictionDAR1(List<DepartmentCases> listcases, Integer cant, Integer filter){
        List<Prediction> listprediction1 = new ArrayList<>();
        String countryId="";

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con= listcases.size();
        double [][] vector=new double[con][1];
        double [][] prediction=new double[con][1];
        int countcases=0;
        for (int i=0;i<con;i++){
            DepartmentCases countryCases = new DepartmentCases();
            countryCases= listcases.get(i);
            Prediction predictions= new Prediction();
            if (filter==0){
                predictions.setCases(countryCases.getNewCases());
            }
            else{
                if (filter==1){
                    predictions.setCases(countryCases.getDeaths());
                }
                else{
                    if (filter==2){
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId=countryCases.getDepartmentId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getDepartmentId());
            listprediction1.add(predictions);
            if(countryCases.getNewCases()>0){
                if (filter==0){
                    prediction[countcases][0]=countryCases.getNewCases();
                }
                else{
                    if (filter==1){
                        prediction[countcases][0]= countryCases.getDeaths();
                    }
                    else{
                        if (filter==2){
                            prediction[countcases][0]= countryCases.getRecovered();
                        }
                    }
                }
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
            listprediction1.add(predictions);
        }
        return listprediction1;
    }

    public static List<Prediction> predictionMAR1(List<MunicipalityCases> listcases, Integer cant, Integer filter){
        List<Prediction> listprediction2 = new ArrayList<>();
        String countryId="";

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con= listcases.size();
        double [][] vector=new double[con][1];
        double [][] prediction=new double[con][1];
        int countcases=0;
        for (int i=0;i<con;i++){
            MunicipalityCases countryCases = new MunicipalityCases();
            countryCases= listcases.get(i);
            Prediction predictions= new Prediction();
            if (filter==0){
                predictions.setCases(countryCases.getNewCases());
            }
            else{
                if (filter==1){
                    predictions.setCases(countryCases.getDeaths());
                }
                else{
                    if (filter==2){
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId=countryCases.getRegionId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getRegionId());
            listprediction2.add(predictions);
            if(countryCases.getNewCases()>0){
                if (filter==0){
                    prediction[countcases][0]=countryCases.getNewCases();
                }
                else{
                    if (filter==1){
                        prediction[countcases][0]= countryCases.getDeaths();
                    }
                    else{
                        if (filter==2){
                            prediction[countcases][0]= countryCases.getRecovered();
                        }
                    }
                }
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
            listprediction2.add(predictions);
        }
        return listprediction2;
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
    public static long[][] funcionLineal(double[][] betas,int con){
        int n = 2;
        long [][] datosXY=new long[con][n];
        for (int i=0;i<con;i++){
            double y = 0;
            for(int j=0;j<betas[0].length;j++){
                if (i == 0)
                    y = betas[j][0];
                else{
                    y = y + betas[j][0];
                    }
                }
            datosXY[i][0] = i;
            datosXY[i][1] = (long)y;
            }
        return datosXY;
    }

    private static double multiplicar(double[][] matriz1, int f, int c, double[][] matriz2,double n1) {
        double resultado=0;
        for(int i=0;i<n1;i++) {
            resultado=matriz1[f][i]*matriz2[i][c]+resultado;
        }
        return resultado;
    }

    private static double[][] multiplicacion(double[][] matriz1, double[][] matriz2) {
        int m = matriz1.length;
        int n = matriz2[0].length;
        double[][] resultado=new double[m][n];
        double aux=0;
        if(matriz1[0].length==matriz2.length) {
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    aux=multiplicar(matriz1,i,j,matriz2,matriz1[0].length);
                    resultado[i][j]=aux;
                }
            }

        }
        return resultado;
    }
    private static String imprimir(double[][] matriz) {
        String cadena="";
        for(int i=0;i<matriz.length;i++) {
            for(int j=0;j<matriz[0].length;j++) {
                cadena = cadena+"  "+matriz[i][j];
            }
            cadena =cadena  +"\n";
        }
        return cadena;

    }
    private static double[][] transponerMatriz(double[][] matrizA){
        double[][] transpuesta=new double[matrizA[0].length][matrizA.length];
        for(int i=0;i<matrizA.length;i++){
            for(int j=0;j<matrizA[i].length;j++){
                transpuesta[j][i] = matrizA[i][j];
            }

        }
        return transpuesta;
    }
    private static double[][] inversa(double matriz[][], int n){
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int indice[] = new int[n];
        for (int i=0; i<n; ++i)
            b[i][i] = 1;
        gauss(matriz, indice);
        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[indice[j]][k]
                            -= matriz[indice[j]][i]*b[indice[i]][k];
        for (int i=0; i<n; ++i)             {
            x[n-1][i] = b[indice[n-1]][i]/matriz[indice[n-1]][n-1];
            for (int j=n-2; j>=0; --j)                 {
                x[j][i] = b[indice[j]][i];
                for (int k=j+1; k<n; ++k)
                {
                    x[j][i] -= matriz[indice[j]][k]*x[k][i];
                }

                x[j][i] /= matriz[indice[j]][j];
            }
        }
        return x;
    }
    //Metodo de Gauss
    private static void gauss(double a[][], int indice[])  {

        int n = indice.length;
        double c[] = new double[n];
        for (int i=0; i<n; ++i)
            indice[i] = i;
        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j=0; j<n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i)  {

                double pi0 = Math.abs(a[indice[i]][j]);
                pi0 /= c[indice[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = indice[j];
            indice[j] = indice[k];
            indice[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[indice[i]][j]/a[indice[j]][j];
                a[indice[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[indice[i]][l] -= pj*a[indice[j]][l];
            }
        }
    }
    private static double[][] generarBetas(double xx[][],double yy[][]){
        double[][] x={{1,49},{1,69},{1,89},{1,99},{1,109}};
        double[][] y={{124},{95},{71},{45},{18}};
        int nx=x[0].length;
        double[][] matrizTras=transponerMatriz(x);
        double[][] multiplicadorA=multiplicacion(matrizTras,x);
        double[][] inversa= inversa(multiplicadorA,nx);
        double[][] multiplicadorB=multiplicacion(inversa,matrizTras);
        double[][] resultado=multiplicacion(multiplicadorB,y);
        return resultado;
    }

}
