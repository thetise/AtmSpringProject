package com.project.atm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "transfers")
@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "senderId", nullable = false)
    @JsonIgnore
    User userSender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverId", nullable = false)
    @JsonIgnore
    User userReceiver;

    Long amount;


    //İLK TRANSFER İŞLEMİMİZ GERÇEKLEŞTİRİLDİ AMA 1 KERE OLDU BU İŞ BU HATANIN ONETOONE HİBERNATE İLİŞKİSİNDEN DOLAYI KAYNAKLANDIĞINI
    // DÜŞÜNÜYORUM BUNUNLA TEKRARDAN İLGİLENECEĞİM.

    //İLİŞKİYİ ONETOONE OLARAK KURMUŞTUK SONRA MANYTOONE A CEKTİK AMA CALISMADI DAHA SONRA TABLE'LARI SİLİP YENİDEN CREATE EDİNCE
    // MANYTOONE ÇALIŞTI.
}
