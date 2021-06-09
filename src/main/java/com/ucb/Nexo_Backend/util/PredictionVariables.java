package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.dto.LinealRequest;
import com.ucb.Nexo_Backend.dto.PredictionRequest;
import com.ucb.Nexo_Backend.models.CountryCases;
import com.ucb.Nexo_Backend.models.DepartmentCases;
import com.ucb.Nexo_Backend.models.MunicipalityCases;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PredictionVariables {
    private static float getVarianza(int p,double[][] x,double[][] y, double[][] beta){
        float resultado = 0 ;
        int n = x.length;
        double[][] multiplicacionXB = multiplicacion(x,beta);
        double[][] primerMulti = restaMatriz(y,multiplicacionXB);
        double[][] traspuesta = transponerMatriz(primerMulti);
        double[][] aux = multiplicacion(traspuesta,primerMulti);
        resultado = (float) (aux [0][0]/(n-p));
        return resultado;
    }
    private static float sumaTerminos(double[][] matrizA) {
        double promedio = 0;
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                promedio = matrizA[i][j]*matrizA[i][j] + promedio;
            }

        }
        return (float)promedio;
    }
    private static float getR2(double[][] x,double[][] y, double[][] beta){
        double[][] promedio = matrizUno(y);
        double[][] VT = restaMatriz(y,promedio);
        double[][] primer = multiplicacion(x,beta);
        double[][] VE = restaMatriz(primer,promedio);
        return sumaTerminos(VE)/sumaTerminos(VT);
    }
    public static LinealRequest generarBetasDepartament(List<DepartmentCases> listcases, Integer filter) {
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] x = new double[mx][nx];
        double[][] y = new double[mx][ny];
        Calendar c = Calendar.getInstance();
        int indice = 0;
        for (DepartmentCases departmentCases : listcases) {
            x[indice][0] = 1;
            x[indice][1] = indice + 1;
            if (filter == 0) {
                y[indice][0] = departmentCases.getNewCases();
            } else if (filter == 1) {
                y[indice][0] = departmentCases.getDeaths();
            } else if (filter == 2) {
                y[indice][0] = departmentCases.getRecovered();
            }
            indice = indice + 1;
        }
        double[][] matrizTras = transponerMatriz(x);
        double[][] multiplicadorA = multiplicacion(matrizTras, x);
        double[][] inversa = inversa(multiplicadorA, nx);
        double[][] multiplicadorB = multiplicacion(inversa, matrizTras);
        double[][] resultado = multiplicacion(multiplicadorB, y);
        LinealRequest linealRequest = new LinealRequest();
        linealRequest.setB0((float) resultado[0][0]);
        linealRequest.setB1((float) resultado[1][0]);
        float varianza = getVarianza(2,x,y,resultado);
        linealRequest.setO2(varianza);
        linealRequest.setO((float) Math.sqrt(Math.abs(varianza)));
        linealRequest.setR2(getR2(x,y,resultado));
        return linealRequest;
    }
    public static LinealRequest generarBetasMunicipios(List<MunicipalityCases> listcases, Integer filter) {
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] x = new double[mx][nx];
        double[][] y = new double[mx][ny];
        int indice = 0;
        for (MunicipalityCases municipalityCases : listcases) {
            x[indice][0] = 1;
            x[indice][1] = indice + 1;
            if (filter == 0) {
                y[indice][0] = municipalityCases.getNewCases();
            } else if (filter == 1) {
                y[indice][0] = municipalityCases.getDeaths();
            } else if (filter == 2) {
                y[indice][0] = municipalityCases.getRecovered();
            }
            indice = indice + 1;
        }
        double[][] matrizTras = transponerMatriz(x);
        double[][] multiplicadorA = multiplicacion(matrizTras, x);
        double[][] inversa = inversa(multiplicadorA, nx);
        double[][] multiplicadorB = multiplicacion(inversa, matrizTras);
        double[][] resultado = multiplicacion(multiplicadorB, y);
        LinealRequest linealRequest = new LinealRequest();
        linealRequest.setB0((float) resultado[0][0]);
        linealRequest.setB1((float) resultado[1][0]);
        float varianza = getVarianza(2,x,y,resultado);
        linealRequest.setO2(varianza);
        linealRequest.setO((float) Math.sqrt(Math.abs(varianza)));
        linealRequest.setR2(getR2(x,y,resultado));
        return linealRequest;
    }
    public static LinealRequest generarBetasCountry(List<CountryCases> listcases, Integer filter) {
        List<PredictionRequest> listprediction = new ArrayList<>();
        int mx = listcases.size();
        int nx = 2;
        int ny = 1;
        double[][] x = new double[mx][nx];
        double[][] y = new double[mx][ny];
        int indice = 0;
        for (CountryCases countryCases : listcases) {
            x[indice][0] = 1;
            x[indice][1] = indice + 1;
            if (filter == 0) {
                y[indice][0] = countryCases.getNewCases();
            } else if (filter == 1) {
                y[indice][0] = countryCases.getDeaths();
            } else if (filter == 2) {
                y[indice][0] = countryCases.getRecovered();
            }
            indice = indice + 1;
        }
        double[][] matrizTras = transponerMatriz(x);
        double[][] multiplicadorA = multiplicacion(matrizTras, x);
        double[][] inversa = inversa(multiplicadorA, nx);
        double[][] multiplicadorB = multiplicacion(inversa, matrizTras);
        double[][] resultado = multiplicacion(multiplicadorB, y);
        LinealRequest linealRequest = new LinealRequest();

        linealRequest.setB0((float) resultado[0][0]);
        linealRequest.setB1((float) resultado[1][0]);
        float varianza = getVarianza(2,x,y,resultado);
        linealRequest.setO2(varianza);
        linealRequest.setO((float) Math.sqrt(Math.abs(varianza)));
        linealRequest.setR2(getR2(x,y,resultado));
        return linealRequest;
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
    private static double[][] restaMatriz(double[][] matrizA,double[][] matrizB) {
        double[][] transpuesta = new double[matrizA.length][matrizA[0].length];
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                transpuesta[i][j] = matrizA[i][j]-matrizB[i][j];
            }

        }
        return transpuesta;
    }
    private static void imprimirMatriz(double[][] matrizA) {
      for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                System.out.print(matrizA[i][j]+" ");
            }

            System.out.println();

        }
    }
    private static float promedio(double[][] matrizA) {
        float promedio = 0;
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
               promedio = promedio + (float) matrizA [i][j];
            }

        }
        return promedio;
    }
    private static double[][] matrizUno(double[][] matrizA) {
        double[][] transpuesta = new double[matrizA.length][matrizA[0].length];
        float promedio=promedio(matrizA);
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[i].length; j++) {
                transpuesta[i][j] = promedio;
            }

        }
        return transpuesta;
    }





}
