package com.example.ekombi;

public class Kontrol {

    int hedefSicaklik = 20;

    public void sicaklikArtir()
    {
        hedefSicaklik++;
    }

    public void sicaklikAzalt()
    {
        hedefSicaklik--;
    }


    public void kombiyiKapat()
    {
        hedefSicaklik = 5;
    }
}
