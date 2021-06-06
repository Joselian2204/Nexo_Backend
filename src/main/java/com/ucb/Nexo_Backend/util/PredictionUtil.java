package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class PredictionUtil {



    public static List<PredictionRequest> predictionCAR1(List<CountryCases> listcases, Integer cant, Integer filter, Integer modelo) {
        List<PredictionRequest> listprediction1 = new ArrayList<>();
        String countryId = "";
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[][] prediction = new double[con][1];
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
                    prediction[countcases][0] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases][0] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases][0] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }
        int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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




    public static List<PredictionRequest> predictionDAR1(List<DepartmentCases> listcases, Integer cant, Integer filter, Integer modelo) {
        List<PredictionRequest> listprediction1 = new ArrayList<>();
        String countryId = "";
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[][] prediction = new double[con][1];
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
                    prediction[countcases][0] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases][0] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases][0] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }
        int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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


    public static List<PredictionRequest> predictionMAR1(List<MunicipalityCases> listcases, Integer cant, Integer filter, Integer modelo) {
        List<PredictionRequest> listprediction2 = new ArrayList<>();
        String countryId = "";

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        int con = listcases.size();
        double[][] vector = new double[con][1];
        double[][] prediction = new double[con][1];
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
            listprediction2.add(predictions);
            if (countryCases.getNewCases() > 0) {
                if (filter == 0) {
                    prediction[countcases][0] = countryCases.getNewCases();
                } else {
                    if (filter == 1) {
                        prediction[countcases][0] = countryCases.getDeaths();
                    } else {
                        if (filter == 2) {
                            prediction[countcases][0] = countryCases.getRecovered();
                        }
                    }
                }
                countcases = countcases + 1;
            }
        }
        int[] prediccionsucesfull = generarPrediccion(cant, countcases - 1, prediction, modelo);

        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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



    private static int[] generarPrediccion(int cantidad, int con, double[][] vector1, int modelo) {
        int[] pre = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            double[][] datosXY = generarXY(vector1, con);
            //Suma de XY
            Double sumXY = 0.0;
            //Suma del X
            Double sumaX = 0.0;
            //media X
            Double mediaX = 0.0;

            Double sumaY = 0.0;
            //media X
            Double mediaY = 0.0;
            // suma X*X
            Double sumXX = 0.0;
            for (int j = 0; j < datosXY.length; j++) {
                //for(int j=0;j<datosXY[0].length;j++){
                sumXY = sumXY + (datosXY[j][0] * datosXY[j][1]);
                sumaX = sumaX + datosXY[j][1];
                sumXX = sumXX + (datosXY[j][1] * datosXY[j][1]);
                sumaY = sumaY + datosXY[j][0];

                //}
            }
            //System.out.println("can: "+con);
            mediaX = sumaX / (con * 1.0);
            //System.out.println("meX: "+mediaX+" suma"+sumaX);
            mediaY = sumaY / (con * 1.0);
            Double b1 = (sumXY - ((sumaX * sumaY) / con)) / (sumXX - ((sumaX * sumaX) / con));
            //System.out.println("b1: "+b1);
            Double b0 = mediaY - b1 * mediaX;
            //System.out.println("b0: "+b0);
            //System.out.println("dato ex"+ Math.exp(b0+b1*datosXY[datosXY.length-1][0]));
            double val=0;
            //System.out.printf("\n%.0f", val);
            if (modelo == 0) {
                //arima
                val = Math.exp(b0 - b1 * datosXY[datosXY.length - 1][0]);
                System.out.println("0");
            } else {
                if (modelo == 1) {
                    //ar1
                    val = Math.exp(b0 + b1 * datosXY[datosXY.length - 1][0]);
                    System.out.println("1");
                    System.out.println(val+" 1 ");
                } else {
                    if (modelo == 2) {
                        //ar2
                        double b2 = b1 * b1;
                        val = Math.exp(b0 + b1 * datosXY[datosXY.length - 1][0]) + b2 * datosXY[datosXY.length - 1][1];
                        System.out.println("2");

                    }
                }
            }


            pre[i] = (int) val;
            con = con + 1;
            double[][] nuevoDatos = new double[con + 1][1];
            for (int c = 0; c < nuevoDatos.length - 1; c++) {
                nuevoDatos[c][0] = vector1[c][0];
            }
            nuevoDatos[nuevoDatos.length - 1][0] = val;
            for (int c = 0; c < nuevoDatos.length; c++) {
                //System.out.print(nuevoDatos[c][0]+" ");
            }

            //System.out.println(" ");
            vector1 = nuevoDatos;
            for (int c = 0; c < vector1.length; c++) {
                //System.out.print(vector1[c][0]+" ");
            }
        }
        return pre;
    }

    public static double[][] generarXY(double[][] vector1, int con) {
        double[][] datosXY = new double[con][2];
        for (int i = 0; i < datosXY.length + 1; i++) {
            for (int j = 0; j < datosXY[0].length; j++) {
                if (i > 0) {
                    if (j == 0) {
                        datosXY[i - 1][j] = Math.log(vector1[i][0]);
                    } else {
                        datosXY[i - 1][j] = Math.log(vector1[i - 1][0]);
                    }
                }
            }
        }

        return datosXY;
    }




}
