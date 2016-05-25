/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package macobserver;

/**
 *
 * @author 광민
 */
public class WheatherStation {
    public static void main(String[] args) {
        MyStore weatherData = new MyStore();
        MyStore Data = new MyStore();
        
        KoreaHeadOffice currentDisplay =
                new KoreaHeadOffice(weatherData);
        
        weatherData.setMeasurements(80, 65, 30);
        
        WorldHeadOffice worldDisplay = 
                new WorldHeadOffice(Data);
        Data.setMeasurements(78, 70, 29);
    }
}
