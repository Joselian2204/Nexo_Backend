package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.dto.LinealRequest;
import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PrediccionLinealUtil {
    public static List<PredictionRequest> predictionMatrixCountries(List<CountryCases> listcases, Integer cantidad, Integer filter) {
        List<PredictionRequest> listprediction = new ArrayList<>();
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] datosx = new double[mx][nx];
        double[][] datosy = new double[mx][ny];
        String countryId = "";
        Calendar c = Calendar.getInstance();
        int indice = 0;
        for (CountryCases countryCases : listcases) {
            datosx[indice][0] = 1;
            datosx[indice][1] = indice + 1;
            if (filter == 0) {
                datosy[indice][0] = countryCases.getNewCases();
            } else if (filter == 1) {
                datosy[indice][0] = countryCases.getDeaths();
            } else if (filter == 2) {
                datosy[indice][0] = countryCases.getRecovered();
            }
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases(countryCases.getNewCases());
            predictions.setDate(countryCases.getDate());
            predictions.setStatus(1);
            predictions.setId(countryCases.getCountryId());
            listprediction.add(predictions);
            indice = indice + 1;
            c.setTime(countryCases.getDate());
        }
        double[][] betas = generarBetas(datosx, datosy);
        long[][] prediccionsucesfull = funcionLineal(betas, cantidad);
        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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

    public static List<PredictionRequest> predictionMatrixDepartments(List<DepartmentCases> listcases, Integer cantidad, Integer filter) {
        List<PredictionRequest> listprediction = new ArrayList<>();
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] datosx = new double[mx][nx];
        double[][] datosy = new double[mx][ny];
        String countryId = "";
        Calendar c = Calendar.getInstance();
        int indice = 0;
        for (DepartmentCases departmentCases : listcases) {
            datosx[indice][0] = 1;
            datosx[indice][1] = indice + 1;
            if (filter == 0) {
                datosy[indice][0] = departmentCases.getNewCases();
            } else if (filter == 1) {
                datosy[indice][0] = departmentCases.getDeaths();
            } else if (filter == 2) {
                datosy[indice][0] = departmentCases.getRecovered();
            }
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases(departmentCases.getNewCases());
            predictions.setDate(departmentCases.getDate());
            predictions.setStatus(1);
            predictions.setId(departmentCases.getDepartmentId());
            listprediction.add(predictions);
            indice = indice + 1;
            c.setTime(departmentCases.getDate());
        }
        double[][] betas = generarBetas(datosx, datosy);
        long[][] prediccionsucesfull = funcionLineal(betas, cantidad);
        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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

    public static List<PredictionRequest> predictionMatrixMunicipality(List<MunicipalityCases> listcases, Integer cantidad, Integer filter) {

        List<PredictionRequest> listprediction = new ArrayList<>();
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] datosx = new double[mx][nx];
        double[][] datosy = new double[mx][ny];
        String countryId = "";
        Calendar c = Calendar.getInstance();
        int indice = 0;
        for (MunicipalityCases municipalityCases : listcases) {
            datosx[indice][0] = 1;
            datosx[indice][1] = indice + 1;
            if (filter == 0) {
                datosy[indice][0] = municipalityCases.getNewCases();
            } else if (filter == 1) {
                datosy[indice][0] = municipalityCases.getDeaths();
            } else if (filter == 2) {
                datosy[indice][0] = municipalityCases.getRecovered();
            }
            PredictionRequest predictions = new PredictionRequest();
            predictions.setCases(municipalityCases.getNewCases());
            predictions.setDate(municipalityCases.getDate());
            predictions.setStatus(1);
            predictions.setId(municipalityCases.getRegionId());
            listprediction.add(predictions);
            indice = indice + 1;
            c.setTime(municipalityCases.getDate());
        }
        double[][] betas = generarBetas(datosx, datosy);
        long[][] prediccionsucesfull = funcionLineal(betas, cantidad);
        for (int i = 0; i < prediccionsucesfull.length; i++) {
            PredictionRequest predictions = new PredictionRequest();
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
    public static long[][] funcionLineal(double[][] betas, int con) {
        int n = 2;
        long[][] datosXY = new long[con][n];
        for (int i = 0; i < con; i++) {
            double y = 0;
            for (int j = 0; j < betas[0].length; j++) {
                if (i == 0)
                    y = betas[j][0];
                else {
                    y = y + i*betas[j][0];
                }
            }
            if(y<0){
                y = 0;
            }
            datosXY[i][0] = i;
            datosXY[i][1] = (long) y;
        }
        return datosXY;
    }

    private static double multiplicar(double[][] matriz1, int f, int c, double[][] matriz2, double n1) {
        double resultado = 0;
        for (int i = 0; i < n1; i++) {
            resultado = matriz1[f][i] * matriz2[i][c] + resultado;
        }
        return resultado;
    }

    private static double[][] multiplicacion(double[][] matriz1, double[][] matriz2) {
        int m = matriz1.length;
        int n = matriz2[0].length;
        double[][] resultado = new double[m][n];
        double aux = 0;
        if (matriz1[0].length == matriz2.length) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    aux = multiplicar(matriz1, i, j, matriz2, matriz1[0].length);
                    resultado[i][j] = aux;
                }
            }

        }
        return resultado;
    }

    private static double[][] transponerMatriz(double[][] matrizA) {
        double[][] transpuesta = new double[matrizA[0].length][matrizA.length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                transpuesta[j][i] = matrizA[i][j];
            }

        }
        return transpuesta;
    }

    private static double[][] inversa(double matriz[][], int n) {
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int indice[] = new int[n];
        for (int i = 0; i < n; ++i)
            b[i][i] = 1;
        gauss(matriz, indice);
        for (int i = 0; i < n - 1; ++i)
            for (int j = i + 1; j < n; ++j)
                for (int k = 0; k < n; ++k)
                    b[indice[j]][k]
                            -= matriz[indice[j]][i] * b[indice[i]][k];
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[indice[n - 1]][i] / matriz[indice[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[indice[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= matriz[indice[j]][k] * x[k][i];
                }

                x[j][i] /= matriz[indice[j]][j];
            }
        }
        return x;
    }

    //Metodo de Gauss
    private static void gauss(double a[][], int indice[]) {

        int n = indice.length;
        double c[] = new double[n];
        for (int i = 0; i < n; ++i)
            indice[i] = i;
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {

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
            for (int i = j + 1; i < n; ++i) {
                double pj = a[indice[i]][j] / a[indice[j]][j];
                a[indice[i]][j] = pj;
                for (int l = j + 1; l < n; ++l)
                    a[indice[i]][l] -= pj * a[indice[j]][l];
            }
        }
    }

    private static double[][] generarBetas(double x[][], double y[][]) {
        int nx = x[0].length;
        double[][] matrizTras = transponerMatriz(x);
        double[][] multiplicadorA = multiplicacion(matrizTras, x);
        double[][] inversa = inversa(multiplicadorA, nx);
        double[][] multiplicadorB = multiplicacion(inversa, matrizTras);
        double[][] resultado = multiplicacion(multiplicadorB, y);
        return resultado;
    }


}
