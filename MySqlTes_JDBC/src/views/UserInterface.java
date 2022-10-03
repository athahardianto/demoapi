package views;


import com.mysql.jdbc.Connection;
import controllers.concretes.RegionController;
import java.util.Scanner;
import models.Region;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author athab
 */
public class UserInterface {
    private int pilihan;
    private Connection connection;
    private RegionController rc;
    
    public UserInterface(Connection connection){
        rc = new RegionController(connection);
    }
    
    public void garis(){
    for(int x=0; x<16; x++ ){
            System.out.print("-");
        }
        System.out.println("");
}
    
    public void Menu(){
        for(int x=0; x<4; x++ ){
            System.out.print("-");
        }
        System.out.print("MENU CRUD");
        
        for(int x=0; x<4; x++ ){
            System.out.print("-");
        }
        System.out.println("");
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("1. Tambah data");
        System.out.println("2. Tampilkan semua data");
        System.out.println("3. Tampilkan data berdasar ID");
        System.out.println("4. Ubah data");
        System.out.println("5. Hapus data");
        System.out.println("6. Exit");
        System.out.print("Pilih: ");
        this.pilihan = keyboard.nextInt();
        
        switch(Pilih()){
            case 1:
                garis();
                Tambah();
                break;
            case 2:
                garis();
                TampilAll();
                break;
            case 3:
                garis();
                TampilId();
                break;
            case 4:
                garis();
                Ubah();
                break;
                
            case 5:
                garis();
                Hapus();
                break;
                
            case 6:
                garis();
                exit();
                break;
             default:
                 garis();
                 System.out.println("Invalid");;
        }
    }
    
    public void lain(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Kembali ke menu");
        System.out.println("2. Keluar");
        System.out.print("Pilih: ");
        this.pilihan = keyboard.nextInt();
        
        switch(Pilih()){
            case 1:
                garis();
                Menu();
                break;
            case 2:
                garis();
                exit();
                break;
            default:
                garis();
                System.out.println("Invalid");;
        }
    }
    
    public void exit(){
        System.out.println("Terimakasih !");
    }
    
    public int Pilih(){
        return pilihan;
    }
    
    public void Tambah(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan Nama: ");
        String nama = keyboard.nextLine();
        System.out.println(rc.insert("0", nama));
        garis();
        lain();
    }
    
    public void TampilAll(){
        System.out.println("Semua Data");
        for(Region tes: rc.getAll()){
            System.out.println(tes.getRegionId()+". "+tes.getRegionName());
        }
        garis();
        lain();
    }
    
    public void TampilId(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan ID: ");
        int data = keyboard.nextInt();
        Region tes = rc.getById(data);
        System.out.println("Data ID-" + data);
        System.out.println(tes.getRegionId()+". "+tes.getRegionName());
        garis();
        lain();
        
    }
    
    public void Ubah(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan ID: ");
        String id = keyboard.nextLine();
        System.out.print("Masukkan Nama Baru: ");
        String nama = keyboard.nextLine();
        System.out.println(rc.update(id, nama));
        garis();
        lain();
    }
    
    public void Hapus(){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Masukkan ID: ");
        String id = keyboard.nextLine();
        System.out.println(rc.delete(id));
        garis();
        lain();
    }
}
