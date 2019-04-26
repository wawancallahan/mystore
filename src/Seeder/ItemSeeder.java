/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seeder;

import Lib.BarangLib;
import Model.Barang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timy
 */
public class ItemSeeder {
    protected Barang barangModel;
    
    String[] itemNama = {
        "Scallop Minaku 500gr",
        "Maiyonaise Maestro 1kg",
        "Saos Hot One 1kg",
        "Saos sachet delmonte isi 24 pcs",
        "Saos botol Delmonte extra hot",
        "Saos tomat Mc Lewis 1kg",
        "Maiyonaise Mayo Mc lewis 1kg",
        "Otak2 athien",
        "Nugget Champ 250gr",
        "Sosis champ isi 15pcs",
        "Sosis champ isi 40pcs",
        "Champ Crispy Burger isi 6 pcs",
        "Siomay umami rasa ayam isi 15",
        "Sosis mini kimbo keju isi 10",
        "Minipao weiwang coklat/kcg hijau",
        "Kornet Max",
        "Goldstar Katsu 500gr",
        "Cedea baso ikan 500gr",
    };
    
    String[] itemJenis = {
        "Scallop",
        "Maiyonaise",
        "Saos",
        "Saos",
        "Saos",
        "Saos",
        "Maiyonaise",
        "Otak2",
        "Nugget",
        "Sosis",
        "Sosis",
        "Burger",
        "Siomay",
        "Sosis",
        "Minipao",
        "Kornet",
        "Katsu",
        "Cedea"
    };
    
    String[] itemHarga = {
        "17000",
        "28000",
        "12000",
        "7500",
        "6500",
        "11500",
        "26000",
        "5000",
        "15000",
        "14000",
        "34000",
        "14000",
        "17000",
        "30000",
        "14000",
        "13000",
        "32000",
        "24000"
    };
    
    public ItemSeeder() {    
        barangModel = new Barang();
       
        seed();
    }
    
    public void seed() {
        try {
            
            String randomNumber = String.valueOf(getRandomNumberInRange(1, 99999));
            
            for( int i = 0; i < itemNama.length - 1; i++)
            {
                List<String> request = new ArrayList<>();
                request.add(randomNumber + String.valueOf(i)); // kode
                request.add(itemNama[i]); // nama
                request.add(itemJenis[i]); // jenis
                request.add(itemHarga[i]); // harga
                request.add("1000"); // qty

                barangModel.create(request);
            }

            System.out.println("Seeder Barang Berhasil");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
        }

        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    
    public static void main(String args[]) {
        new ItemSeeder();
    }
}
