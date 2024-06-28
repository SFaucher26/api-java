package fr.simplon.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


    @Entity
    @Data
    @RequiredArgsConstructor()
       public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NonNull
        private String name;

        @NonNull
        private Float price;

        public Product(){}
    }

