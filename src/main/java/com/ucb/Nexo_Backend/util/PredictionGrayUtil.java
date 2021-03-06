package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class PredictionGrayUtil {


        private double a0, a1, a2;
        private int size;
        private double error;
        public PredictionGrayUtil() {
        }

    public static List<PredictionRequest> predictionCGRAY(List<CountryCases> listcases, Integer cant, Integer filter) {
        PredictionGrayUtil gs = new PredictionGrayUtil();
        List<PredictionRequest> listprediction1 = new ArrayList<>();
        String countryId = "";
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[] prediction = new double[con];
        int countcases = 0;
        for (int i = 0; i < con; i++) {
            CountryCases countryCases = new CountryCases();
            countryCases = listcases.get(i);
            PredictionRequest predictions = new PredictionRequest();
            if (filter == 0) {
                predictions.setCases(countryCases.getNewCases());
            } else {
                if (filter == 1) {
                    predictions.setCases(countryCases.getDeaths());
                } else {
                    if (filter == 2) {
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId = countryCases.getCountryId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getCountryId());
            listprediction1.add(predictions);
            if (countryCases.getNewCases() > 0) {
                if (filter == 0) {
                    prediction[countcases] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }

        //int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        gs.build(prediction);
        //for (int i = 0; i < cant; i++) {
            //System.out.println(gs.nextValue(i));
        //}
        //System.out.println(Math.sqrt(gs.getError()));


        for (int i = 0; i < cant; i++) {
            System.out.println(gs.nextValue(i));
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases((int) gs.nextValue(i));
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            predictions.setDate(dt);
            predictions.setStatus(1);
            predictions.setId(countryId);
            listprediction1.add(predictions);
        }
        return listprediction1;
    }


    public static List<PredictionRequest> predictionDGRAY(List<DepartmentCases> listcases, Integer cant, Integer filter) {
        PredictionGrayUtil gs = new PredictionGrayUtil();
        List<PredictionRequest> listprediction1 = new ArrayList<>();
        String countryId = "";
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[] prediction = new double[con];
        int countcases = 0;
        for (int i = 0; i < con; i++) {
            DepartmentCases countryCases = new DepartmentCases();
            countryCases = listcases.get(i);
            PredictionRequest predictions = new PredictionRequest();
            if (filter == 0) {
                predictions.setCases(countryCases.getNewCases());
            } else {
                if (filter == 1) {
                    predictions.setCases(countryCases.getDeaths());
                } else {
                    if (filter == 2) {
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId = countryCases.getDepartmentId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getDepartmentId());
            listprediction1.add(predictions);
            if (countryCases.getNewCases() > 0) {
                if (filter == 0) {
                    prediction[countcases] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }

        //int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        gs.build(prediction);
        //for (int i = 0; i < cant; i++) {
        //System.out.println(gs.nextValue(i));
        //}
        //System.out.println(Math.sqrt(gs.getError()));


        for (int i = 0; i < cant; i++) {
            System.out.println(gs.nextValue(i));
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases((int) gs.nextValue(i));
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            predictions.setDate(dt);
            predictions.setStatus(1);
            predictions.setId(countryId);
            listprediction1.add(predictions);
        }
        return listprediction1;
    }


    public static List<PredictionRequest> predictionMGRAY(List<MunicipalityCases> listcases, Integer cant, Integer filter) {
        PredictionGrayUtil gs = new PredictionGrayUtil();
        List<PredictionRequest> listprediction1 = new ArrayList<>();
        String countryId = "";
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[] prediction = new double[con];
        int countcases = 0;
        for (int i = 0; i < con; i++) {
           MunicipalityCases countryCases = new MunicipalityCases();
            countryCases = listcases.get(i);
            PredictionRequest predictions = new PredictionRequest();
            if (filter == 0) {
                predictions.setCases(countryCases.getNewCases());
            } else {
                if (filter == 1) {
                    predictions.setCases(countryCases.getDeaths());
                } else {
                    if (filter == 2) {
                        predictions.setCases(countryCases.getRecovered());
                    }
                }
            }
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(0);
            countryId = countryCases.getRegionId();

            c.setTime(countryCases.getDate());
            predictions.setId(countryCases.getRegionId());
            listprediction1.add(predictions);
            if (countryCases.getNewCases() > 0) {
                if (filter == 0) {
                    prediction[countcases] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }

        //int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        gs.build(prediction);
        //for (int i = 0; i < cant; i++) {
        //System.out.println(gs.nextValue(i));
        //}
        //System.out.println(Math.sqrt(gs.getError()));


        for (int i = 0; i < cant; i++) {
            System.out.println(gs.nextValue(i));
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases((int) gs.nextValue(i));
            c.add(Calendar.DATE, 1);
            dt = c.getTime();
            predictions.setDate(dt);
            predictions.setStatus(1);
            predictions.setId(countryId);
            listprediction1.add(predictions);
        }
        return listprediction1;
    }




        public void build(double[] x0) {
            size = x0.length;
            double[] x1 = new double[size];
            x1[0] = x0[0];
            for (int i = 1; i < size; i++) {
                x1[i] = x0[i] + x1[i - 1];
            }
            double[][] b = new double[size - 1][2];
            double[][] bt = new double[2][size - 1];
            double[][] y = new double[size - 1][1];
            for (int i = 0; i < b.length; i++) {
                b[i][0] = -(x1[i] + x1[i + 1]) / 2;
                b[i][1] = 1;
                bt[0][i] = b[i][0];
                bt[1][i] = 1;
                y[i][0] = x0[i + 1];
            }
            double[][] t = new double[2][2];
            multiply(bt, b, t);
            t = inverse(t);
            double[][] t1 = new double[2][size - 1];
            multiply(t, bt, t1);
            double[][] t2 = new double[2][1];
            multiply(t1, y, t2);
            a0 = t2[0][0];
            double u = t2[1][0];
            a2 = u / a0;
            a1 = x0[0] - a2;
            a0 = -a0;
            error = 0;
            for (int i = 0; i < x0.length; i++) {
                double d = (x0[i] - getX0(i));
                error += d * d;
            }
            error /= x0.length;
        }
        public double getError() {
            return error;
        }
        double getX1(int k) {
            return a1 * Math.exp(a0 * k) + a2;
        }
        double getX0(int k) {
            // return a0 * a1 * Math.exp(a0 * k);
            if (k == 0)
                return a1 * Math.exp(a0 * k) + a2;
            else
                return a1 * (Math.exp(a0 * k) - Math.exp(a0 * (k - 1)));
        }

        public double nextValue(int index) {
            if (index < 0)
                throw new IndexOutOfBoundsException();
            return getX0(size + index);
        }

        public double nextValue() {
            return nextValue(0);
        }

        static double[][] inverse(double[][] t) {
            double[][] a = new double[2][2];
            double det = t[0][0] * t[1][1] - t[0][1] * t[1][0];
            a[0][0] = t[1][1] / det;
            a[0][1] = -t[1][0] / det;
            a[1][0] = -t[0][1] / det;
            a[1][1] = t[0][0] / det;
            return a;
        }

        static void multiply(double[][] left, double[][] right, double[][] dest) {
            int n1 = left.length;
            int m1 = left[0].length;
            int m2 = right[0].length;
            for (int k = 0; k < n1; k++) {
                for (int s = 0; s < m2; s++) {
                    dest[k][s] = 0;
                    for (int i = 0; i < m1; i++) {
                        dest[k][s] += left[k][i] * right[i][s];
                    }
                }
            }
        }


//        private static int cantidad(String s) throws IOException {
//            FileInputStream fis=new FileInputStream(s);
//            int valor=fis.read();
//            int cont=0;
//            while( (valor=fis.read()) != -1 ) {
//                if(valor=='\n') {
//                    cont++;
//                }
//            }
//            fis.close();
//            return cont;
//        }
//        public static double [] datosG(String archivo,double []valorr) throws IOException {
//            FileInputStream fis=new FileInputStream(archivo);
//            int valor=fis.read();
//            int cont=0;
//            String reg="";
//
//            while(valor!=-1){
//                if(valor!='\n') {
//                    reg = reg + (char)valor;
//                }else {
//                    valorr[cont]=Double.parseDouble(reg);
//                    reg = "";
//                    cont++;
//                }
//                valor=fis.read();
//            }
//            fis.close();
//            return valorr;
//
//        }

}
