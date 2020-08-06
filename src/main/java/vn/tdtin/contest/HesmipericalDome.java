package vn.tdtin.contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class HesmipericalDome {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        String inputValue [] = inputText.split(" ");
        final double H2 = Math.pow(Float.parseFloat(inputValue[0]) / 2.0,2);
        final double A2 = Math.pow(Float.parseFloat(inputValue[1]) , 2);

        final double R2 = H2*A2/(A2 + H2);

        DecimalFormat df = new DecimalFormat("0.0000");
        String result = df.format(Math.sqrt(R2));
        System.out.println(result);
    }
}
